package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.LevelNotUnlockedException;
import exceptions.PLayerNotFoundException;
import threads.PuzzleLoaderThread;

public class Scene {
	
	private Player firstPlayer;
	private Category firstCategory;
	private Player player;
	
	
	/** Class Builder 
	 */
	public Scene() {
	
	}
	
	public void changeFlag(String levelName, String categoryName) {
		firstCategory.changeFlag(levelName, categoryName);
	}
	
	public boolean checkKey(String levelName, String category) {
		String key = searchLevelKey(levelName, category);
		return (player.getKeys().contains(key));
	}
	
	public String searchLevelKey(String levelName, String category) {
		return firstCategory.searchLevelKey(levelName, category);
	}
	/*
	public void createLevel() {
		firstCategory.loadLevel();
	}*/
	
	public void addKey() {
		if(player.getKeys().size()==0) {
			player.setKeys(firstKeys());
		}
	}
	
	public int[] getInfoSection(int r, int c) {
		int[] inf = firstCategory.getInfoSection(r, c);
		return inf;
	}
	
	public void loadPuzzle(int width, int hight) {
		firstCategory.loadPuzzle(width, hight);
	}
	
	
	public String getImage(){
		String  image = firstCategory.searchImageFlag();
		return image;
	}
	
	public ArrayList<String> firstKeys() {
		ArrayList<String> keys = new ArrayList<String>();
		if(firstCategory!= null) {
			keys = firstCategory.firstKeys(keys);
		}
		return keys;
	}
	
	/** This method returns a list of the players name
	 * @return an ArrayList with the players names. 
	 */
	public ArrayList<String> getPlayersName(){
		ArrayList<String> list = new ArrayList<String>();
		if(firstPlayer != null) {
			list = firstPlayer.playersName(list);
		}
		return list;
	}
	
	/** Loads the categories of the game from a file.
	 * @throws IOException
	 */
	public void loadCategorys() {
		BufferedReader b;
		try {
			b = new BufferedReader(new FileReader(Category.pathNames));
			String line;
			while((line=b.readLine())!=null) {	
				Category w = new Category(line);
				w.loadLevelslevels();
				this.addCategory(w);
			}
			b.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 */
	public void loadGame(String levelName, String categoryName) throws LevelNotUnlockedException {
		if(checkKey(levelName, categoryName)) {
			changeFlag(levelName, categoryName);
		}else {
			throw new LevelNotUnlockedException();
		}
		
	}
	
	/** Tries to add a new player to the linked list.
	 * @param name creates a new player -added this player if it's possible- <Pre/>name!=null && name can't be repeated.
	 */
	public void addPlayer(String name) {
		
		boolean add = false;
		if (firstPlayer==null) {
			firstPlayer=new Player(name);
			add = !add;
		} else {
			firstPlayer.addPlayer(name);
			add = !add;
		}
		if(!add) {
			//throws new SameNameException();
		}
	}

	/** Search in the linked list the selected player of the interface.
	 * @param name -the name that is going to be searched- <Pre/>name!=null
	 */
	public void selectedPlayer(String name) {
		player = searchPlayer(name);
		loadCategorys();
	}
	
	

	/** Search in the linked list the selected player of the interface.
	 * @param name -the name that is going to be searched- <Pre/>name!=null
	 * @throws PlayerNotFoundException if the player is not found.
	 */
	public Player searchPlayer(String n) {
		Player player = null;
		if(firstPlayer != null) {
			player = firstPlayer.searchPlayer(n);
		}
		//si es null no lo encontro
		return player;
	}
	
	/** Search in the linked list the selected player of the interface.
	 * @param n -the name that is going to be searched- <Pre/>name!=null.
	 * @param r -the reference of player that is use to look in the three- <Pre/>r!=null.
	 * @return the Player if it's found or
	 * @throws PLayerNotFoundException 
	 * @throws PlayerNotFoundException if the player is not found.
	 */
	public Player searchPlayer(String n,Player r) throws PLayerNotFoundException {
		if(r.getLeft()!=null) {
			if(n.equals(r.getLeft().getName())) {
				return r.getLeft();
			}
			else
				return searchPlayer(n,r.getLeft());
		}else if(r.getRight()!=null) {
			if(n.equals(r.getRight().getName())) {
				return r.getRight();
			}
			else
				return searchPlayer(n,r.getRight());
		}
		else {
			throw new PLayerNotFoundException(n);
		}
		
	}
	
	
	/** Adds an category to the linked list of categories.
	 * @param c -the category that is going to be added- <Pre:/> c!=null.
	 */
	public void addCategory(Category c) {
		if(firstCategory==null) {
			firstCategory=c;
		} 
		else {
			addCategory(c,this.firstCategory);
		}
	}
	
	
	/** Adds an category to the linked list of categories.
	 * @param c -the category that is going to be added- <Pre:/> c!=null.
	 * @param reference -the node use to reference the position in the three- <Pre:/> reference!=null.
	 */
	public void addCategory(Category c,Category reference) {
		if(reference.getNext()==null) {
			reference.setNext(c);
			c.setPrev(reference);
		} 
		else
			addCategory(c,reference.getNext());
	}
	
	/*
	 * 
	 */
	
	public Category searchCategory(String name) {
		Category cat = null;
		if(firstCategory != null) {
			cat = firstCategory.getCategory(name);
		}
		return cat;
	}
	public ArrayList<String> getCategories(){
		ArrayList<String> list = new ArrayList<String>();
		if(firstCategory != null) {
			list = firstCategory.categoriesExistens(list);
		}
		return list;
	}
	
	public ArrayList<String> getLevelsCategory(String nameCategory){
		ArrayList<String> list = new ArrayList<String>();
		if(firstCategory != null) {
			list = firstCategory.getLevels(nameCategory);
			System.out.println("scene");
		}
		return list;
	}
	
	

	/**
	 * @return the firstPlayer
	 */
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	/**
	 * @param firstPlayer the firstPlayer to set
	 */
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * @return the firstCategory
	 */
	public Category getFirstCategory() {
		return firstCategory;
	}

	/**
	 * @param firstCategory the firstCategory to set
	 */
	public void setFirstCategory(Category firstCategory) {
		this.firstCategory = firstCategory;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
}
