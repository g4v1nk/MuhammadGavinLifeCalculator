package application;

import java.io.FileInputStream;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    private Stage applicationStage;
    private ContainerWithinSceneContainer currentAgeContainer = new ContainerWithinSceneContainer(75, 25, "Current age: ", 100);
    private TextField currentAgeTextField = new TextField();
    private ContainerWithinSceneContainerWithChoiceBox genderContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Gender: ", 100, "Male", "Male", "Female", null, null);
    private ContainerWithinSceneContainerWithChoiceBox smokingHabitsContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Smoking habits: ", 100,
			"Non-smoker", "Non-smoker", "Light smoker", "Moderate smoker", "Heavy smoker");
    private ContainerWithinSceneContainerWithChoiceBox alzheimersContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 25, "Alzheimer's Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox creutzfeldtJakobContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Creutzfeldt-Jakob Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox crohnsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Crohn's Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox cysticFibrosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Cystic Fibrosis: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox duchenneMDContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Duchenne Muscular Dystrophy: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox hepBContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Hepatitis B: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox heartDiseaseContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Heart Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox huntingtonsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Huntington's Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox multipleSclerosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Multiple Sclerosis: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox rabiesContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Rabies: ", 100, "No", "No", "Yes", null, null);
    private Button startCalculationButton = new Button("Start Calculation");
    private Button enterTerminalIllnessButton = new Button("Enter Terminal Illness: ");
    private Button calculateLifeExpectancyButton = new Button("Calculate Life Expectancy: ");
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
    private Button newCalculationButton = new Button("New Calculation");
    private Button mainMenuButton = new Button("Main Menu");
	
    VBox mainMenuSceneContainer = new VBox(); {
    	mainMenuSceneContainer.getChildren().add(startCalculationButton);
    }
    
    Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
    
    VBox mainInputSceneContainer = new VBox(); {
    	
		currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
	
		genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
	
		smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
		
		
		enterTerminalIllnessButton.setTranslateX(100);

		
		
		calculateLifeExpectancyButton.setTranslateX(100);
		calculateLifeExpectancyButton.setTranslateY(25);
		
		

		mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, calculateLifeExpectancyButton);
		
    }
	
	Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
	
	VBox terminalIllnessInputSceneContainer = new VBox(); {
		
		alzheimersContainer.getChildren().addAll(alzheimersContainer.getLabel(), alzheimersContainer.getChoiceBox());
		
		creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobContainer.getLabel(), creutzfeldtJakobContainer.getChoiceBox());
	
		crohnsContainer.getChildren().addAll(crohnsContainer.getLabel(), crohnsContainer.getChoiceBox());
		
		cysticFibrosisContainer.getChildren().addAll(cysticFibrosisContainer.getLabel(), cysticFibrosisContainer.getChoiceBox());

		duchenneMDContainer.getChildren().addAll(duchenneMDContainer.getLabel(), duchenneMDContainer.getChoiceBox());
	
		hepBContainer.getChildren().addAll(hepBContainer.getLabel(), hepBContainer.getChoiceBox());
		
		heartDiseaseContainer.getChildren().addAll(heartDiseaseContainer.getLabel(), heartDiseaseContainer.getChoiceBox());
		
		huntingtonsContainer.getChildren().addAll(huntingtonsContainer.getLabel(), huntingtonsContainer.getChoiceBox());
		
		multipleSclerosisContainer.getChildren().addAll(multipleSclerosisContainer.getLabel(), multipleSclerosisContainer.getChoiceBox());
		
		rabiesContainer.getChildren().addAll(rabiesContainer.getLabel(), rabiesContainer.getChoiceBox());
        
		
		doneTerminalIllnessButton.setTranslateX(100);
		doneTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(mainInputScene)); 
		
		terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
			crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
			huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
		
	}
	
	Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 400);
	
	LifeExpectancy lifeExpectancy = new LifeExpectancy(Integer.parseInt(currentAgeTextField.getText()), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
			alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
			cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(),
			heartDiseaseContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(), multipleSclerosisContainer.getChoiceBox().getValue(),
			rabiesContainer.getChoiceBox().getValue());
			
			int yearsLeftToLive = lifeExpectancy.getLifeExpectancy();

	VBox outputSceneContainer = new VBox(); {
		
		
		ContainerWithinSceneContainer messageContainer = new ContainerWithinSceneContainer(50, 0, "Your Life Expectancy is " + yearsLeftToLive + " more years", 100);
		messageContainer.getChildren().addAll(messageContainer.getLabel());
		
		
		
		newCalculationButton.setTranslateX(100);
		newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene)); 
		
		
		enterTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(terminalIllnessInputScene)); 
		
	
		mainMenuButton.setTranslateX(100);
		mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
		
		outputSceneContainer.getChildren().addAll(messageContainer, newCalculationButton, mainMenuButton);
		
	}
    Scene outputScene = new Scene(outputSceneContainer, 400, 400);
    { calculateLifeExpectancyButton.setOnAction(event -> applicationStage.setScene(outputScene)); }
    

	public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}
	
}