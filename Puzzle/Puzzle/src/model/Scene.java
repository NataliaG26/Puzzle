package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.PLayerNotFoundException;

public class Scene {
	
	private Player firstPlayer;
	private Score rootScore;
	private Category firstCategory;
	private Player player;
	
	
	/** Class Builder 
	 */
	public Scene() {
	
	}
	
	public void checkKey() {
	}
	
	public void createLevel() {
		
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
	public void loadCategorys() throws IOException {
		BufferedReader b = new BufferedReader(new FileReader(Category.pathNames));
		String line;
		while((line=b.readLine())!=null) {	
			this.addCategory(new Category(line));
		}
		b.close();
	}
	

	/*
	 * intenta agregar un nuevo jugador, en orden segun el nombre
	 * crea al jugador cuando lo va a agregar
	 */
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
	
	public void addScore(Score r) {
		if(rootScore==null) 
			rootScore=r;
		else 
			addScore(r,this.rootScore);
	}
	
	public void addScore(Score r, Score root) {
		if(r.getCurrentTime()>root.getCurrentTime()) {
			if(root.getLeft()==null) 
				root.setLeft(r);
			 else
				addScore(r,root.getLeft());
		} else
			if(root.getRight()==null)
				root.setRight(r);
			else
				addScore(r,root.getRight());
	}
	
	public void addCategory(Category c) {
		if(firstCategory==null) {
			firstCategory=c;
		} 
		else {
			addCategory(c,this.firstCategory);
		}
	}
	public void addCategory(Category c,Category reference) {
		if(reference.getNext()==null) {
			reference.setNext(c);
			c.setPrev(reference);
		} 
		else
			addCategory(c,reference.getNext());
	}
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public Score getRootScore() {
		return rootScore;
	}
	public void setRootScore(Score rootScore) {
		this.rootScore = rootScore;
	}

	public Category getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(Category firstCategory) {
		this.firstCategory = firstCategory;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	

}
