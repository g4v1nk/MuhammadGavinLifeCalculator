package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/** This class represents a container within a scene container with a TextField.
 * 
 * @author CS219-user
 *
 */
public class ContainerWithinSceneContainerWithTextField extends ContainerWithinSceneContainer {
	private Label label;
	private TextField textField;
	
	/** This constructor constructs a container within a scene container with a TextField according to the parameter specifications.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 */
	public ContainerWithinSceneContainerWithTextField(int minHeight, int translateY, String labelText, int labelMinWidth) {
		super(minHeight, translateY, labelText, labelMinWidth);
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
	
	/** This method returns textField.
	 * 
	 */
	public TextField getControl() {
		return textField;
	}

}
