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
	private XYChart.Series<Number, String> bottomData;
	private XYChart.Series<Number, String> upperData;
	private  XYChart.Series<Number, String> person3Data;
	private  XYChart.Series<Number, String> person2Data;
	private  XYChart.Series<Number, String> person1Data;
	

	/** This constructor makes a BarGraph object with two bars.
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
		bottomData = dataThatAppearsLower;
		upperData = dataThatAppearsHigher;
		getData().addAll(bottomData, upperData);
		
	}
	
	/** This constructor makes a BarGraph object with three bars.
	 * 
	 * @param horizontalAxis (This is the x-axis of the bar graph.)
	 * @param verticalAxis (This is the y-axis of the bar graph.)
	 * @param titleOfBarGraph (This is the title of the bar graph.)
	 * @param horizontalAxisLabel (This is the label for the x-axis of the graph.)
	 * @param tickRotation (This is the angle (in degrees, with respect to the x-axis) of the ticks on the x-axis.)
	 * @param dataThatAppearsLowest (This is the data that will be displayed in the lowest bar in the graph.)
	 * @param dataFromPerson1 (This is the data that will be displayed in the highest bar in the graph.)
	 * @param dataFromPerson2 (This is the data that will be displayed in the second-highest bar in the graph.)
	 */
	public BarGraph(NumberAxis horizontalAxis, CategoryAxis verticalAxis, String titleOfBarGraph, String horizontalAxisLabel, int tickRotation, 
			XYChart.Series<Number, String> dataThatAppearsLowest,  
			XYChart.Series<Number, String> dataFromPerson1, XYChart.Series<Number, String> dataFromPerson2) {
		
		super(horizontalAxis, verticalAxis);
		setTitle(titleOfBarGraph);
		horizontalAxis.setLabel(horizontalAxisLabel);
		horizontalAxis.setTickLabelRotation(tickRotation);
		bottomData = dataThatAppearsLowest;
		person2Data = dataFromPerson2;
		person1Data = dataFromPerson1;
		getData().addAll(bottomData, person2Data, person1Data);
		
	}
	
	/** This constructor makes a BarGraph object with four bars.
	 * 
	 * @param horizontalAxis (This is the x-axis of the bar graph.)
	 * @param verticalAxis (This is the y-axis of the bar graph.)
	 * @param titleOfBarGraph (This is the title of the bar graph.)
	 * @param horizontalAxisLabel (This is the label for the x-axis of the graph.)
	 * @param tickRotation (This is the angle (in degrees, with respect to the x-axis) of the ticks on the x-axis.)
	 * @param dataThatAppearsLowest (This is the data that will be displayed in the lowest bar in the graph.)
	 * @param dataFromPerson1 (This is the data that will be displayed in the highest bar in the graph.)
	 * @param dataFromPerson2 (This is the data that will be displayed in the third-lowest bar in the graph.)
     * @param dataFromPerson3 (This is the data that will be displayed in the second-lowest bar in the graph.)
	 */
	public BarGraph(NumberAxis horizontalAxis, CategoryAxis verticalAxis, String titleOfBarGraph, String horizontalAxisLabel, int tickRotation, 
			XYChart.Series<Number, String> dataThatAppearsLowest,  
			XYChart.Series<Number, String> dataFromPerson1, XYChart.Series<Number, String> dataFromPerson2, XYChart.Series<Number, String> dataFromPerson3) {
		
		super(horizontalAxis, verticalAxis);
		setTitle(titleOfBarGraph);
		horizontalAxis.setLabel(horizontalAxisLabel);
		horizontalAxis.setTickLabelRotation(tickRotation);
		bottomData = dataThatAppearsLowest;
		person3Data = dataFromPerson3;
		person2Data = dataFromPerson2;
		person1Data = dataFromPerson1;
		getData().addAll(bottomData, person3Data, person2Data, person1Data);
		
	}
	
	/** This method sets the value of the instance variable "bottomData" based on the parameter.
	 * 
	 * @param data (This is what "bottomData" is to be set to.)
	 */
	public void setBottomData(XYChart.Series<Number, String> data) {
		bottomData = data;
	}
	
	/** This method returns bottomData.
	 * 
	 * @return bottomData (This is the data that appears "lowest" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getBottomData() {
		return bottomData;
	}
	
	/** This method sets the value of the instance variable "upperData" based on the parameter.
	 * 
	 * @param data (This is what "upperData" is to be set to.)
	 */
	public void setUpperData(XYChart.Series<Number, String> data) {
		upperData = data;
	}
	
	/** This method returns upperData.
	 * 
	 * @return upperData (This is the data that appears "higher" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getUpperData() {
		return upperData;
	}
	
	/** This method sets the value of the instance variable "person1Data" based on the parameter.
	 * 
	 * @param data (This is what "person1Data" is to be set to.)
	 */
	public void setPerson1Data(XYChart.Series<Number, String> data) {
		person1Data = data;
	}
	
	/** This method returns person1Data.
	 * 
	 * @return person1Data (This is the data that appears "highest" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getPerson1Data() {
		return person1Data;
	}
	
	/** This method sets the value of the instance variable "person2Data" based on the parameter.
	 * 
	 * @param data (This is what "person2Data" is to be set to.)
	 */
	public void setPerson2Data(XYChart.Series<Number, String> data) {
		person2Data = data;
	}
	
	/** This method returns person2Data.
	 * 
	 * @return person2Data (This is the data that appears below "person1Data" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getPerson2Data() {
		return person2Data;
	}
	
	/** This method sets the value of the instance variable "person3Data" based on the parameter.
	 * 
	 * @param data (This is what "person3Data" is to be set to.)
	 */
	public void setPerson3Data(XYChart.Series<Number, String> data) {
		person3Data = data;
	}
	
	/** This method returns person3Data.
	 * 
	 * @return person3Data (This is the data that appears below "person2Data" in the bar graph.)
	 */
	public XYChart.Series<Number, String> getPerson3Data() {
		return person3Data;
	}

}