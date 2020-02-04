package edu.neu.csye6200.bg;
/**
 * a class to make different rules for different grow methods
 */

public class BGRule {
	//private int childrenNumber = 2;;// each stem only generate two child stems(since muti-rule is set this is not needed)
	
	private double growRatioLeft;;//the stem's left child's length would be n times of its own length
	private double angleRatioLeft;;//the angle in direction the stem's left child would rotate to (left)
    
    private double growRatioRight;;//the stem's right child's length would be n times of its own length
    private double angleRatioRight;//the angle in direction the stem's right child would rotate to (right)
    
    public BGRule(int ruleNumber) {
    	if(ruleNumber==1){ 
    		growRatioLeft = 0.8;
    		angleRatioLeft = Math.PI / 7.5;
    		growRatioRight = 0.7;
    		angleRatioRight = Math.PI / 7.8;
    	}else if(ruleNumber==2){
    		growRatioLeft = 0.6;
    		angleRatioLeft = Math.PI / 6.0;
    		growRatioRight = 0.75;
    		angleRatioRight = Math.PI / 3.0;

    	}else if(ruleNumber==3){
    		growRatioLeft = 0.61;
    		angleRatioLeft = Math.PI / 1.3;
    		growRatioRight = 0.61;
    		angleRatioRight = Math.PI / 1.3;
    	}
    }
    
    /*public int getChildrenNumber() {
		return childrenNumber;
	}
	public void setChildrenNumber(int childrenNumber) {
		this.childrenNumber = childrenNumber;
	}*/
	
	public double getgrowRatioLeft() {
		return growRatioLeft;
	}
	public void setgrowRatioLeft(double growRatioLeft) {
		this.growRatioLeft = growRatioLeft;
	}
	public double getangleRatioLeft() {
		return angleRatioLeft;
	}
	public void setangleRatioLeft(double angleRatioLeft) {
		this.angleRatioLeft = angleRatioLeft;
	}
	public double getgrowRatioRight() {
		return growRatioRight;
	}
	public void setgrowRatioRight(double growRatioRight) {
		this.growRatioRight = growRatioRight;
	}
	public double getangleRatioRight() {
		return angleRatioRight;
	}
	public void setangleRatioRight(double angleRatioRight) {
		this.angleRatioRight = angleRatioRight;
	}
   
}
