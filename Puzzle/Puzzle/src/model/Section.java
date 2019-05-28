package model;

public class Section {
	
	private int startWidth;
	private int startHight;
	private int width;
	private int hight;
	private int id;
	
	/** Section class Builder.
	 * @param startWidth - the started width - </Pre> startWidth!=null.
	 * @param startHight - the started height - </Pre> startHight!=null.
	 * @param width -the current width - </Pre> with!=null.
	 * @param hight -the current height - </Pre> hight!=null.
	 * @param id - the id of the section- </Pre> id!=null.
	 */
	public Section(int startWidth, int startHight, int width, int hight, int id) {
		this.startWidth = startWidth;
		this.startHight = startHight;
		this.setWidth(width);
		this.setHight(hight);
		this.id = id;
	}
	
	public int[] getInformation(){
		int[] dim = new int[5];
		dim[0] = getStartWidth();
		dim[1] = getStartHight();
		dim[2] = getWidth();
		dim[3] = getHight();
		dim[4] = getId();
		return dim;
	}

	/**
	 * @return the startWidth
	 */
	public int getStartWidth() {
		return startWidth;
	}

	/**
	 * @param startWidth the startWidth to set
	 */
	public void setStartWidth(int startWidth) {
		this.startWidth = startWidth;
	}

	/**
	 * @return the startHight
	 */
	public int getStartHight() {
		return startHight;
	}

	/**
	 * @param startHight the startHight to set
	 */
	public void setStartHight(int startHight) {
		this.startHight = startHight;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

}
