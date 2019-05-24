package model;

public class PrincipalPlayer {

	private PrincipalPlayer next;
	private PrincipalPlayer prev;
	
	public PrincipalPlayer() {
		
	}

	public PrincipalPlayer getNext() {
		return next;
	}

	public void setNext(PrincipalPlayer next) {
		this.next = next;
	}

	public PrincipalPlayer getPrev() {
		return prev;
	}

	public void setPrev(PrincipalPlayer prev) {
		this.prev = prev;
	}
	
	
	
}
