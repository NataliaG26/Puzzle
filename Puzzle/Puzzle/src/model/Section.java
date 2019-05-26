package model;

public class Section {
	
	private int startWidth;
	private int startHight;
	private int finishWidth;
	private int finishHight;
	
	public Section(int startWidth, int startHight, int finishWidth, int finishHight) {
		this.startWidth = startWidth;
		this.startHight = startHight;
		this.finishWidth = finishWidth;
		this.finishHight = finishHight;
	}
	
	
	public int getStartWidth() {
		return startWidth;
	}
	public void setStartWidth(int startWidth) {
		this.startWidth = startWidth;
	}
	public int getStartHight() {
		return startHight;
	}
	public void setStartHight(int startHight) {
		this.startHight = startHight;
	}
	public int getFinishWidth() {
		return finishWidth;
	}
	public void setFinishWidth(int finishWidth) {
		this.finishWidth = finishWidth;
	}
	public int getFinishHight() {
		return finishHight;
	}
	public void setFinishight(int finishight) {
		this.finishHight = finishight;
	}

}
