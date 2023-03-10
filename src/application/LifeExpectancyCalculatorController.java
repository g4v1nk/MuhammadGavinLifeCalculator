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
    private TextField currentAgeTextField = new TextField();
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
    private ContainerWithinSceneContainerWithChoiceBox heartDiseaseContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Heart Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox hepBContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Hepatitis B: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox huntingtonsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Huntington's Disease: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox multipleSclerosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Multiple Sclerosis: ", 100, "No", "No", "Yes", null, null);
    private ContainerWithinSceneContainerWithChoiceBox rabiesContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Rabies: ", 100, "No", "No", "Yes", null, null);
    //Declaring variables that reference objects that will be added to scene containers.
    private Button startCalculationButton = new Button("Start Calculation");
    private Button enterTerminalIllnessButton = new Button("Enter Terminal Illness");
    private Button saveButton = new Button("Save");
    private Label saveLabel = new Label("You must press Save just before pressing Calculate.");
    private Button calculateLifeExpectancyButton = new Button("Calculate");
    private Label currentAgeErrorMessage = new Label("Current age error message");
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
    private Label numberOfTerminalIllnessesErrorMessage = new Label("Number of terminal illnesses error message");
    private Button newCalculationButton = new Button("New Calculation");
    private Button mainMenuButton = new Button("Main Menu");
    //Calculating the user's life expectancy (but only if all user input is valid).
	
    /* Need to define messageContainer separately from the other variables that reference containers that will be added to scene containers,
    because messageContainer is constructed based on the variable yearsLeftToLive, which is not set to a value until just above here. */
    
    //Declaring variables that reference scene containers.
    private VBox mainMenuSceneContainer = new VBox();
    private VBox mainInputSceneContainer = new VBox();
    private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private VBox outputSceneContainer = new VBox();
    //Declaring variables that reference scenes.
    /* Note: The Main Menu Scene is also created in the Main class, but it needs to be re-created here since the Main Menu Scene is referenced in this class
    (outside the scope of where the Main Menu Scene is created in the Main class.) */
    private LifeExpectancy lifeExpectancy;
    private String outputMessage = "";
	private boolean validCurrentAge = true;
	private boolean validNumberOfTerminalIllnesses = true;
	
    {
	currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
	genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
	smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
	enterTerminalIllnessButton.setTranslateX(100);
	saveButton.setTranslateX(100);
	saveButton.setOnAction(event -> lifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
			alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
			cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
			multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue()));
	calculateLifeExpectancyButton.setTranslateX(100);
	calculateLifeExpectancyButton.setTranslateY(25);
	calculateLifeExpectancyButton.setOnAction(event -> calculateAndGoToOutputScene()); }
	
    /** This method changes the scene to outputScene, setting outputMessage along the way.
     * 
     */
	public void calculateAndGoToOutputScene() {
		for (char c : currentAgeTextField.getText().toCharArray())
			if (!Character.isDigit(c)) {
				validCurrentAge = false;
				outputMessage = "You entered " + c + " . Please enter a number.";
			}
		if (Integer.parseInt(currentAgeTextField.getText()) < 18) {
			validCurrentAge = false;
			outputMessage = "You entered " + currentAgeTextField.getText() + " . Please enter a number at least 18.";
		}
		
		//Check if "Yes" is selected for more than one terminal illness.
		ArrayList<String> yesOrNoList = new ArrayList<String>();
	      	yesOrNoList.add(alzheimersContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(creutzfeldtJakobContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(crohnsContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(cysticFibrosisContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(duchenneMDContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(heartDiseaseContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(hepBContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(huntingtonsContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(multipleSclerosisContainer.getChoiceBox().getValue());
	      	yesOrNoList.add(rabiesContainer.getChoiceBox().getValue());
	      	
	      	int numberOfYes = 0;
	      	for (String element : yesOrNoList) {
	      		if (element.equals("Yes"))
	      			numberOfYes += 1;
	      	}
	      	if (numberOfYes > 1)
	      		validNumberOfTerminalIllnesses = false;
	      		outputMessage = "You may only select Yes for zero or one terminal illness.";

		if (validCurrentAge && validNumberOfTerminalIllnesses)
			lifeExpectancy.getLifeExpectancy();
		applicationStage.setScene(outputScene);
		
	}
	
    
	
	
	
		
	/* //Main Menu Scene
	mainMenuSceneContainer.getChildren().add(startCalculationButton);
	Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
	mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	
	//Main Input Scene
	 * 
	 * */
	
	
	
	


	
	/* int yearsLeftToLive = 0;
	String outputMessage = "";
	if (!(lifeExpectancy.getCurrentAge() == Integer.parseInt(currentAgeTextField.getText())))
			outputMessage = currentAgeErrorMessage.getText();
	if (!(lifeExpectancy.getAlzheimers() == alzheimersContainer.getChoiceBox().getValue()))
			outputMessage = numberOfTerminalIllnessesErrorMessage.getText();
	else
			yearsLeftToLive = lifeExpectancy.getLifeExpectancy();
			outputMessage = "Your Life Expectancy is " + yearsLeftToLive + " more years";
	System.out.println(outputMessage); */
	
	
	mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
		enterTerminalIllnessButton, calculateLifeExpectancyButton);
	doneTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
	newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene)); }
	
	//public void printOutputMessage() {int yearsLeftToLive = 0;
	//String outputMessage = "";
	//if (!(lifeExpectancy.getCurrentAge() == Integer.parseInt(currentAgeTextField.getText())))
	//		outputMessage = currentAgeErrorMessage.getText();
	//if (!(lifeExpectancy.getAlzheimers() == alzheimersContainer.getChoiceBox().getValue()))
	//		outputMessage = numberOfTerminalIllnessesErrorMessage.getText();
	//else
	//		yearsLeftToLive = lifeExpectancy.getLifeExpectancy();
	//		outputMessage = "Your Life Expectancy is " + yearsLeftToLive + " more years";
	//System.out.println(outputMessage);
	//System.out.println(outputMessage);}/*

// System.out.println(currentAgeTextField.getText()); }/*
	
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

	terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
		crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
		huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
	Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 400);
	
	enterTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(terminalIllnessInputScene));
	
	//Output Scene
	newCalculationButton.setTranslateX(100);
	newCalculationButton.setTranslateX(100);

	mainMenuButton.setTranslateX(100);
	
	
	//Check for valid input by checking if the parameters passed to the LifeExpectancy constructor survived error handling.
	//LifeExpectancy lifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderChoiceBox.getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
		//	alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
			//cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(),
//			heartDiseaseContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(), multipleSclerosisContainer.getChoiceBox().getValue(),
//			rabiesContainer.getChoiceBox().getValue());
	int yearsLeftToLive = 0;
//	String outputMessage = "";
	if (!(lifeExpectancy.getCurrentAge() == Integer.parseInt(currentAgeTextField.getText())))
			outputMessage = currentAgeErrorMessage.getText();
	if (!(lifeExpectancy.getAlzheimers() == alzheimersContainer.getChoiceBox().getValue()))
			outputMessage = numberOfTerminalIllnessesErrorMessage.getText();
	else
			yearsLeftToLive = lifeExpectancy.getLifeExpectancy();
			outputMessage = "Your Life Expectancy is " + yearsLeftToLive + " more years";
	ContainerWithinSceneContainer messageContainer = new ContainerWithinSceneContainer(50, 0, outputMessage, 100);
 	messageContainer.getChildren().addAll(messageContainer.getLabel());
 	outputSceneContainer.getChildren().addAll(messageContainer, newCalculationButton, mainMenuButton);
 	Scene outputScene = new Scene(outputSceneContainer, 400, 400);
 	
 	calculateLifeExpectancyButton.setOnAction(event -> applicationStage.setScene(outputScene));
	}
    
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}	
    
}