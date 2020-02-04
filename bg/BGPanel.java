package edu.neu.csye6200.bg;


import java.awt.*;
import java.util.AbstractList;
import java.util.ArrayList;

import javax.swing.JPanel;


public class BGPanel extends JPanel{
	
	/**
	 * BGPanel used to make the draw on panel
	 * @inheritance JPanel
	 */
	private static final long serialVersionUID = 1L;
	private double fWidth;
	private double fHeight;
	private BGGenerationSet bgGen;
	
	/**BGPanel constructor
	 * @width
	 * @height
	 * @BGGenerationSet
	 */
	public BGPanel(double fWidth, double fHeight,BGGenerationSet bgGen) {
		this.fWidth = fWidth;
		this.fHeight = fHeight;
		this.bgGen=bgGen;
	}

	public void paint() {
		paintImmediately(0, 0, getWidth(), getHeight());
	}

	public void paintComponent(Graphics g){  
		
		

		Dimension size = getSize();	
		g.setColor(Color.black);
		g.fillRect(0, 0, size.width, size.height);//fill the entire panel
		double xRate = size.width / fWidth;
		double yRate = size.height / fHeight;
		
		ArrayList<BGGeneration> genList = bgGen.getGenList();
		int count = genList.size(); 	
		for(int i = 0; i < count; i++) {
			AbstractList<BGStem> stemList = genList.get(i).getStemList();

			int num = stemList.size();  
			/**
			 * when different number chosen, different rules will be used
			 * also make different iteration for different color change in rules
			 */
			if(bgGen.getRule() == 1){
				g.setColor(Color.orange);
			}else if(bgGen.getRule() == 2){
				if(i>10){
					g.setColor(Color.pink);
				}else if(i>5){
					g.setColor(Color.orange);
				}else{
					g.setColor(Color.yellow);
				}
			}else if(bgGen.getRule() == 3){
				if(i>9){
					g.setColor(Color.green);
				}else if(i>4){
					g.setColor(Color.yellow);
				}else{
					g.setColor(Color.orange);
				}
			}
			
			
			for(int j = 0; j < num; j++) {			
				g.drawLine((int)(stemList.get(j).getStartCoordinate().getX()*xRate),(int)(stemList.get(j).getStartCoordinate().getY()*yRate), 
						(int)(stemList.get(j).getEndCoordinate().getX()*xRate),(int)(stemList.get(j).getEndCoordinate().getY()*yRate));					
			}
		}
	}

}		
		