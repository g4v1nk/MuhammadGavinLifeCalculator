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
	
	/** This constructor constructs a container within a scene container according to the parameter specifications.
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

	/** This method sets the instance variable "label" according to the parameter.
	 * 
	 * @param labelToSet (This is what you want label to be set to.)
	 */
	public void setLabel(Label labelToSet) {
		label = labelToSet;
	}
	
	/** This method will return the variable "label" from the ContainerWithinSceneContainer class.
	 * 
	 * @return label (This is the instance variable for "label" for the ContainerWithinSceneContainer class.)
	 */
	public Label getLabel() {
		return label;
	}
	
	/** This method returns the control corresponding to the particular child class of ContainerWithinSceneContainer.
	 * 
	 * @return (This is the control corresponding to the particular child class of ContainerWithinSceneContainer.)
	 */
	public abstract Object getControl();

}
