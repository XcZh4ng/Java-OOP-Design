package edu.neu.csye6200.bg;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * my app class
 */

public class BGApp implements ActionListener, Observer{
	private Logger log=Logger.getLogger(BGApp.class.getName());
	private JFrame frame=null;
	private BGPanel drawPanel = null;
	private JPanel mainPanel=null;
	private JButton startBtn=null;
	private JButton stopBtn=null;
	private JButton pauseBtn=null;
	private JComboBox<String> jCBox = null;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField;
	
	static BGGenerationSet bgGen = new BGGenerationSet();
	Thread thread;
    /**
     * Constructor
     * start the ui
     * add log info
     */
	public BGApp(){
		log.info("App Started");
		initGUI();
	}
	private void initGUI(){
		frame=new JFrame();
		frame.setSize(1300, 1000);//set the size to something reasonable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//if we press the close button,exit
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(),BorderLayout.NORTH);
		frame.add(getDrawPanel(), BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setTitle("MyBGAppUI");
	}
	
	//Create a panel used for drawing
	public JPanel getDrawPanel(){
		drawPanel = new BGPanel(frame.getWidth(), frame.getHeight(),bgGen);
		return drawPanel;
	}
	
	//my main panel
	public JPanel getMainPanel(){
		mainPanel=new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		// my buttons
		startBtn=new JButton("START");
		pauseBtn = new JButton("PAUSE");	
		stopBtn=new JButton("STOP");
		
		startBtn.addActionListener(this);
		pauseBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		//the combo box for rule choice
		jLabel1 = new JLabel("    Choose your rule: ");
		jCBox = new JComboBox<String>();
		jCBox.addItem("1");
		jCBox.addItem("2");
		jCBox.addItem("3");
		
		jLabel2 = new JLabel("     Number Of Generations:(<=16) ");
		jTextField = new JTextField(5); 
		
		mainPanel.add(startBtn);  mainPanel.add(pauseBtn);mainPanel.add(stopBtn);
		mainPanel.add(jLabel1);   mainPanel.add(jCBox);   mainPanel.add(jLabel2);
		mainPanel.add(jTextField);mainPanel.setBackground(Color.white);	
		return mainPanel;
	}

	
	public void update(Observable o, Object arg) {
		System.out.println("Print the Next Generation!");
		drawPanel.paint();
	}


	public void actionPerformed(ActionEvent e) {
		log.info("ActionEvent" + e);
		
		
		
		if (e.getSource() == startBtn) {//is the start button get clicked?
			double startX = frame.getWidth()/2;
			double startY = frame.getHeight();
			if(bgGen.getGenList().size()==0){//restart after a pause or a stop
				BGStem startStem = new BGStem(new Coordinate(startX,startY), 400, Math.PI/2);
				BGGeneration gen = new BGGeneration(startStem);
				bgGen.getGenList().add(gen);
			}	
			/*
			 * 
			 */
			try { 
				int maxNum = Integer.parseInt(jTextField.getText());//total iteration time 
				int ruleNumber = Integer.valueOf(jCBox.getSelectedItem().toString());//get the rule 
				if(maxNum>16||maxNum<1){//arrange the iteration time
					JOptionPane.showMessageDialog(null, "The number should be between 1 and 16.");
				}else{
					
					System.out.println("Start");	
					startBtn.setEnabled(false);  //set the start btn unusable
					bgGen.setPaused(false);		 //set the pause btn unusable
					drawPanel.setVisible(true);	  //show the panel
					bgGen.setRule(ruleNumber);	  //the rule input box
					bgGen.setMaxNum(maxNum);	  //the iteration(generation) number
					
		            if(thread==null){			 //is the thread exist?
		            	thread = new Thread(bgGen); // create new thread for the bgGen
		            	thread.start();
					}          
				}		
		    } catch(Exception e1) { 
		        JOptionPane.showMessageDialog(null, "Please enter a number(1 to 16)."); 
		    }	
		}
		
		if(e.getSource() == pauseBtn){//when the pause btn clicked
			System.out.println("Pause");
			bgGen.setPaused(true);		
			startBtn.setEnabled(true); 
		}
		
		if(e.getSource() == stopBtn){//when the stop btn clicked
			System.out.println("Stop");
			
			bgGen.setMaxNum(1);//close the thread;
			thread = null;//clear the thread;

			if (drawPanel != null) {//reset the drawPanel
				drawPanel.setVisible(false);
				drawPanel.setVisible(true);
			}
			bgGen.setPaused(false);
			bgGen.getGenList().clear(); // clear BGGeberation list
			
			startBtn.setEnabled(true); 
			
		}
	}
	
	public static void main(String[] args) {
		BGApp myApp = new BGApp();
		bgGen.addObserver(myApp);
		System.out.println("end");
	
	}

}
