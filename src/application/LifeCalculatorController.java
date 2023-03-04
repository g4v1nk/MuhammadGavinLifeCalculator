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


	/** This class represents a controller for the GUI this program uses.
	 * 
	 * @author CS219-user
	 *
	 */
public class LifeCalculatorController {

    @FXML
    /** This method sets the scene to mainInputScene.
     * 
     * @param event (event is something that you want to trigger a scene change to mainInputScene.)
     */
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
	
	Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);

	//Setting up the Terminal Illness Input Scene.
	
	VBox terminalIllnessInputSceneContainer = new VBox(); {
		
		HBox alzheimersContainer = new HBox();
		alzheimersContainer.setMinHeight(75);
		alzheimersContainer.setTranslateY(25);
		Label alzheimersLabel = new Label("Alzheimer's Disease: ");
		alzheimersLabel.setMinWidth(100);
		ChoiceBox<String> alzheimersChoiceBox = new ChoiceBox<String>();
		//Creating a yesOrNoList to set the ChoiceBox options for all the terminal illnesses.
		ObservableList<String> yesOrNoList = alzheimersChoiceBox.getItems();
		yesOrNoList.add(0, "No");
		yesOrNoList.add(1, "Yes");
		alzheimersChoiceBox.setValue("No");
		alzheimersContainer.getChildren().addAll(alzheimersLabel, alzheimersChoiceBox);
	
		HBox creutzfeldtJakobContainer = new HBox();
		creutzfeldtJakobContainer.setMinHeight(50);
		Label creutzfeldtJakobLabel = new Label("Creutzfeldt-Jakob Disease: ");
		creutzfeldtJakobLabel.setMinWidth(100);
		ChoiceBox<String> creutzfeldtJakobChoiceBox = new ChoiceBox<String>();
		//yesOrNoList already set up.
		yesOrNoList = creutzfeldtJakobChoiceBox.getItems();
		creutzfeldtJakobChoiceBox.setValue("No");
		creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobLabel, creutzfeldtJakobChoiceBox);
	
		HBox crohnsContainer = new HBox();
		crohnsContainer.setMinHeight(50);
		Label crohnsLabel = new Label("Crohn's Disease: ");
		crohnsLabel.setMinWidth(100);
		ChoiceBox<String> crohnsChoiceBox = new ChoiceBox<String>();
		yesOrNoList = crohnsChoiceBox.getItems();
		crohnsChoiceBox.setValue("No");
		crohnsContainer.getChildren().addAll(crohnsLabel, crohnsChoiceBox);
	
		HBox cysticFibrosisContainer = new HBox();
		cysticFibrosisContainer.setMinHeight(50);
		Label cysticFibrosisLabel = new Label("Cystic Fibrosis: ");
		cysticFibrosisLabel.setMinWidth(100);
		ChoiceBox<String> cysticFibrosisChoiceBox = new ChoiceBox<String>();
		yesOrNoList = cysticFibrosisChoiceBox.getItems();
		cysticFibrosisChoiceBox.setValue("No");
		cysticFibrosisContainer.getChildren().addAll(cysticFibrosisLabel, cysticFibrosisChoiceBox);
	
		HBox duchenneMDContainer = new HBox();
		duchenneMDContainer.setMinHeight(50);
		Label duchenneMDLabel = new Label("Duchenne Muscular Dystrophy: ");
		duchenneMDLabel.setMinWidth(100);
		ChoiceBox<String> duchenneMDChoiceBox = new ChoiceBox<String>();
		yesOrNoList = duchenneMDChoiceBox.getItems();
		duchenneMDChoiceBox.setValue("No");
		duchenneMDContainer.getChildren().addAll(duchenneMDLabel, duchenneMDChoiceBox);
	
		HBox hepBContainer = new HBox();
		hepBContainer.setMinHeight(50);
		Label hepBLabel = new Label("Hepatitis B: ");
		hepBLabel.setMinWidth(100);
		ChoiceBox<String> hepBChoiceBox = new ChoiceBox<String>();
		yesOrNoList = hepBChoiceBox.getItems();
		hepBChoiceBox.setValue("No");
		hepBContainer.getChildren().addAll(hepBLabel, hepBChoiceBox);
	
		HBox heartDiseaseContainer = new HBox();
		heartDiseaseContainer.setMinHeight(50);
		Label heartDiseaseLabel = new Label("Heart Disease: ");
		heartDiseaseLabel.setMinWidth(100);
		ChoiceBox<String> heartDiseaseChoiceBox = new ChoiceBox<String>();
		yesOrNoList = heartDiseaseChoiceBox.getItems();
		heartDiseaseChoiceBox.setValue("No");
		heartDiseaseContainer.getChildren().addAll(heartDiseaseLabel, heartDiseaseChoiceBox);
	
		HBox huntingtonsContainer = new HBox();
		huntingtonsContainer.setMinHeight(50);
		Label huntingtonsLabel = new Label("Huntington's Disease: ");
		huntingtonsLabel.setMinWidth(100);
		ChoiceBox<String> huntingtonsChoiceBox = new ChoiceBox<String>();
		yesOrNoList = huntingtonsChoiceBox.getItems();
		huntingtonsChoiceBox.setValue("No");
		huntingtonsContainer.getChildren().addAll(huntingtonsLabel, huntingtonsChoiceBox);
	
		HBox multipleSclerosisContainer = new HBox();
		multipleSclerosisContainer.setMinHeight(50);
		Label multipleSclerosisLabel = new Label("Multiple Sclerosis: ");
		multipleSclerosisLabel.setMinWidth(100);
		ChoiceBox<String> multipleSclerosisChoiceBox = new ChoiceBox<String>();
		yesOrNoList = multipleSclerosisChoiceBox.getItems();
		multipleSclerosisChoiceBox.setValue("No");
		multipleSclerosisContainer.getChildren().addAll(multipleSclerosisLabel, multipleSclerosisChoiceBox);
	
		HBox rabiesContainer = new HBox();
		rabiesContainer.setMinHeight(75);
		Label rabiesLabel = new Label("Rabies: ");
		rabiesLabel.setMinWidth(100);
		ChoiceBox<String> rabiesChoiceBox = new ChoiceBox<String>();
		yesOrNoList = rabiesChoiceBox.getItems();
		rabiesChoiceBox.setValue("No");
		rabiesContainer.getChildren().addAll(rabiesLabel, rabiesChoiceBox);
	
		Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
		doneTerminalIllnessButton.setTranslateX(100);
		
		terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
			crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
			huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
		
	}
	
	Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 400);
	
}