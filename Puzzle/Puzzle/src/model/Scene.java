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
	
	
	public Scene() {
		
	}
	
	public void checkKey() {
		
	}
	
	public void createLevel() {
		
	}
	/*
	 * retorna un arrailist con los nombres de los jugadores
	 */
	public ArrayList<String> getPlayersName(){
		ArrayList<String> list = new ArrayList<String>();
		if(firstPlayer != null) {
			list = firstPlayer.playersName(list);
		}
		return list;
	}
	
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

	public void selectedPlayer(String name) {
		player = searchPlayer(name);
	}
	
	/*
	 * busca un jugador por el nombre, si no lo encuentra
	 * lanza una excepcion 
	 */
	public Player searchPlayer(String n) {
		Player player = null;
		if(firstPlayer != null) {
			player = firstPlayer.searchPlayer(n);
		}
		//si es null no lo encontro
		return player;
	}
	
	public Player searchPlayer(String n,Player r) {
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
		else
		return null;
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
