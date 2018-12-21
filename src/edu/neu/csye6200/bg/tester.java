package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class tester {
	private Stem root;
	private BGRule bgr;
	private ArrayList<BGGeneration> BGGList=null;
	private BGGenerationSet bggs;
	private int maxNumGen; 
	private tester2 t2=null;
	
	public tester() {
		maxNumGen = 5;
		
		//Maximum number of generations (taken from user input from UI)

		bggs = new BGGenerationSet();
		BGGList = bggs.getBGGList();
		for(int i = 1; i<maxNumGen;i++) {
			bggs.addNewGen();
		}	
		t2=new tester2(bggs);
	}
	
	public void run() {
		root=BGGList.get(4).getBGGRoot();
		System.out.println("tester run");
		print(root);
	}
	public void print(Stem node) {
		if(node.getChildStemList().isEmpty()) {
			System.out.println(node + " tester x");
		}
		else {
			System.out.println(node + " tester y");
			for(Stem s:node.getChildStemList()) {
				print(s);
			}
		}
	}
	public static void main(String[] args) {
		tester test = new tester();
		test.run();
	}
}
