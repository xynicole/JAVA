package assignment09;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
/**
 * Driver class that creates a JFrame to hold the
 * component that shows a drawing of two paths,
 * connecting the points provided by the main method.
 *
 * @author CS 140
 *
 */
public class GraphSortResults {

	/**
	 * Main method draws a JFrame and places the
	 * component with graphs of the time taken by the
	 * sorts
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) {
		Sorter sorter1 = new InsertionSorter();
		Sorter sorter2 = new NaiveQuickSort();

		JFrame frame = new JFrame();

		Random r = new Random();
		final int FACTOR = 5000;
		double[] x = {0,1,2,3,4,5,6,7,8,9};
		double[] y1 = new double[x.length];
		double[] y2 = new double[x.length];
		List<Double> sample;
		List<Double> copy;
		for (int i = 1; i < x.length; i++) {
			sample = new ArrayList<Double>();
			for(int j = 0; j < FACTOR*i; j++) {
				sample.add(r.nextDouble());
			}
			copy = new ArrayList<>();
			copy.addAll(sample);

			y1[i] = sorter1.timedSort(sample);
			System.out.println(y1[i]);

			y2[i] = sorter2.timedSort(copy);
			System.out.println(y2[i]);

			System.out.println("----------------");
		}
		for(int i = 1; i < x.length; i++) {
			x[i] = 20 + 500*x[i]/x[x.length-1];
		}
		double max = y1[y1.length-1];
		max = 1 + Math.max(max, y2[y2.length-1]);
		for(int i = 0; i < y1.length; i++) {
			y1[i] = 550 - 550*y1[i]/max;
			y2[i] = 550 - 550*y2[i]/max;
		}
		frame.setSize(540, 600);
		frame.setTitle("Times");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graph component = new Graph(x,y1,x,y2);

		frame.add(component);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}