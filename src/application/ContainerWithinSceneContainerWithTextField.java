package application;

import javafx.scene.control.TextField;

public class ContainerWithinSceneContainerWithTextField extends ContainerWithinSceneContainer {
	
	private TextField textField = new TextField();
	
	/** This constructor constructs a TextField-featuring container within a scene container based on parameters.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 */
	public ContainerWithinSceneContainerWithTextField(int minHeight, int translateY, String labelText, int labelMinWidth) {
		super(minHeight, translateY, labelText, labelMinWidth);
	}
	
	/** This method returns the TextField that is created in this class.
	 * 
	 * @return textField (This is the textField that is created when a ContainerWithinSceneContainerWithTextField is constructed.)
	 */
	public TextField getControl() {
		return textField;
	}
	
	/** This method sets textField according to the parameter.
	 * 
	 * @param textFieldToSet (This is what you want textField to be set to.)
	 */
	public void setTextField(TextField textFieldToSet) {
		textField = textFieldToSet;
	}
	
}
