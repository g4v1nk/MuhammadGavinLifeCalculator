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
	currentAgeContainer.setMinHeight(75);
	currentAgeContainer.setTranslateY(25);
	Label currentAgeLabel = new Label("Current age: ");
	currentAgeLabel.setMinWidth(100);
	TextField currentAgeTextField = new TextField();
	currentAgeContainer.getChildren().addAll(currentAgeLabel, currentAgeTextField);
	
	HBox genderContainer = new HBox();
	genderContainer.setMinHeight(50);
	Label genderLabel = new Label("Gender: ");
	genderLabel.setMinWidth(100);
	ChoiceBox<String> genderChoiceBox = new ChoiceBox<String>();
	genderChoiceBox.setValue("Male");
	ObservableList<String> genderList = genderChoiceBox.getItems();
	genderList.add(0, "Male");
	genderList.add(1, "Female");
	genderContainer.getChildren().addAll(genderLabel, genderChoiceBox);
	
	HBox smokingHabitsContainer = new HBox();
	smokingHabitsContainer.setMinHeight(75);
	Label smokingHabitsLabel = new Label("Smoking habits: ");
	smokingHabitsLabel.setMinWidth(100);
	ChoiceBox<String> smokingHabitsChoiceBox = new ChoiceBox<String>();
	smokingHabitsChoiceBox.setValue("Non-smoker");
	ObservableList<String> smokingHabitsList = smokingHabitsChoiceBox.getItems();
	smokingHabitsList.add(0, "Non-smoker");
	smokingHabitsList.add(1, "Light smoker");
	smokingHabitsList.add(2, "Moderate smoker");
	smokingHabitsList.add(3, "Heavy smoker");
	smokingHabitsContainer.getChildren().addAll(smokingHabitsLabel, smokingHabitsChoiceBox);
	
	Button enterTerminalIllnessButton = new Button("Enter Terminal Illness: ");
	enterTerminalIllnessButton.setTranslateX(100);
	
	Button calculateLifeExpectancyButton = new Button("Calculate Life Expectancy: ");
	calculateLifeExpectancyButton.setTranslateX(100);
	calculateLifeExpectancyButton.setTranslateY(25);
	
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
		//Creating a yesOrNoList to set the ChoiceBox options for all the terminal illnesses.
		ObservableList<String> yesOrNoList = alzheimersChoiceBox.getItems();
		yesOrNoList.add(0, "No");
		yesOrNoList.add(1, "Yes");
		alzheimersChoiceBox.setValue("No");
		alzheimersContainer.getChildren().addAll(alzheimersLabel, alzheimersChoiceBox);
	
		HBox creutzfeldtJakobContainer = new HBox();
		Label creutzfeldtJakobLabel = new Label("Creutzfeldt-Jakob Disease: ");
		ChoiceBox<String> creutzfeldtJakobChoiceBox = new ChoiceBox<String>();
		//yesOrNoList already set up.
		yesOrNoList = creutzfeldtJakobChoiceBox.getItems();
		creutzfeldtJakobChoiceBox.setValue("No");
		creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobLabel, creutzfeldtJakobChoiceBox);
	
		HBox crohnsContainer = new HBox();
		Label crohnsLabel = new Label("Crohn's Disease: ");
		ChoiceBox<String> crohnsChoiceBox = new ChoiceBox<String>();
		yesOrNoList = crohnsChoiceBox.getItems();
		crohnsChoiceBox.setValue("No");
		crohnsContainer.getChildren().addAll(crohnsLabel, crohnsChoiceBox);
	
		HBox cysticFibrosisContainer = new HBox();
		Label cysticFibrosisLabel = new Label("Cystic Fibrosis: ");
		ChoiceBox<String> cysticFibrosisChoiceBox = new ChoiceBox<String>();
		yesOrNoList = cysticFibrosisChoiceBox.getItems();
		cysticFibrosisChoiceBox.setValue("No");
		cysticFibrosisContainer.getChildren().addAll(cysticFibrosisLabel, cysticFibrosisChoiceBox);
	
		HBox duchenneMDContainer = new HBox();
		Label duchenneMDLabel = new Label("Duchenne Muscular Dystrophy: ");
		ChoiceBox<String> duchenneMDChoiceBox = new ChoiceBox<String>();
		yesOrNoList = duchenneMDChoiceBox.getItems();
		duchenneMDChoiceBox.setValue("No");
		duchenneMDContainer.getChildren().addAll(duchenneMDLabel, duchenneMDChoiceBox);
	
		HBox hepBContainer = new HBox();
		Label hepBLabel = new Label("Hepatitis B: ");
		ChoiceBox<String> hepBChoiceBox = new ChoiceBox<String>();
		yesOrNoList = hepBChoiceBox.getItems();
		hepBChoiceBox.setValue("No");
		hepBContainer.getChildren().addAll(hepBLabel, hepBChoiceBox);
	
		HBox heartDiseaseContainer = new HBox();
		Label heartDiseaseLabel = new Label("Heart Disease: ");
		ChoiceBox<String> heartDiseaseChoiceBox = new ChoiceBox<String>();
		yesOrNoList = heartDiseaseChoiceBox.getItems();
		heartDiseaseChoiceBox.setValue("No");
		heartDiseaseContainer.getChildren().addAll(heartDiseaseLabel, heartDiseaseChoiceBox);
	
		HBox huntingtonsContainer = new HBox();
		Label huntingtonsLabel = new Label("Huntington's Disease: ");
		ChoiceBox<String> huntingtonsChoiceBox = new ChoiceBox<String>();
		yesOrNoList = huntingtonsChoiceBox.getItems();
		huntingtonsChoiceBox.setValue("No");
		huntingtonsContainer.getChildren().addAll(huntingtonsLabel, huntingtonsChoiceBox);
	
		HBox multipleSclerosisContainer = new HBox();
		Label multipleSclerosisLabel = new Label("Multiple Sclerosis: ");
		ChoiceBox<String> multipleSclerosisChoiceBox = new ChoiceBox<String>();
		yesOrNoList = multipleSclerosisChoiceBox.getItems();
		multipleSclerosisChoiceBox.setValue("No");
		multipleSclerosisContainer.getChildren().addAll(multipleSclerosisLabel, multipleSclerosisChoiceBox);
	
		HBox rabiesContainer = new HBox();
		Label rabiesLabel = new Label("Rabies: ");
		ChoiceBox<String> rabiesChoiceBox = new ChoiceBox<String>();
		yesOrNoList = rabiesChoiceBox.getItems();
		rabiesChoiceBox.setValue("No");
		rabiesContainer.getChildren().addAll(rabiesLabel, rabiesChoiceBox);
	
		Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
	
		terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
			crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
			huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
		
	}
	
}