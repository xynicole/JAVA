package assignment09;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * A component that draws a graphs of the
 * paths provided by the class that calls this one
 * @author CS 140
 */
public class Graph extends JComponent {
   
	private Path2D.Double path1 = new Path2D.Double();
	private double[] x1;
	private double[] y1;
	private Path2D.Double path2 = new Path2D.Double();
	private double[] x2;
	private double[] y2;
	// radius of dot on graph
	private int r = 5;

	public Graph(double[] x1, double[] y1,
			double[] x2, double[] y2) {
		if(y1[y1.length-1] > 0){
			this.x1 = x1;
			this.y1 = y1;
			if(x1.length != y1.length) {
				JOptionPane.showMessageDialog(this, "Cannot make a graph." +
						"\nArrays have different length");
			}
			path1.moveTo(x1[0], y1[0]);
			for(int i = 1; i < x1.length; i++) {
				path1.lineTo(x1[i], y1[i]);
			}
		}

		this.x2 = x2;
		this.y2 = y2;
		if(x2.length != y2.length) {
			JOptionPane.showMessageDialog(this, "Cannot make a graph." +
					"\nArrays have different length");
		}
		path2.moveTo(x2[0], y2[0]);
		for(int i = 1; i < x2.length; i++) {
			path2.lineTo(x2[i], y2[i]);
		}
	}


	/**
	 * Implementation of the paintComponent method
	 * for this component. It draws a sequence of
	 * straight lines between the points in the
	 * paths provided to the component
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));

		g2.setColor(Color.BLUE);
		g2.draw(path1);
		g2.setColor(Color.BLUE);
		for(int i = 0; i < x1.length; i++)
			g2.fill(new Ellipse2D.Double(x1[i]-r,y1[i]-r,2*r,2*r));
		g2.setColor(Color.RED);
		g2.draw(path2);
		g2.setColor(Color.RED);
		for(int i = 0; i < x2.length; i++)
			g2.fill(new Ellipse2D.Double(x2[i]-r,y2[i]-r,2*r,2*r));
		g2.setColor(Color.BLACK);
	}
}