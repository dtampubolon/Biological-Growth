/**
 * 
 */
package edu.neu.csye6200.bg;

/**
 * @author Doni Tampubolon
 * This class holds a generation of tree of stems
 */
public class BGGeneration {
	/**
	 * 
	 */
	int gen;//Signifies the n-th generation
	Stem root;  
	
	//Default Constructor
	public BGGeneration(int count) {
		gen = count;
		root = new Stem(0, 0, 5, 0.5*Math.PI); //the root stem (the very first stem)
		BGRule bgr  = new BGRule(root);
		
		//grow stem until n-th generation
		for(int i = 1; i < gen; i++) {
			bgr.grow();
		}
	}
	//Alternate constructor that takes a Stem type as input parameter (for testing only)
	/*public BGGeneration(Stem root) {
		id = idCount++; //Assigns generation number
		this.root = root; //the root stem (the very first stem)
		BGRule bgr  = new BGRule(root);
		
		//grow stem until n-th generation
		for(int i = 0; i < id; i++) {
			bgr.grow();
		}
	}*/
	
	//This method returns the root stem that also contains all the children stems until the n-th generation
	public Stem getBGGRoot() {
		return root;
	}
}
