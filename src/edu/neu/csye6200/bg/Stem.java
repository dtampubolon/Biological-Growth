/**
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;

/**
 * @author Doni Tampubolon
 *
 */
public class Stem {
	private static int idCount = 0; //ID counter for all stem instances
	
	private int id; //Unique ID for each stem instance
	private double X, Y, length, angle; // X, Y coordinates, length and angle of stem
	private ArrayList<Stem> childStemList; //list of child Stem instances
	
	//Constructor
	public Stem(double X, double Y, double length, double angle) {
		id = idCount++;
		this.X = X;
		this.Y = Y;
		this.angle = angle; //angle in radians
		this.length = length; //length in feet
		childStemList = new ArrayList<Stem>();
	}
	//Adds child stem to the stem instance
	public void addChild(Stem child) {
		childStemList.add(child);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public ArrayList<Stem> getChildStemList() {
		return childStemList;
	}
	
	public String toString() {
		return String.format("ID: %5$01d Location: %1$5.2f, %2$5.2f ; Length: %3$5.2f cm ; Direction %4$5.2f radians",X,Y,length,angle,id);

	}
	
	public void printChildren() {
		if(!childStemList.isEmpty()) {
			for(Stem s : childStemList) {
				System.out.println(s.toString());
				s.printChildren();
			}
		}
	}
	
}
