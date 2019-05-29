package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exceptions.PLayerNotFoundException;

public class Scene {
	
	private Player firstPlayer;
	private Category firstCategory;
	private Player player;
	
	
	/** Class Builder 
	 */
	public Scene() {}
	
	public void selectedLevel(String nameLevel) {
		firstCategory.selectedLevel(nameLevel);
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
	
	public void resetLevels() {
		firstCategory.resetLevels();
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
	
	public void savePlayers() {
		ObjectOutputStream escribiendoFichero;
		try {
			escribiendoFichero = new ObjectOutputStream(new FileOutputStream("../data/Players.txt") );
			escribiendoFichero.writeObject(firstPlayer);
            escribiendoFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
	
	public void loadPlayers() {
		ObjectInputStream leyendoFichero;
		try {
			leyendoFichero = new ObjectInputStream(new FileInputStream("../data/Players.txt") );
			firstPlayer = (Player)leyendoFichero.readObject();
            leyendoFichero.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	            
	}
	
	public boolean verifiGame(int[][] puzzleID) {
		return currentCategory().currentLevel().verifiGame(puzzleID);
	}

	public void levelSelected(String nameLevel) {
		firstCategory.selectedLevel(nameLevel);
	}
	
	public int loadImage(int width, int hight) {
		return currentCategory().currentLevel().loadImage(width, hight);
	}
	
	public String getImage() {
		return currentCategory().currentLevel().getImage();
	}
	
	public int[] getDimentions(int row, int column) {
		currentCategory().currentLevel().loadSections();
		return currentCategory().currentLevel().getInfoSection(row, column);
	}
	
	public Category currentCategory() {
		Category current = firstCategory;
		boolean find = false;
		while(!find) {
			if(current.getFlag()) {
				find = true;
			}else {
				current = current.getNext();
			}
		}
		return current;
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
			firstCategory.addCategory(c);
		}
	}
	
	public Category searchCategory(String name) {
		Category act = firstCategory;
		boolean find = false;
		while(!find) {
			if(act.getName().equals(name)) {
				find = true;
			}else {
			act = act.getNext();
			}
		}
		return act;
	}
	
	public ArrayList<String> getCategories(){
		ArrayList<String> list = new ArrayList<String>();
		if(firstCategory != null) {
			list = firstCategory.categoriesExistens(list);
		}
		return list;
	}
	
	public ArrayList<String> getLevelsCategory(String nameCategory){
		return searchCategory(nameCategory).getLevelsName();
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
