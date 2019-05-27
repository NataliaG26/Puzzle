package model;

public class Section {
	
	private int startWidth;
	private int startHight;
	private int width;
	private int hight;
	private int id;
	
	public Section(int startWidth, int startHight, int width, int hight, int id) {
		this.startWidth = startWidth;
		this.startHight = startHight;
		this.setWidth(width);
		this.setHight(hight);
		this.id = id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
}
