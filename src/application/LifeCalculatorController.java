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
	
    SceneContainer mainInputSceneContainer = new SceneContainer(3); {
		
    	ContainerWithinSceneContainer currentAgeContainer = new ContainerWithinSceneContainer(75, 25, "Current age: ", 100);
		currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), new TextField());
	
		ContainerWithinSceneContainerWithChoiceBox genderContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Gender: ", 100, "Male", "Male", "Female");
		genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
	
		ContainerWithinSceneContainer smokingHabitsContainer = new ContainerWithinSceneContainer(75, 0, "Smoking habits: ", 100);
		ChoiceBox<String> smokingHabitsChoiceBox = new ChoiceBox<String>();
		smokingHabitsChoiceBox.setValue("Non-smoker");
		ObservableList<String> smokingHabitsList = smokingHabitsChoiceBox.getItems();
		smokingHabitsList.add(0, "Non-smoker");
		smokingHabitsList.add(1, "Light smoker");
		smokingHabitsList.add(2, "Moderate smoker");
		smokingHabitsList.add(3, "Heavy smoker");
		smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsChoiceBox);
	
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
	
	SceneContainer terminalIllnessInputSceneContainer = new SceneContainer(10); {
		
		ContainerWithinSceneContainerWithChoiceBox alzheimersContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 25, "Alzheimer's Disease: ", 100, "No", "No", "Yes");
		alzheimersContainer.getChildren().addAll(alzheimersContainer.getLabel(), alzheimersContainer.getChoiceBox());
		
		ContainerWithinSceneContainerWithChoiceBox creutzfeldtJakobContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Creutzfeldt-Jakob Disease: ", 100, "No", "No", "Yes");
		creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobContainer.getLabel(), creutzfeldtJakobContainer.getChoiceBox());
	
		ContainerWithinSceneContainerWithChoiceBox crohnsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Crohn's Disease: ", 100, "No", "No", "Yes");
		crohnsContainer.getChildren().addAll(crohnsContainer.getLabel(), crohnsContainer.getChoiceBox());
		
		ContainerWithinSceneContainerWithChoiceBox cysticFibrosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Cystic Fibrosis: ", 100, "No", "No", "Yes");
		cysticFibrosisContainer.getChildren().addAll(cysticFibrosisContainer.getLabel(), cysticFibrosisContainer.getChoiceBox());

		ContainerWithinSceneContainerWithChoiceBox duchenneMDContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Duchenne Muscular Dystrophy: ", 100, "No", "No", "Yes");
		duchenneMDContainer.getChildren().addAll(duchenneMDContainer.getLabel(), duchenneMDContainer.getChoiceBox());
	
		ContainerWithinSceneContainerWithChoiceBox hepBContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Hepatitis B: ", 100, "No", "No", "Yes");
		hepBContainer.getChildren().addAll(hepBContainer.getLabel(), hepBContainer.getChoiceBox());
		
		ContainerWithinSceneContainerWithChoiceBox heartDiseaseContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Heart Disease: ", 100, "No", "No", "Yes");
		heartDiseaseContainer.getChildren().addAll(heartDiseaseContainer.getLabel(), heartDiseaseContainer.getChoiceBox());
		
		ContainerWithinSceneContainerWithChoiceBox huntingtonsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Huntington's Disease: ", 100, "No", "No", "Yes");
		huntingtonsContainer.getChildren().addAll(huntingtonsContainer.getLabel(), huntingtonsContainer.getChoiceBox());
		
		ContainerWithinSceneContainerWithChoiceBox multipleSclerosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Multiple Sclerosis: ", 100, "No", "No", "Yes");
		multipleSclerosisContainer.getChildren().addAll(multipleSclerosisContainer.getLabel(), multipleSclerosisContainer.getChoiceBox());
		
		ContainerWithinSceneContainerWithChoiceBox rabiesContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Rabies: ", 100, "No", "No", "Yes");
		rabiesContainer.getChildren().addAll(rabiesContainer.getLabel(), rabiesContainer.getChoiceBox());
	
		Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
		doneTerminalIllnessButton.setTranslateX(100);
		
		terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
			crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
			huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
		
	}
	
	Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 400);
	
}