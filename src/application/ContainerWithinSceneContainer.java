package application;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/** This class represents a container within a scene container.
 * 
 * @author CS219-user
 *
 */
public abstract class ContainerWithinSceneContainer extends HBox {
	private Label label;
	
	/** This constructor constructs a generic "container within a scene container" according to the parameter specifications.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 */
	public ContainerWithinSceneContainer(int minHeight, int translateY, String labelText, int labelMinWidth) {
		setMinHeight(minHeight);
		setTranslateY(translateY);
		label = new Label(labelText);
		label.setMinWidth(labelMinWidth);
	}

	/** This method will return the variable "label" from the ContainerWithinSceneContainer class.
	 * 
	 * @return label (This is the instance variable for "label" for the ContainerWithinSceneContainer class.)
	 */
	public Label getLabel() {
		return label;
	}
	
	/** This method sets the instance variable "label" according to the parameter.
	 * 
	 * @param labelToSet (This is what you want label to be set to.)
	 */
	public void setLabel(Label labelToSet) {
		label = labelToSet;
	}
	
	/** This method returns the control for the class on which the method is invoked.
	 * 
	 * @return (This method will return the control (such as TextField or ChoiceBox)
	 * that corresponds to the particular class on which this method is invoked.)
	 */
	public abstract Object getControl();

}
