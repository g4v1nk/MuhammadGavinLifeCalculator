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
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("C:\\Users\\CS219-user\\eclipse-workspace\\MuhammadGavinLifeCalculator\\src\\LifeCalculatorView.fxml"));
			LifeCalculatorController controller = (LifeCalculatorController)loader.getController();
			controller.applicationStage = primaryStage;
			
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
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

