package model;

public class Level {
	
	private Level next;
	private Level prev;
	private String [] position;
	
	
	public Level() {
		setPosition(new String [8]);
	}
	
	public void loadLevel() {
		
	}

	public Level getNext() {
		return next;
	}

	public void setNext(Level next) {
		this.next = next;
	}

	public Level getPrev() {
		return prev;
	}

	public void setPrev(Level prev) {
		this.prev = prev;
	}

	public String [] getPosition() {
		return position;
	}

	public void setPosition(String [] position) {
		this.position = position;
	}
	
}
