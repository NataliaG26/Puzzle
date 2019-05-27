package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Score score;
	private Player left;
	private Player right;
	private ArrayList<String> keys;

	public Player(String name) {
		this.name = name;
		setKeys(new ArrayList<String>());
	}
	
	public void addKey(String key) {
		keys.add(key);
	}
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}
 void setScore(Score score) {
		this.score = score;
	}

	public int compareTo(Player p) {
		return p.getName().compareTo(name);
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	
	public Player getRight() {
		return right;
	}


	public void setRight(Player right) {
		this.right = right;
	}


	public ArrayList<String> getKeys() {
		return keys;
	}


	public void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}
	
	
	
}
