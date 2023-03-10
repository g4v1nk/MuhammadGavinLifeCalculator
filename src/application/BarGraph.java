package application;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

/** This class represents a bar graph that displays a comparison
 * of the user's age at death with the average person's age at death.
 * 
 * @author CS219-user
 *
 */
public class BarGraph {
	private NumberAxis numAxis = new NumberAxis();
	private CategoryAxis catAxis = new CategoryAxis();
	private BarChart<Number, String> barGraph = new BarChart<Number, String>(numAxis, catAxis);
	
	/** This constructor makes a BarGraph object.
	 * 
	 * @param titleOfGraph (This is the title of the bar graph.)
	 * @param numAxisLabel (This is the label of the x-axis of the graph.)
	 * @param tickIncrements (This is the tick increments of the x-axis of the graph.)
	 */
	BarGraph(String titleOfGraph, String numAxisLabel, int tickIncrements) {
		barGraph.setTitle(titleOfGraph);
		numAxis.setLabel(numAxisLabel);
		numAxis.setTickLabelRotation(tickIncrements);
	}
	

}
