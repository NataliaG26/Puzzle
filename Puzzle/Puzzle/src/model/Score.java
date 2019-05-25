package model;

import java.io.Serializable;

public class Score implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String totaltime;
	private long currentTime;
	private Score right,left;
	
	public Score(String totaltime, long currentTime) {
		this.totaltime = totaltime;
		this.currentTime = currentTime;
		right=null;
		setLeft(null);
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
	
}
