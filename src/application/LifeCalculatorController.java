package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LifeCalculatorController {
	Stage applicationStage;
	
	//Setting up the Main Input Scene.
	VBox mainInputSceneContainer = new VBox(); {
	
	HBox currentAgeContainer = new HBox();
	Label currentAgeLabel = new Label("Current age: ");
	TextField currentAgeTextField = new TextField();
	currentAgeContainer.getChildren().addAll(currentAgeLabel, currentAgeTextField);
	
	HBox genderContainer = new HBox();
	Label genderLabel = new Label("Gender: ");
	ChoiceBox<String> genderChoiceBox = new ChoiceBox<String>();
	genderContainer.getChildren().addAll(genderLabel, genderChoiceBox);
	
	HBox smokingHabitsContainer = new HBox();
	Label smokingHabitsLabel = new Label("Smoking habits: ");
	ChoiceBox<String> smokingHabitsChoiceBox = new ChoiceBox<String>();
	smokingHabitsContainer.getChildren().addAll(smokingHabitsLabel, smokingHabitsChoiceBox);
	
	Button enterTerminalIllnessButton = new Button("Enter Terminal Illness: ");
	Button calculateLifeExpectancyButton = new Button("Calculate Life Expectancy: ");
	
	mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, calculateLifeExpectancyButton);
}

	
	
	Scene mainInputScene = new Scene(new Label("Widgets are coming later"));
	
}
