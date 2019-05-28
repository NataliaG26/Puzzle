package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Category {
	
	public final static String pathNames ="./DataLevels/CategoryNames.txt";
	public final static String cAnimals="./DataLevels/Animales.txt";
	public final static String cPaisajes="./DataLevels/Paisajes.txt";
	public final static String cCaricaturas="./DataLevels/Caricaturas.txt";
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
	}
	
	public ArrayList<String> firstKeys(ArrayList<String> keys){
		keys.add(firstLevel.getKey());
		if(next!= null) {
			next.firstKeys(keys);
		}
		return keys;
	}
	
	
	
	public String searchLevelKey(String levelName, String category) {
		String key = "";
		if(this.name.equals(category)) {
			key = firstLevel.searchKey(levelName);
		}else {
			key = next.searchLevelKey(levelName, category);
		}
		return key;
	}
	
	public void changeFlag(String levelName, String categoryName) {
		if(this.name.equals(categoryName)) {
		firstLevel.changeFlag(levelName);
		flag = true;
		}else {
			next.changeFlag(levelName, categoryName);
		}
	}
	
	public int[] getInfoSection(int r, int c) {
		if(flag) {
			return firstLevel.getInfoSection( r, c);
		}else {
			return next.getInfoSection(r, c);
		}
	}
		
	
	public String searchImageFlag() {
		String image = "";
		if(this.flag) {
			image = firstLevel.searchFlag();
		}else {
			image = next.searchImageFlag();
		}
		return image;
	}
	
	/** Loads the levels of the category type.
	 * @throws NumberFormatException 
	 * @throws IOException
	 */
	public void loadLevelslevels() throws NumberFormatException, IOException {
		String r = null;
		if(this.getName().equals("Animales")) {
			r=Category.cAnimals;
		}
		else if(this.getName().equals("Caricaturas")) {
			r=Category.cCaricaturas;
		}
		else if(this.getName().equals("Paisajes")) {
			r=Category.cPaisajes;
		}
		
		BufferedReader b = new BufferedReader(new FileReader(r));
		String line;
		while((line=b.readLine())!=null) {	
			String [] reader = line.split(",");
			this.addLevel(new Level(reader[0],reader[1],reader[2],Integer.parseInt(reader[3])));
			System.out.println("animales while");
			
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
			System.out.println("animales add");
		}	
		else
			addLevel(l,r.getNext());	
	}
	
	/** Creates an ArrayList of categories
	 * @param list -a list that contains the fisrt category- </pre> list!=null.
	 * @return An ArrayList with all the categories.
	 */
	public ArrayList<String> categoriesExistens(ArrayList<String> list){
		list.add(this.name);
		if(next != null) {
			list = next.categoriesExistens(list);
		}
		return list;
	}
	
	public void loadPuzzle(int width, int hight) {
		if(this.flag) {
			firstLevel.loadLevel(width, hight);
		}else {
			next.loadPuzzle(width, hight);
		}
	}
	
	
	
	public ArrayList<String> getLevels(String nameCategory){
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(this.name);
		System.out.println("Caricaturas".compareTo(this.name));
		System.out.println(this.name.equalsIgnoreCase(nameCategory));
		System.out.println(this.next==null);
		if(this.name.equalsIgnoreCase(nameCategory)) {
			list = firstLevel.levelsExistans(list);
			System.out.println("cat");
		}else if(this.next != null){
			list = this.next.getLevels(nameCategory);
			System.out.println("cat2");
		}
		return list;
	}
	
	
	public Category getCategory(String name) {
		Category cat = null;
		if(name.equals(this.name)) {
			cat=  this;
		}else {
			cat = next.getCategory(name);
		}
		return cat;
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
