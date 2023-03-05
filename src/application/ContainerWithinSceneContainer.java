package application;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/** This class represents a container within a scene container.
 * 
 * @author CS219-user
 *
 */
public class ContainerWithinSceneContainer extends HBox {
	private Label label;
	
	/** This constructor constructs a container within a scene container according to the parameter specifications.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 */
	ContainerWithinSceneContainer(int minHeight, int translateY, String labelText, int labelMinWidth) {
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

}
