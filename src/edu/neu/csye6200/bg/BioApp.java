package edu.neu.csye6200.bg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.neu.csye6200.ui.BGCanvas;
import edu.neu.csye6200.ui.MenuManager;

public class BioApp extends BGApp{

	private static Logger log = Logger.getLogger(BioApp.class.getName());
	
	protected JPanel mainPanel = null;
	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	private BGPanel bgPanel = null;
	
	private Stem root;
	private BGRule bgr;
	private ArrayList<BGGeneration> BGGList=null;
	private BGGenerationSet bggs=null;
	
	private String[] rules = { "Gradient", "Orange", "Blue" };
	
	private JComboBox ruleList;
	private int maxNumGen; //Maximum number of generations (taken from user input from UI)
	
	public BioApp() {

		maxNumGen = 10;
		
		bggs = new BGGenerationSet();
		//bggs.addObserver(bgPanel);

		BGGList = bggs.getBGGList();
		for(int i = 0; i<maxNumGen;i++) {
			bggs.addNewGen();
		}
	
		//BGGeneration bgg = BGGList.get(maxNumGen-1);
		//root = bgg.getBGGRoot();
		//System.out.println(root + " test1");
		//bgg.getBGGRoot().printChildren();
		initGUI();
		frame.setSize(500, 400);
		menuMgr.createDefaultActions();
		showUI();
	}
	    
	public static void main(String[] args) {
		BioApp ta = new BioApp();
		log.info("BioApp started");
	}

	@Override
	public JPanel getMainPanel() {
		// TODO Auto-generated method stub

		mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(BorderLayout.NORTH, getNorthPanel());
    	bgPanel = new BGPanel(bggs);
    	mainPanel.add(BorderLayout.CENTER, bgPanel);
    	return mainPanel;
    	
	}

	/**
	 * Create a top panel that will hold control buttons
	 * @return
	 */
    public JPanel getNorthPanel() {
    	northPanel = new JPanel();
    	northPanel.setLayout(new FlowLayout());
    	
    	startBtn = new JButton("Start");
    	startBtn.addActionListener(this); // Allow the app to hear about button pushes
    	northPanel.add(startBtn);
    	
    	stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
    	stopBtn.addActionListener(this);
    	northPanel.add(stopBtn);
    	
    	//Use anonymous inner class to perform actions when button is pushed
    	startBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			//System.out.println(bgPanel);
    			bgPanel.st = true;
    			bgPanel.repaint();
    		}
    	});

    	return northPanel;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We received an ActionEvent "+e);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");	
	}

	@Override
	public void windowClosing(WindowEvent e) {
		log.info("Window closing");		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window closed");		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		log.info("Window iconified");		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
