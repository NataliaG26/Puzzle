package model;

import java.util.ArrayList;

import exceptions.PLayerNotFoundException;

public class Scene {
	
	private Player firstPlayer;
	private Score rootScore;
	private Category firstCategory;
	private ArrayList <Score> scoresvector;
	
	public Scene() {
		firstPlayer = null;
		rootScore=null;
		firstCategory=null;
		scoresvector = new ArrayList<Score>();
		Player l = new Player("Duvi");
		Score r = new Score(l,1232131253);
		scoresvector.add(r);
	}
	
	public void createLevel() {
		
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
	
	public Player searchPlayer(String n) throws PLayerNotFoundException {
		if(n.equals(firstPlayer.getName())){
			return firstPlayer;
		} 
		else
;			return searchPlayer(n,firstPlayer);
	}
	
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
		else
		 throw new PLayerNotFoundException(n);
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
	
	public void refreshScores() {
		if(scoresvector.isEmpty())
			this.chargeScores(rootScore);
		else {
		scoresvector.clear();
		chargeScores(rootScore);
		}
	}
	
	public void chargeScores(Score current) {
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
	

	public ArrayList <Score> getScoresvector() {
		return scoresvector;
	}

	public void setScoresvector(ArrayList <Score> scoresvector) {
		this.scoresvector = scoresvector;
	}

	public Category getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(Category firstCategory) {
		this.firstCategory = firstCategory;
	}
	
	

}
