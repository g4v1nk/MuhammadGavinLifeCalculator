package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LifeCalculatorController {

    @FXML
    void goToMainInputScene(ActionEvent event) {
    	applicationStage.setScene(mainInputScene);
    }

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
	genderChoiceBox.setValue("Male");
	ObservableList<String> genderList = genderChoiceBox.getItems();
	genderList.add(0, "Male");
	genderList.add(1, "Female");
	genderContainer.getChildren().addAll(genderLabel, genderChoiceBox);
	
	HBox smokingHabitsContainer = new HBox();
	Label smokingHabitsLabel = new Label("Smoking habits: ");
	ChoiceBox<String> smokingHabitsChoiceBox = new ChoiceBox<String>();
	smokingHabitsChoiceBox.setValue("Non-smoker");
	ObservableList<String> smokingHabitsList = smokingHabitsChoiceBox.getItems();
	smokingHabitsList.add(0, "Non-smoker");
	smokingHabitsList.add(1, "Light smoker");
	smokingHabitsList.add(2, "Moderate smoker");
	smokingHabitsList.add(3, "Heavy smoker");
	smokingHabitsContainer.getChildren().addAll(smokingHabitsLabel, smokingHabitsChoiceBox);
	
	Button enterTerminalIllnessButton = new Button("Enter Terminal Illness: ");
	Button calculateLifeExpectancyButton = new Button("Calculate Life Expectancy: ");
	
	mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, calculateLifeExpectancyButton);
	}
	
	Scene mainInputScene = new Scene(mainInputSceneContainer);

	//Setting up the Terminal Illness Input Scene.
	
	Scene terminalIllnessInputScene = new Scene(new Label("Terminal Illness Input Scene"));
	VBox terminalIllnessInputSceneContainer = new VBox(); {
	
	HBox alzheimersContainer = new HBox();
	Label alzheimersLabel = new Label("Alzheimer's Disease: ");
	ChoiceBox<String> alzheimersChoiceBox = new ChoiceBox<String>();
	alzheimersContainer.getChildren().addAll(alzheimersLabel, alzheimersChoiceBox);
	
	HBox creutzfeldtJakobContainer = new HBox();
	Label creutzfeldtJakobLabel = new Label("Creutzfeldt-Jakob Disease: ");
	ChoiceBox<String> creutzfeldtJakobChoiceBox = new ChoiceBox<String>();
	creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobLabel, creutzfeldtJakobChoiceBox);
	
	HBox crohnsContainer = new HBox();
	Label crohnsLabel = new Label("Crohn's Disease: ");
	ChoiceBox<String> crohnsChoiceBox = new ChoiceBox<String>();
	crohnsContainer.getChildren().addAll(crohnsLabel, crohnsChoiceBox);
	
	HBox cysticFibrosisContainer = new HBox();
	Label cysticFibrosisLabel = new Label("Cystic Fibrosis: ");
	ChoiceBox<String> cysticFibrosisChoiceBox = new ChoiceBox<String>();
	cysticFibrosisContainer.getChildren().addAll(cysticFibrosisLabel, cysticFibrosisChoiceBox);
	
	HBox duchenneMDContainer = new HBox();
	Label duchenneMDLabel = new Label("Duchenne Muscular Dystrophy: ");
	ChoiceBox<String> duchenneMDChoiceBox = new ChoiceBox<String>();
	duchenneMDContainer.getChildren().addAll(duchenneMDLabel, duchenneMDChoiceBox);
	
	HBox hepBContainer = new HBox();
	Label hepBLabel = new Label("Hepatitis B: ");
	ChoiceBox<String> hepBChoiceBox = new ChoiceBox<String>();
	hepBContainer.getChildren().addAll(hepBLabel, hepBChoiceBox);
	
	HBox heartDiseaseContainer = new HBox();
	Label heartDiseaseLabel = new Label("Heart Disease: ");
	ChoiceBox<String> heartDiseaseChoiceBox = new ChoiceBox<String>();
	heartDiseaseContainer.getChildren().addAll(heartDiseaseLabel, heartDiseaseChoiceBox);
	
	HBox huntingtonsContainer = new HBox();
	Label huntingtonsLabel = new Label("Huntington's Disease: ");
	ChoiceBox<String> huntingtonsChoiceBox = new ChoiceBox<String>();
	huntingtonsContainer.getChildren().addAll(huntingtonsLabel, huntingtonsChoiceBox);
	
	HBox multipleSclerosisContainer = new HBox();
	Label multipleSclerosisLabel = new Label("Multiple Sclerosis: ");
	ChoiceBox<String> multipleSclerosisChoiceBox = new ChoiceBox<String>();
	multipleSclerosisContainer.getChildren().addAll(multipleSclerosisLabel, multipleSclerosisChoiceBox);
	
	HBox rabiesContainer = new HBox();
	Label rabiesLabel = new Label("Rabies: ");
	ChoiceBox<String> rabiesChoiceBox = new ChoiceBox<String>();
	rabiesContainer.getChildren().addAll(rabiesLabel, rabiesChoiceBox);
	
	Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
	
	terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
			crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
			huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
	
	}

}