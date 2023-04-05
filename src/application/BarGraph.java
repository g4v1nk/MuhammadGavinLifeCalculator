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
	private XYChart.Series<Number, String> lowerData;
	private XYChart.Series<Number, String> upperData;
	

	/** This constructor makes a BarGraph object.
	 * 
	 * @param horizontalAxis (This is the x-axis of the bar graph.)
	 * @param verticalAxis (This is the y-axis of the bar graph.)
	 * @param titleOfBarGraph (This is the title of the bar graph.)
	 * @param horizontalAxisLabel (This is the label for the x-axis of the graph.)
	 * @param tickRotation (This is the angle (in degrees, with respect to the x-axis) of the ticks on the x-axis.)
	 * @param dataThatAppearsLower (This is the data that will be displayed in the lower bar in the graph.)
	 * @param dataThatAppearsHigher (This is the data that will be displayed in the upper bar in the graph.)
	 */
	public BarGraph(NumberAxis horizontalAxis, CategoryAxis verticalAxis, String titleOfBarGraph, String horizontalAxisLabel, int tickRotation, XYChart.Series<Number, String> dataThatAppearsLower, XYChart.Series<Number, String> dataThatAppearsHigher) {
		super(horizontalAxis, verticalAxis);
		setTitle(titleOfBarGraph);
		horizontalAxis.setLabel(horizontalAxisLabel);
		horizontalAxis.setTickLabelRotation(tickRotation);
		lowerData = dataThatAppearsLower;
		upperData = dataThatAppearsHigher;
		getData().addAll(lowerData, upperData);
		
	}
	
	/** This method sets the value of the instance variable "lowerData" based on the parameter.
	 * 
	 * @param data (This is what "lowerData" is to be set to.)
	 */
	public void setLowerData(XYChart.Series<Number, String> data) {
		lowerData = data;
	}
	
	/** This method sets the value of the instance variable "upperData" based on the parameter.
	 * 
	 * @param data (This is what "upperData" is to be set to.)
	 */
	public void setUpperData(XYChart.Series<Number, String> data) {
		upperData = data;
	}
	
	/** This method returns lowerData.
	 * 
	 * @return lowerData (This is the data that appears "lower" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getLowerData() {
		return lowerData;
	}
	
	/** This method returns upperData.
	 * 
	 * @return upperData (This is the data that appears "higher" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getUpperData() {
		return upperData;
	}

}