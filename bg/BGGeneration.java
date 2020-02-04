package edu.neu.csye6200.bg;

import java.util.ArrayList;


/**
 * a class used to generate all child stems of a whole generation of parent stems(2^n parent stems generate 2^(n+1) child stems)
 */

public class BGGeneration {
	
	private ArrayList<BGStem> stemList = new ArrayList<BGStem>();// an arraylist we used to store child stems of a whole generation
	private BGRule rule;//need a rule variable to generate the growth
	
	public BGGeneration(){
		
	}
	
	public BGGeneration(BGStem baseStem){
		stemList.add(baseStem);
	}
	/**
	 * make one growth for next generation
	 * @param stem	:the parent stem chosen to grow
	 * @param ruleNum	:the rule number chosen to grow	
	 */

	public void growChildStems(BGStem stem,int ruleNum){
		double length = stem.getLength();
		/**
		 * here we set the length of stem no longer than 200, 
		 * a shorter length can make the growth more visionly effective on the painting
		 * @length 200
		 */
		if(stem.getLength()>200){//or we can actually make the length ration of BGRule more small
			length=200;			 
		}
		rule = new BGRule(ruleNum); //use BGRule object to create a rule variable 

		//get the stem on the left side
		double leftStemDir = -rule.getangleRatioLeft();
		double leftStemLength = length * rule.getgrowRatioLeft();
		
		/**
		 * here we set the length of stem no shorter than 2, 
		 * a not too short length can make the growth more visionly effective on the painting
		 * @length 2
		 */
		if(leftStemLength<2){
			leftStemLength=2;
		}

		
		////get the stem on the right side
		double rightStemDir = rule.getangleRatioRight();
		double rightStemLength = length * rule.getgrowRatioRight();
		//same length limit with the left side
		if(rightStemLength<2){
			rightStemLength=2;
		}

		/**
		 * here we have the 3rd rule, and it has three stems for next generation growth 
		 * to make it simple, we make the middleStem the same length with the left one
		 * @middleStem
		 */
		if(ruleNum==3){
			BGStem middleStem = new BGStem(stem.getEndCoordinate(),leftStemLength,stem.getDir());
			stemList.add(middleStem);
		}
		
		BGStem leftChildStem = new BGStem(stem.getEndCoordinate(),leftStemLength,leftStemDir+stem.getDir());
		BGStem rightChildStem = new BGStem(stem.getEndCoordinate(),rightStemLength,rightStemDir+stem.getDir());
		//Add an stem to the stemList
		stemList.add(leftChildStem);
		stemList.add(rightChildStem);
		
	}

	
	public ArrayList<BGStem> getStemList() {
		return  stemList;
	}
	
	public void setStemList(ArrayList<BGStem> stemList) {
		this.stemList = stemList;
	}
	
	public BGRule getRule() {
		return rule;
	}
	public void setRule(BGRule rule) {
		this.rule = rule;
	}
	//print the each stem
	public void print(){
		for(BGStem stem:this.stemList){
			System.out.println(stem.toString());
		}
	}

}