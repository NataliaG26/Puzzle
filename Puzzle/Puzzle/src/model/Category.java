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
	private Category next;
	private Category prev;
	private Boolean flag;
	
	/** Builder of the class Category.
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
		flag = false;
	}
	
	
	//el nombre debe existir en la lista
	public void selectedLevel(String nameLevel) {
		if(getLevelsName().contains(nameLevel)) {
			this.flag = true;
			firstLevel.selectedLevel(nameLevel);
		}else {
			next.selectedLevel(nameLevel);
		}
	
	}
	
	

	public void resetLevels() {
		this.flag = false;
		this.firstLevel.resetLevels();
		if(next!= null) {
			next.resetLevels();
		}
	}
	
	public void addCategory(Category category) {
		if(next==null) {
			next=category;
			category.prev = this;
		}else {
			next.addCategory(category);
		}
	}
	
	public Level currentLevel() {
		Level current = firstLevel;
		boolean find = false;
		while(!find) {
			System.out.println(current.getName());
			if(current.getFlag()) {
				find = true;
			}else {
				current = current.getNext();
			}
		}
		return current;
	}
	
	public ArrayList<String> getLevelsName(){
		return firstLevel.levelsExistans(new ArrayList<String>());
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
			System.out.println(reader[0]+""+reader[1]+""+reader[2]+""+reader[3]);
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
			firstLevel.addLevel(l);
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
