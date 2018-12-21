package edu.neu.csye6200.bg;

import java.util.ArrayList;

public class tester2 {
	private BGGenerationSet bggs = null;
	private ArrayList<BGGeneration> BGGList=null;

	public tester2(BGGenerationSet bggs1) {
		bggs=bggs1;
		BGGList = bggs.getBGGList();
		Stem root = null;
		root = BGGList.get(2).getBGGRoot();
		print(root);
		System.out.println("");
		
	}
	public void print(Stem node) {
		if(node.getChildStemList().isEmpty()) {
			System.out.println(node + " tester x2");
		}
		else {
			System.out.println(node + " tester y2");
			for(Stem s:node.getChildStemList()) {
				print(s);
			}
		}
	}
}
