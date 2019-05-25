package model;

import java.util.ArrayList;

public class Scene {
	
	private Player firstPlayer;
	private Score rootScore;
	private Level firstLevel;
	private ArrayList <Score> scoresvector;
	
	public Scene() {
		firstPlayer=null;
		rootScore=null;
		firstLevel=null;
	}
	
	public void addPlayer(Player e) {
		if (firstPlayer==null) {
			firstPlayer=e;
		} else 
			addPlayer(e,firstPlayer);
	}
	
	public void addPlayer(Player e, Player root) {
		if(root.compareTo(e)>1) {
			if(root.getLeft()==null)
				root.setLeft(e);
			else
				addPlayer(e,root.getLeft());
		}
		else
			if(root.getRight()==null)
				root.setRight(e);
			else
				addPlayer(e,root.getRight());
	}
	
	public Player searchPlayer(String n) {
		if(n.equals(firstPlayer.getName())){
			return firstPlayer;
		} 
		else
;			return searchPlayer(n,firstPlayer);
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
		else 
			addScore(r,rootScore);
	}
	
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
	}
	
	public void chargeScores(Score current) {
		current = rootScore;
		while(current!=null) {
			scoresvector.add(current);
			
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
	public Level getFirstLevel() {
		return firstLevel;
	}
	public void setFirstLevel(Level firstLevel) {
		this.firstLevel = firstLevel;
	}

	public ArrayList <Score> getScoresvector() {
		return scoresvector;
	}

	public void setScoresvector(ArrayList <Score> scoresvector) {
		this.scoresvector = scoresvector;
	}
	
	

}
