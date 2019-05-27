package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Category {
	
	public final static String pathNames ="../Puzzle/Puzzle/DataLevels/categoryNames.txt";
	public final static String cAnimals="../Puzzle/Puzzle/DataLevels/Animals.txt";
	public final static String cPaisajes="../Puzzle/Puzzle/DataLevels/Paisajes.txt";
	public final static String cCaricaturas="../Puzzle/Puzzle/DataLevels/Caricaturas.txt";
	private Level firstLevel;
	private String name;
	private String[] images;
	private Category next;
	private Category prev;
	private Level level;
	private Boolean flag;
	
	
	
	/** Builder of the class Category.
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
		this.addLevel(level);
		next=null;
		prev=null;
		firstLevel=null;
	}
	
	/** Loads the levels of the category type.
	 * @throws NumberFormatException 
	 * @throws IOException
	 */
	public void loadLevelslevels() throws NumberFormatException, IOException {
		String r;
		if(this.getName().equals("Animales"))
			r=Category.cAnimals;
		else if(this.getName().equals("Caricaturas"))
			r=Category.cCaricaturas;
		else
			r=Category.cPaisajes;

		BufferedReader b = new BufferedReader(new FileReader(r));
		String line;
		while((line=b.readLine())!=null) {	
			String [] reader = line.split(",");
			this.addLevel(new Level(reader[0],reader[1],reader[2],Integer.parseInt(reader[3])));
			
		}
		b.close();
	}
	
	
	/** Adds part 1 A level to the category.
	 * if the firstlevel !=null try add part2
	 * @param l - the level that it's going to be added-
	 */
	public void addLevel(Level l) {
		if(firstLevel==null)
			firstLevel=l;
		else
			addLevel(l,firstLevel);
	}
	
	/** addLevel part2 adds a level to the linked list last position
	 * @param l -level object that it's going to be added- l!=null
	 * @param r -the level that used as reference to know the position in the linked list- r!=null
	 */
	public void addLevel(Level l,Level r) {
		if(r.getNext()==null) {
			r.setNext(l);
			l.setPrev(l);
		}	
		else
			addLevel(l,r.getNext());	
	}
	
	public void loadPuzzle() {
		firstLevel.loadSections();
	}

	/**
	 * @return the firstLevel
	 */
	public Level getFirstLevel() {
		return firstLevel;
	}

	/**
	 * @param firstLevel the firstLevel to set
	 */
	public void setFirstLevel(Level firstLevel) {
		this.firstLevel = firstLevel;
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
	 * @return the images
	 */
	public String[] getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(String[] images) {
		this.images = images;
	}

	/**
	 * @return the next
	 */
	public Category getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Category next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Category getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Category prev) {
		this.prev = prev;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
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

	
}
