package model;

public class Level {
	
	private Level next;
	private Level prev;
	private String name;
	private String image;
	private String key;
	private int dificulty;
	private int width;
	private int hight;
	private Boolean flag;
	private Section[][] puzzle;
	

	
	public Level(String name, String image, String key, int dificulty) {
		this.name = name;
		this.image = image;
		this.key = key;
		this.dificulty = dificulty;
		prev=null;
		next=null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getDificulty() {
		return dificulty;
	}

	public void setDificulty(int dificulty) {
		this.dificulty = dificulty;
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
}
