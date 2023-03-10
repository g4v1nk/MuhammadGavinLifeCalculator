package application;

import java.io.FileInputStream;
import java.util.ArrayList;

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
public class LifeExpectancyCalculatorController {

    @FXML
    /** This method sets the scene to mainInputScene.
     * 
     * @param event (event is something that you want to trigger a scene change to mainInputScene.)
     */
    void goToMainInputScene(ActionEvent event) {
    	applicationStage.setScene(mainInputScene);
    }

    private Stage applicationStage;
    /* While the other variables that reference objects that will be added to scene containers are defined lower down in the code (starting on line 84),
    this variables that references a TextField is defined here since the variable is used in line 42 (before line 84). */
    private TextField currentAgeTextField = new TextField("18");
    //Declaring variables that reference containers that will be added to scene containers.
    private ContainerWithinSceneContainer currentAgeContainer = new ContainerWithinSceneContainer(75, 25, "Current age: ", 100); 
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
    //Declaring variables that reference objects that will be added to scene containers.
    private Button startCalculationButton = new Button("Start Calculation");
    private Button enterTerminalIllnessButton = new Button("Enter Terminal Illness");
    private Button calculateLifeExpectancyButton = new Button("Calculate Life Expectancy");
    private Label currentAgeErrorMessage = new Label("Current age error message");
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
    private Label numberOfTerminalIllnessesErrorMessage = new Label("Number of terminal illnesses error message");
    private Button newCalculationButton = new Button("New Calculation");
    private Button mainMenuButton = new Button("Main Menu");
    //Calculating the user's life expectancy (but only if all user input is valid).
	private LifeExpectancy lifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
	alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
	cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(),
	heartDiseaseContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(), multipleSclerosisContainer.getChoiceBox().getValue(),
	rabiesContainer.getChoiceBox().getValue());
	private int yearsLeftToLive = 0;
	private String outputMessage = "";
	
    /* Need to define messageContainer separately from the other variables that reference containers that will be added to scene containers,
    because messageContainer is constructed based on the variable yearsLeftToLive, which is not set to a value until just above here. */
    private ContainerWithinSceneContainer messageContainer = new ContainerWithinSceneContainer(50, 0, outputMessage, 100);
    //Declaring variables that reference scene containers.
    private VBox mainMenuSceneContainer = new VBox();
    private VBox mainInputSceneContainer = new VBox();
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private VBox outputSceneContainer = new VBox();
    //Declaring variables that reference scenes.
    /* Note: The Main Menu Scene is also created in the Main class, but it needs to be re-created here since the Main Menu Scene is referenced in this class
    (outside the scope of where the Main Menu Scene is created in the Main class.) */
    private Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
	private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
	private Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 400);
	private Scene outputScene = new Scene(outputSceneContainer, 400, 400);
	{
	//Main Menu Scene
	mainMenuSceneContainer.getChildren().add(startCalculationButton);
	
	//Main Input Scene
	currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
	genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
	smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
	enterTerminalIllnessButton.setTranslateX(100);
	enterTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(terminalIllnessInputScene));
	calculateLifeExpectancyButton.setTranslateX(100);
	calculateLifeExpectancyButton.setTranslateY(25);
	calculateLifeExpectancyButton.setOnAction(event -> applicationStage.setScene(outputScene));
	mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
		enterTerminalIllnessButton, calculateLifeExpectancyButton);
	
	//Only invoke getLifeExpectancy() on lifeExpectancy if the parameters passed to the LifeExpectancy constructor survived error handling.
		//if (!lifeExpectancy.getCurrentAge() == Integer.parseInt(currentAgeTextField.getText()))
		//	outputMessage = currentAgeErrorMessage;
		//if (!lifeExpectancy.getAlzheimers() == alzheimersContainer.getChoiceBox().getValue())
		//	outputMessage = numberOfTerminalIllnessesErrorMessage;
		//else
			yearsLeftToLive = lifeExpectancy.getLifeExpectancy();
			outputMessage = "Your Life Expectancy is " + yearsLeftToLive + " more years";
	
	//Terminal Illness Input Scene
	
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
	
	//Output Scene
	newCalculationButton.setTranslateX(100);
	newCalculationButton.setTranslateX(100);
	newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
	mainMenuButton.setTranslateX(100);
	mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
 	messageContainer.getChildren().addAll(messageContainer.getLabel());
 	outputSceneContainer.getChildren().addAll(messageContainer, newCalculationButton, mainMenuButton);
	}
	//Setting the "onAction"s for each button.

    
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}	
    
}