package model;

public class Level {
	
	private Level next;
	private Level prev;
	
	
	
	public Level() {
		
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
	
}
