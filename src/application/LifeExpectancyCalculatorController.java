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
    private TextField currentAgeTextField = new TextField();
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
    private Button startCalculationButton = new Button("Start Calculation");
    private Button enterTerminalIllnessButton = new Button("Enter Terminal Illness");
   // private Button saveButton = new Button("Save");
    //private Label saveLabel = new Label("You must press Save just before pressing Calculate.");
    private Button calculateLifeExpectancyButton = new Button("Calculate");
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
    private Button newCalculationButton = new Button("New Calculation");
    private Button mainMenuButton = new Button("Main Menu");
    private VBox mainMenuSceneContainer = new VBox();
    private VBox mainInputSceneContainer = new VBox();
    private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
    private VBox outputSceneContainer = new VBox();
    private Scene outputScene = new Scene(outputSceneContainer, 400, 400);
    private Label outputLabel = new Label();
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private LifeExpectancy lifeExpectancy = new LifeExpectancy("18", "Male", "Non-smoker", "No", "No", "No", "No", "No", "No", "No", "No", "No", "No");
    private String outputMessage = "";
	private boolean validCurrentAge = true;
	private boolean validNumberOfTerminalIllnesses = true;
	
	//Setting up the Main Menu Scene.
	{
	mainMenuSceneContainer.getChildren().add(startCalculationButton);
	Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
	
	mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	}
	
    //Setting up the Main Input Scene.
	{
	currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
	genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
	smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
	enterTerminalIllnessButton.setTranslateX(100);
	//saveButton.setTranslateX(100);
	//saveButton.setTranslateY(25);
	//saveLabel.setTranslateX(25);
	//saveLabel.setTranslateY(40);
	//saveButton.setOnAction(event -> lifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
	//		alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
	//		cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
	//		multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue()));
	calculateLifeExpectancyButton.setTranslateX(100);
	calculateLifeExpectancyButton.setTranslateY(60);
	
	mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
		enterTerminalIllnessButton, saveButton, saveLabel, calculateLifeExpectancyButton);
	startCalculationButton.setOnAction( event -> applicationStage.setScene(mainInputScene));
	doneTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
	newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
	}
	
	//Setting up the Terminal Illness Input Scene.
	{
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
	Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 800);
	
	enterTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(terminalIllnessInputScene));
	}
	
	//Setting up the Output Scene
	{
	newCalculationButton.setTranslateX(100);
	newCalculationButton.setTranslateY(10);
	mainMenuButton.setTranslateX(100);
	mainMenuButton.setTranslateY(40);
	outputSceneContainer.getChildren().addAll(outputLabel, newCalculationButton, mainMenuButton);
 	
	calculateLifeExpectancyButton.setOnAction(event -> calculateAndGoToOutputScene());
	}
	
    /** This method changes the scene to outputScene, setting outputMessage along the way.
     * 
     */
	public void calculateAndGoToOutputScene() {
		//Check if the current age entered contains a non-digit.
		for (char c : currentAgeTextField.getText().toCharArray())
			if (!Character.isDigit(c)) {
				validCurrentAge = false;
				outputMessage = "You entered " + c + " . Please enter a number.";
			}
		
		//Check if the current age entered is less than 18.
		if (Integer.parseInt(currentAgeTextField.getText()) < 18) {
			validCurrentAge = false;
			outputMessage = "You entered " + currentAgeTextField.getText() + ". Please enter a number at least 18.";
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
	    if (numberOfYes > 1) {
	    	validNumberOfTerminalIllnesses = false;
	    	outputMessage = "You may only select Yes for zero or one terminal illness.";
	    }

		if (validCurrentAge && validNumberOfTerminalIllnesses)
			outputMessage = "Your life expectancy is " + lifeExpectancy.getLifeExpectancy() + " more years";
		applicationStage.setScene(outputScene);
		outputLabel.setText(outputMessage);
	}
    
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}	
    
}