package model;

import java.io.Serializable;

public class Score implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String totaltime;
	private long currentTime;
	private Score right,left;
	private Player player;
	private String name;
	
	public Score(Player r, long c) {
		totaltime = makeLongString(c);
		this.currentTime = c;
		setPlayer(r);
		setName(r.getName());
		right=null;
		setLeft(null);
	}
	
	public String makeLongString(Long currentTime) {
		long hora = currentTime/3600000;
		Long estohora = currentTime%3600000;
		Long minuto = estohora/60000;
		Long restominuto = estohora%60000;
		return "time:"+hora+":"+minuto+":"+restominuto;
		
	}
	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	public Score getRight() {
		return right;
	}

	public void setRight(Score right) {
		this.right = right;
	}

	public Score getLeft() {
		return left;
	}

	public void setLeft(Score left) {
		this.left = left;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
