package model;

public class Category {
	
	private Level firstLevel;
	private String name;
	private String[] images;
	
	public Category(String name) {
		this.name = name;
		images = new String[3];
		images[0] = "2.jpg";
	}
	
	public void createLevel() {
		setFirstLevel(new Level(images[0], 3));
		
	}
	
	public void loadPuzzle() {
		firstLevel.loadSections();
	}

	public Level getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(Level firstLevel) {
		this.firstLevel = firstLevel;
	}
}
