package model;

public class Scene {
	
	private Player firstPlayer;
	private Score rootScore;
	private Level firstLevel;
	
	public Scene() {
		
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
	
	

}
