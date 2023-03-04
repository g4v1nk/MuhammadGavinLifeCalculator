package application;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** This class represents a "scene container" that holds things that make up the scene.
 * 
 * @author CS219-user
 *
 */
public class SceneContainer extends VBox {
	
	/** This constructor makes a "scene container" with the number of horizontal boxes specified in the parameter.
	 * 
	 * @param numberOfHBoxes (This is the number of horizontal boxes the scene container will contain.)
	 */
	SceneContainer(int numberOfHBoxes) {
		new ArrayList<HBox>(numberOfHBoxes);
	}

	
}
