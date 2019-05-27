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
	
	
	
	public Category(String name) {
		this.name = name;
		this.addLevel(level);
		next=null;
		prev=null;
	}
	
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
	
	
	public void addLevel(Level l) {
		if(firstLevel==null)
			firstLevel=l;
		else
			addLevel(l,firstLevel);
	}
	
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

	public Level getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(Level firstLevel) {
		this.firstLevel = firstLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public Category getNext() {
		return next;
	}

	public void setNext(Category next) {
		this.next = next;
	}

	public Category getPrev() {
		return prev;
	}

	public void setPrev(Category prev) {
		this.prev = prev;
	}


	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
