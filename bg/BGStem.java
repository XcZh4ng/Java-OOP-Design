package edu.neu.csye6200.bg;
/**
 * a class for one single stem to grow its next generation
 */
public class BGStem {
	private Coordinate startCoordinate = new Coordinate(0,0);
	private Coordinate endCoordinate = new Coordinate(0,0);
	private double length = 1;// length of the stem
	private double dir = 0;// angle of stem
	
	public BGStem(){
		this.endCoordinate = this.getEndCoordinate();
	}
	/**
	 * constructor
	 * @param startCoordinate 
	 * @param length	  	  
	 * @param dir		  
	 */
	public BGStem(Coordinate startCoordinate, double length,double dir) {	
		this.startCoordinate = startCoordinate;
		this.length = length;
		this.dir = dir;
		this.endCoordinate = this.getEndCoordinate();
	}
	
	

	public Coordinate getStartCoordinate() {
		return startCoordinate;
	}
	public void setStartCoordinate(Coordinate startCoordinate) {
		this.startCoordinate = startCoordinate;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getDir() {
		return dir;
	}
	public void setDir(double dir) {
		this.dir = dir;
	}

	/**
	 * get the most important end-point coordinate
	 * @return	the position of the end-point
	 */
	public Coordinate getEndCoordinate() {
		double x = startCoordinate.getX() + length * Math.cos(dir);
		double y = startCoordinate.getY() + length * Math.sin(dir+Math.PI);
		endCoordinate = new Coordinate(x, y);
		return endCoordinate;
	}
	
	@Override
	public String toString() {
		return "Stem [startCoordinate=" + startCoordinate.toString() + ", endCoordinate=" + endCoordinate.toString() + ", length=" + length + ", dir=" + dir
				;
	}
	
}

