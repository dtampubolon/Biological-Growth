/**
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import javax.swing.JPanel;

/**
 * @author Doni Tampubolon
 *
 */
public class BGPanel extends JPanel implements Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	private BGGenerationSet bggs = null;
	private Logger log = Logger.getLogger(BGPanel.class.getName());
	private int lineSize = 20;
	private Color col = null;
	private int resizer = 10;

	private int test = 0;
	
	boolean st = false;
	//When an instance is created, a BGGenerationSet is used as input to draw graphics
	public BGPanel(BGGenerationSet bggs1) {
		col = Color.WHITE;		
		bggs=bggs1;
	}
	
	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {		
		drawBG(g); //Drawing of BG
		test++;
	}
	
	/*
	 * Draw the stems of Biological Growth
	 */
	public void drawBG(Graphics g) {
		log.info("Drawing BG");
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
	
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.setColor(Color.ORANGE);
		g2d.drawString("Biological Growth", 10, 15);
		
		Stem root=null;
		if(bggs!=null){
			root=bggs.getBGGList().get(2).getBGGRoot();
			System.out.println(root+" HELLO if");
		}
		else{
			root = new Stem(0, 0, 5, 0.5*Math.PI);
			System.out.println(root+ " Hello else");
		}

		drawStem(root,g2d);
	}
	/*
	 * A local routine to ensure that the color value is in the 0 to 255 range.
	 */
	private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}
	/**
	 * A convenience routine to set the color and draw a line
	 * @param g2d the 2D Graphics context
	 * @param startx the line start position on the x-Axis
	 * @param starty the line start position on the y-Axis
	 * @param endx the line end position on the x-Axis
	 * @param endy the line end position on the y-Axis
	 * @param color the line color
	 */
	private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy, Color color) {
		g2d.setColor(color);
		g2d.drawLine(startx, starty, endx, endy);
		
		g2d.setColor(Color.ORANGE);
		g2d.fillOval(endx, endy, 5, 5);
	}
	public void drawStem(Stem root, Graphics2D g2d) {
			System.out.println(root + " HELLO3");
			int startx = (int) (getWidth()/2 +  root.getX()*resizer);
			int starty = (int) (getHeight() - root.getY()*resizer);
			int endx = (int) (startx + root.getLength()*Math.cos(root.getAngle())*resizer);
			int endy = (int) (starty - root.getLength()*Math.sin(root.getAngle())*resizer);
			if(test%2==0)
				paintLine(g2d,startx,starty,endx,endy,Color.GREEN);
			else
				paintLine(g2d,startx,starty,endx,endy,Color.RED);
			if(!root.getChildStemList().isEmpty()) {
				for(Stem s : root.getChildStemList()) {
					drawStem(s, g2d);
				}
			}
	}
	@Override
	public void update(Observable o, Object arg) {
	//Updates the panel when a new simulation is done by BGGenerationSet
		//log.info("Received update from: "+o);
		//repaint();
	}

}
