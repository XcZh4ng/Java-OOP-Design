package edu.neu.csye6200.bg;
/**
 *  a class to show the coordinate for stem's start points and end points
 */
public class Coordinate {
		
	private double x;//the x coordinate of my stem's point
	private double y;//the y coordinate of my stem's point
	/**
	 * the coordinate made with two pamaraters:x and y
	 * @param x & y
	 */
	public Coordinate(double x, double y) {	
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {//show the coordinate of point e.g.(0,0)
		return "("+this.x+","+this.y+")";
	}
}
