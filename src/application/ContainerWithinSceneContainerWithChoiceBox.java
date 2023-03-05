package application;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

/** This class represents a ChoiceBox-featuring container within a scene container
 * 
 * @author CS219-user
 *
 */
public class ContainerWithinSceneContainerWithChoiceBox extends ContainerWithinSceneContainer {
	private ChoiceBox<String> choiceBox = new ChoiceBox<String>();
	private ObservableList<String> choiceBoxOptions = choiceBox.getItems();
	
	/** This constructor constructs a ChoiceBox-featuring container within a scene container based on parameters.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 * @param choiceBoxDefault (This is the option in the ChoiceBox that is selected by default.)
	 * @param firstChoiceBoxItem (This is the first item to go in the ChoiceBox.)
	 * @param secondChoiceBoxItem (This is the second item to go in the ChoiceBox.)
	 * @param thirdChoiceBoxItem (This is the third item to go in the ChoiceBox.)
	 * @param fourthChoiceBoxItem (This is the fourth item to go in the ChoiceBox.)
	 * 
	 */
	ContainerWithinSceneContainerWithChoiceBox(int minHeight, int translateY, String labelText, int labelMinWidth,
			String choiceBoxDefault, String firstChoiceBoxItem, String secondChoiceBoxItem, String thirdChoiceBoxItem, String fourthChoiceBoxItem) {
		super(minHeight, translateY, labelText, labelMinWidth);
		choiceBox.setValue(choiceBoxDefault);
		choiceBoxOptions.add(0, firstChoiceBoxItem);
		choiceBoxOptions.add(1, secondChoiceBoxItem);
		choiceBoxOptions.add(2, thirdChoiceBoxItem);
		choiceBoxOptions.add(3, thirdChoiceBoxItem);
	}
	
	/** This method returns the ChoiceBox that is created in this class.
	 * 
	 * @return choiceBox (This is the ChoiceBox that is created when a ContainerWithinSceneContainerWithChoiceBox is constructed.)
	 */
	public ChoiceBox<String> getChoiceBox() {
		return choiceBox;
	}
	
}
