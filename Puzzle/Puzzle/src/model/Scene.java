package model;

import java.util.ArrayList;

import exceptions.PLayerNotFoundException;

public class Scene {
	
	private Player firstPlayer;
	private Score rootScore;
	private Category firstCategory;
	private Player player;
	//private ArrayList <Score> scoresvector;
	
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
		if(rootScore==null) {
			rootScore=r;
		}
		else {
			
		}
			//addScore(r,rootScore);
	}
	/*
	public void addScore(Score r, Score root) {
		if(r.getCurrentTime()<root.getCurrentTime()) {
			if(root.getLeft()==null) 
				root.setLeft(r);
			 else
				addScore(r,root.getLeft());
		} else
			if(root.getRight()==null)
				root.setRight(r);
			else
				addScore(r,root.getRight());
	}*/
	
	public void chargeScores(Score current) {
		current = rootScore;
		while(current!=null) {
			//scoresvector.add(current);
			
			chargeScores(current.getLeft());
			chargeScores(current.getRight());
		}
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
	/*
	public ArrayList <Score> getScoresvector() {
		return scoresvector;
	}
	public void setScoresvector(ArrayList <Score> scoresvector) {
		this.scoresvector = scoresvector;
	}*/
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
