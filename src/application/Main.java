package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

	/** This class represents a specific Application object. 
	 * 
	 * @author CS219-user
	 *
	 */
public class Main extends Application {
	
	@Override
	/** This method gets the program running and sets the scene to mainMenuScene.
	 * 
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		try {
			// Giving the primaryStage to the controller and setting up Main Menu Scene
			FXMLLoader loader = new FXMLLoader();
			VBox mainMenuContainer = loader.load(new FileInputStream("/MuhammadGavinLifeCalculator/src/LifeCalculatorView.fxml"));
			LifeCalculatorController controller = (LifeCalculatorController)loader.getController();
			controller.setApplicationStage(primaryStage);
			Scene mainMenuScene = new Scene(mainMenuContainer,400,400);
			
			primaryStage.setScene(mainMenuScene);
			primaryStage.setTitle("Muhammad and Gavin's Life Expectancy Calculator");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** This method launches the life expectancy calculator.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}