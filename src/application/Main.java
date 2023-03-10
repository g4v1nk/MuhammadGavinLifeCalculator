package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Giving the primaryStage to the controller and setting up Main Menu Scene
			FXMLLoader loader = new FXMLLoader();
			VBox mainMenuContainer = loader.load(new FileInputStream("C:\\Users\\CS219-user\\eclipse-workspace\\MuhammadGavinLifeCalculator\\src\\LifeCalculatorView.fxml"));
			LifeExpectancyCalculatorController controller = (LifeExpectancyCalculatorController)loader.getController();
			controller.applicationStage = primaryStage;
			Scene mainMenuScene = new Scene(mainMenuContainer,400,400);
			
			primaryStage.setScene(mainMenuScene);
			primaryStage.setTitle("Muhammad and Gavin's Life Expectancy Calculator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

