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
	
	/** This constructor constructs a 2-element-ChoiceBox-featuring container within a scene container based on parameters.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 * @param choiceBoxDefault (This is the option in the ChoiceBox that is selected by default.)
	 * @param firstChoiceBoxItem (This is the first item to go in the ChoiceBox.)
	 * @param secondChoiceBoxItem (This is the second item to go in the ChoiceBox.)
	 */
	public ContainerWithinSceneContainerWithChoiceBox(int minHeight, int translateY, String labelText, int labelMinWidth,
			String choiceBoxDefault, String firstChoiceBoxItem, String secondChoiceBoxItem) {
		
		super(minHeight, translateY, labelText, labelMinWidth);
		choiceBox.setValue(choiceBoxDefault);
		choiceBoxOptions.add(0, firstChoiceBoxItem);
		choiceBoxOptions.add(1, secondChoiceBoxItem);
		
	}
	
	/** This constructor constructs a 3-element-ChoiceBox-featuring container within a scene container based on parameters.
	 * 
	 * @param minHeight (This is the minimum height of the inner container.)
	 * @param translateY (This is the amount you want the inner container to be moved down by.)
	 * @param labelText (This is the text that will appear in the inner container's label.)
	 * @param labelMinWidth (This is the minimum width of the inner container's label.)
	 * @param choiceBoxDefault (This is the option in the ChoiceBox that is selected by default.)
	 * @param firstChoiceBoxItem (This is the first item to go in the ChoiceBox.)
	 * @param secondChoiceBoxItem (This is the second item to go in the ChoiceBox.)
	 * @param thirdChoiceBoxItem (This is the third item to go in the ChoiceBox.)
	 */
	public ContainerWithinSceneContainerWithChoiceBox(int minHeight, int translateY, String labelText, int labelMinWidth,
			String choiceBoxDefault, String firstChoiceBoxItem, String secondChoiceBoxItem, String thirdChoiceBoxItem) {
		
		super(minHeight, translateY, labelText, labelMinWidth);
		choiceBox.setValue(choiceBoxDefault);
		choiceBoxOptions.add(0, firstChoiceBoxItem);
		choiceBoxOptions.add(1, secondChoiceBoxItem);
		choiceBoxOptions.add(2, thirdChoiceBoxItem);
		
	}
	
	/** This constructor constructs a 4-element-ChoiceBox-featuring container within a scene container based on parameters.
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
	 */
	public ContainerWithinSceneContainerWithChoiceBox(int minHeight, int translateY, String labelText, int labelMinWidth,
			String choiceBoxDefault, String firstChoiceBoxItem, String secondChoiceBoxItem, String thirdChoiceBoxItem, String fourthChoiceBoxItem) {
		
		super(minHeight, translateY, labelText, labelMinWidth);
		choiceBox.setValue(choiceBoxDefault);
		choiceBoxOptions.add(0, firstChoiceBoxItem);
		choiceBoxOptions.add(1, secondChoiceBoxItem);
		choiceBoxOptions.add(2, thirdChoiceBoxItem);
		choiceBoxOptions.add(3, fourthChoiceBoxItem);
		
	}
	
	/** This method sets choiceBox according to the parameter.
	 * 
	 * @param choiceBoxToSet (This is what you want choiceBox to be set to.)
	 */
	public void setChoiceBox(ChoiceBox<String> choiceBoxToSet) {
		choiceBox = choiceBoxToSet;
	}
	
	/** This method changes what choiceBoxOptions references, according to the parameter.
	 * 
	 * @param choiceBoxOptionsToSet (This is the options you want choiceBoxOptions to be set to.)
	 */
	public void setChoiceBoxOptions(ObservableList<String> choiceBoxOptionsToSet) {
		choiceBoxOptions = choiceBoxOptionsToSet;
	}
	
	/** This method returns the ChoiceBox that is created in this class.
	 * 
	 * @return choiceBox (This is the ChoiceBox that is created when a ContainerWithinSceneContainerWithChoiceBox is constructed.)
	 */
	public ChoiceBox<String> getControl() {
		return choiceBox;
	}
	
	/** This method returns the choiceBoxOptions (the options for the ChoiceBox called choiceBox).
	 * 
	 * @return choiceBoxOptions (This is the options that appear in the ChoiceBox called choiceBox.)
	 */
	public ObservableList<String> getChoiceBoxOptions() {
		return choiceBoxOptions;
	}
	
}
