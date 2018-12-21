package edu.neu.csye6200.bg;

import java.util.ArrayList;

/*
 * This class governs the rule for stem growth
 */

public class BGRule {
	static Stem node; //a single instance of stem
	private double gradient; //Chosen angle of growth (Rule that can be chosen by user through App)
	
	public BGRule(Stem node) {
		this.node = node;
	}
	/*
	 * This method does not take any input parameter
	 * If the method is called, it checks whether it 
	 */
	public void grow() {
		if(!node.getChildStemList().isEmpty())
			grow(node.getChildStemList(), node);
		grow(node);
	}
	/*
	 * This method takes a node as input and increase the length of the node while also adding three children to its childStemList
	 */
	public void grow(Stem node){
		double length = node.getLength()+1;
		node.setLength(length);
		
			
		//Only adds children if the stem doesn't have any
		if(node.getChildStemList().isEmpty()) {
			node.addChild(new Stem(node.getX()+node.getLength()*Math.cos(node.getAngle()),node.getY()+node.getLength()*Math.sin(node.getAngle()),2,node.getAngle()+0.350)); //Left child
			node.addChild(new Stem(node.getX()+node.getLength()*Math.cos(node.getAngle()),node.getY()+node.getLength()*Math.sin(node.getAngle()),3,node.getAngle())); //Middle child
			node.addChild(new Stem(node.getX()+node.getLength()*Math.cos(node.getAngle()),node.getY()+node.getLength()*Math.sin(node.getAngle()),2,node.getAngle()-0.350)); //Right child
		}
	}
	/*
	 * This method accepts an ArrayList of Stem as input and recursively grow the stems and their children. 
	 * The youngest generation of stems will get three children each.
	 */
	public void grow(ArrayList<Stem> stemList, Stem parent) {
		for(Stem s : stemList) {
			//Recalculate stem position every time the parent of stem grows.
			s.setX(parent.getX()+parent.getLength()*Math.cos(parent.getAngle())); 
			s.setY(parent.getY()+parent.getLength()*Math.sin(parent.getAngle()));
			
			if(s.getAngle()>1.58) {
				double temp = s.getAngle();
				s.setAngle(temp+0.0875);
			}
			else if (s.getAngle()<1.56) {
				double temp = s.getAngle();
				s.setAngle(temp-0.0875);
			}
			
			//Recursive method call to grow each stem's children and their own children and so forth and so on
			if(!s.getChildStemList().isEmpty())
				grow(s.getChildStemList(), s); 
			
			//Grow stem (increase stem's length by 1)
			grow(s);
		}
	}
}
