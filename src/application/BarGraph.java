package application;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/** This class represents a bar graph that displays a comparison
 * of the user's age at death with the average person's age at death.
 * 
 * @author CS219-user
 *
 */
public class BarGraph extends BarChart<Number, String> {

	/** This constructor makes a BarGraph object.
	 * 
	 * @param horizontalAxis (This is the x-axis of the bar graph.)
	 * @param verticalAxis (This is the y-axis of the bar graph.)
	 * @param titleOfBarGraph (This is the title of the bar graph.)
	 * @param horizontalAxisLabel (This is the label for the x-axis of the graph.)
	 * @param tickRotation (This is the angle (in degrees, with respect to the x-axis) of the ticks on the x-axis.)
	 * @param lowerData (This is the data that will be displayed in the lower bar in the graph.)
	 * @param upperData (This is the data that will be displayed in the upper bar in the graph.)
	 */
	BarGraph(NumberAxis horizontalAxis, CategoryAxis verticalAxis, String titleOfBarGraph, String horizontalAxisLabel, int tickRotation, XYChart.Series<Number, String> lowerData, XYChart.Series<Number, String> upperData) {
		super(horizontalAxis, verticalAxis);
		setTitle(titleOfBarGraph);
		horizontalAxis.setLabel(horizontalAxisLabel);
		horizontalAxis.setTickLabelRotation(tickRotation);
		getData().addAll(lowerData, upperData);
		
	}	

}
