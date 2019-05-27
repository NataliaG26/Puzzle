package model;

import java.util.ArrayList;

/** 
 * @author Natalia Gonzales & Duvan Cuero
 */
public class Level {
	
	private Level next;
	private Level prev;
	private String name;
	private String image;
	private String key;
	private int difficulty;
	private int width;
	private int hight;
	private Boolean flag;
	private Section[][] puzzle;
	

	
	/** Level builder is the class builder
	 * @param name -name of the level- <Pre:/> name!=null
	 * @param image -image URL of the level- <Pre:/> image!=null
	 * @param key -a string that unlocks the level- <Pre:/>key!=null
	 * @param dificulty -this int represents the size of the matrix and difficulty- <Pre:/> difficulty!=null
	 */
	public Level(String name, String image, String key, int difficulty) {
		this.name = name;
		this.image = image;
		this.key = key;
		this.difficulty = difficulty;
		prev=null;
		next=null;
	}

	/** Loads all the sections of the level in an matrix.
	 */
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
	public ArrayList<Level> levelsExistans(ArrayList<Level> list){
		list.add(this);
		if(next != null) {
			list = next.levelsExistans(list);
		}
		return list;
	}

	/**
	 * @return the next
	 */
	public Level getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Level next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Level getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Level prev) {
		this.prev = prev;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * @param dificulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the hight
	 */
	public int getHight() {
		return hight;
	}

	/**
	 * @param hight the hight to set
	 */
	public void setHight(int hight) {
		this.hight = hight;
	}

	/**
	 * @return the flag
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * @return the puzzle
	 */
	public Section[][] getPuzzle() {
		return puzzle;
	}

	/**
	 * @param puzzle the puzzle to set
	 */
	public void setPuzzle(Section[][] puzzle) {
		this.puzzle = puzzle;
	}
	
	
	

	
}
