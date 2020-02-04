package edu.neu.csye6200.bg;

import java.util.ArrayList;
import java.util.Observable;

/**
 * a class to make all the growth for the same generation
 * @interface runnable
 * @inheritance observable
 */

public class BGGenerationSet extends Observable implements Runnable{

	private ArrayList<BGGeneration> genList = new ArrayList<BGGeneration>(); //an list to contain all info of stems
	private int rule;//we need a rule number
	private int maxNum; //the max number of generation
	private boolean paused = false;
	
	

	/**this method is made to 
	 * make one iteration of growth
	 */
	public void growOneGeneration(){
		if(genList.size()==0) return;
		ArrayList<BGStem> stemList = new ArrayList<BGStem>();//Create a new List instance
		BGGeneration gen = new BGGeneration();//Create a new BGGeneration instance
		

		ArrayList<BGStem> lastStemList = genList.get(genList.size()-1).getStemList();//get the previous generation stems

		gen.setStemList(stemList);

		int size = lastStemList.size();//the size for iteration
		
		for(int j=0;j<size;j++){
			BGStem stem = lastStemList.get(j);

			gen.growChildStems(stem,rule);//grown one generation
		}
		genList.add(gen);
		System.out.println("----------------------");

	}
	//this is a observer pattern
	public void makeChange(){
		setChanged(); // make some change
		notifyObservers(new String ("Something has changed." ));
	}
	
	
	public void run() {
		int count = 0;
		while(count<maxNum){	
			if (!paused) {
				count++;
				growOneGeneration();
				makeChange();	
			}
			//little pause between each growth generation
			try {
				Thread.sleep(1500L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("generations growth complete" );
		
	}
	
	public ArrayList<BGGeneration> getGenList() {
		return genList;
	}

	public void setGenList(ArrayList<BGGeneration> genList) {
		this.genList = genList;
	}

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}
	
	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public boolean getPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
}