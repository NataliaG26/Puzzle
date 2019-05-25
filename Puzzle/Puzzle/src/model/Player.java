package model;

import java.io.Serializable;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Score score;
	private Player left,right;

	public Player(String name) {
		this.name = name;
		score =null;
		left=null;
		right=null;
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
	
	
	
	
}
