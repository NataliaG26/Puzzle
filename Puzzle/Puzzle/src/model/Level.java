package model;

public class Level {
	
	private Level next;
	private Level prev;
	private String image;
	private int width;
	private int hight;
	private String [] position;
	private Section[][] puzzle;
	//private int dificulty;
	
	
	
	public Level(String image, int n) {
		this.setImage(image);
		setPuzzle(new Section[n][n]);
	}
	
	public void loadSections() {
		int sw = 0;
		int sh = 0;
		int w = width/puzzle.length;
		int h = hight/puzzle.length;
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				puzzle[i][j] = new Section(sw, sh, w, h, (i+j));
				sw += w;
			}
			sw = 0;
			sh += h;
		}
		puzzle[puzzle.length-1][puzzle.length-1] = null;
		
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Section[][] getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Section[][] puzzle) {
		this.puzzle = puzzle;
	}
	
}
