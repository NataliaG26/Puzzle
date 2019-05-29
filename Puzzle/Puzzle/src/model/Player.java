package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Player left;
	private Player right;
	private Boolean flag;
	private Score rootScore;
	private ArrayList<String> keys;

	/** Player class builder.
	 * @param name -is the name of the player- </Pre> name!=null.
	 */
	public Player(String name) {
		this.name = name;
		rootScore=null;
		setKeys(new ArrayList<String>());
	}
	
	/** Adds a key to the player list of keys (ArrayList).
	 * @param key -the id of the level necessary to unlock more levels-</Pre> key!=null.
	 */
	public void addKey(String key) {
		keys.add(key);
	}
	
	/** Return the list of the players names.
	 * @param list -list of players in the game- 
	 * @return a list of players names.
	 */
	public ArrayList<String> playersName(ArrayList<String> list){
		list.add(this.name);
		if(left != null) {
			list = left.playersName(list);
		}
		if(right != null) {
			list = right.playersName(list);
		}
		return list;
	}
	
	/** Adds a player to the linked list of players.
	 * @param name -the name of the player that's going to be added, technically thats all we need to add a player- </Pre> name!=null.
	 * @return true if the player was added false if the name is repeated
	 */
	public boolean addPlayer(String name) {
		boolean add = false;
		int dif = name.compareTo(this.name);
		if(dif < 0) {
			if(left != null) {
				left.addPlayer(name);
				add = !add;
			}else {
				left = new Player(name);
				add = !add;
			}
		}else if(dif > 0){
			if(right != null) {
				right.addPlayer(name);
				add = !add;
			}else {
				right = new Player(name);
				add = !add;
			}
		}
		return add;
	}
	
	/** Search a player in the linked list.
	 * @param name -the name of the player that is going to be searched- </Pre> name!=null.
	 * @return the player with the name or null if the player was not found.
	 */
	public Player searchPlayer(String name) {
		Player player = null;
		int dif = this.name.compareTo(name);
		if(dif == 0) {
			player = this;
		}else if(dif < 0) {
			player = left.searchPlayer(name);
		}else {
			player = right.searchPlayer(name);
		}
		return player;
	}
	
	/** Adds an score to the scores three
	 * @param r -the score that is going to be added- </Pre> r!=null.
	 */
	public void addScore(Score r) {
		if(rootScore==null) 
			rootScore=r;
		else 
			rootScore.addScore(r);
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the left
	 */
	public Player getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(Player left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public Player getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(Player right) {
		this.right = right;
	}
	/**
	 * @return the flag
	 */
	public Boolean getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	/**
	 * @return the keys
	 */
	public ArrayList<String> getKeys() {
		return keys;
	}
	/**
	 * @param keys the keys to set
	 */
	public void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}
	/**
	 * @return the rootScore
	 */
	public Score getRootScore() {
		return rootScore;
	}
	/**
	 * @param rootScore the rootScore to set
	 */
	public void setRootScore(Score rootScore) {
		this.rootScore = rootScore;
	}	
}
