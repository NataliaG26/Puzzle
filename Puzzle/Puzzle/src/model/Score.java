package model;

import java.io.Serializable;

public class Score implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String totaltime;
	private long currentTime;
	private Score right,left;
	private Player player;
	private String name;
	
	/** Builder of the class Score.
	 * @param currentTime -the time that the Score of the player has- </Pre>  currentTime!=null.
	 */
	public Score(Long currentTime) {
		totaltime = makeLongString(currentTime);
		this.currentTime = currentTime;
		this.right=null;
		this.setLeft(null);
	}
	
	public void addScore(Player player, long score) {
		if(score >= currentTime) {
			if(right== null) {
				right = new Score(score);
				right.setPlayer(player);
			}else {
				right.addScore(player, score);
			}
		}else {
			if(left== null) {
				left = new Score(score);
				left.setPlayer(player);
			}else {
				left.addScore(player, score);
			}
		}
	}
	
	/** Converts the long into a time message in format hh/mm/ss.
	 * @param currentTime -the long that is going to be turn into a string- </Pre>  currentTime!=null.
	 * @return the hour in format hh/mm/ss.
	 */
	public String makeLongString(Long currentTime) {
		long hora = currentTime/3600000;
		Long estohora = currentTime%3600000;
		Long minuto = estohora/60000;
		Long restominuto = estohora%60000;
		return "time:"+hora+":"+minuto+":"+restominuto;
		
	}
	
	/** Method to add an Score to the actual player in the three
	 * @param name -the score that is going to be added- </Pre> name!=null.
	 */
	public void addScore(Score name) {
		int dif = name.getTotaltime().compareTo(this.totaltime);
		if(dif < 0) {
			if(left != null) 
				left.addScore(name);
			else 
				left = name;
		}else if(dif > 0){
			if(right != null) {
				right.addScore(name);
			}else {
				right = name;
			}
		}
	}

	/**
	 * @return the totaltime
	 */
	public String getTotaltime() {
		return totaltime;
	}

	/**
	 * @param totaltime the totaltime to set
	 */
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}

	/**
	 * @return the currentTime
	 */
	public long getCurrentTime() {
		return currentTime;
	}

	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	/**
	 * @return the right
	 */
	public Score getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Score right) {
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public Score getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Score left) {
		this.left = left;
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
	
}
