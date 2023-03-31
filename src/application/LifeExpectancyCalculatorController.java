package application;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private LifeExpectancy lifeExpectancy = new LifeExpectancy("18", "Male", "Non-smoker", "No", "No", "No", "No", "No", "No", "No", "No", "No", "No");
    
    //ContainerWithinSceneContainer objects
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
   
    //Button objects
    private Button startCalculationButton = new Button("Start Calculation");
    private Button enterTerminalIllnessButton = new Button("Enter Terminal Illness");
    private Button calculateLifeExpectancyButton = new Button("Calculate");
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
    private Button newCalculationButton = new Button("New Calculation");
    private Button mainMenuButton = new Button("Main Menu");
    
    //Label objects
    private Label currentAgeErrorLabel = new Label("");
    private Label terminalIllnessErrorLabel = new Label("");
    private Label outputMessageLabel = new Label();
    
    //VBox and Scene objects
    private VBox mainMenuSceneContainer = new VBox();
    private VBox mainInputSceneContainer = new VBox();
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private VBox outputSceneContainer = new VBox();
    private Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
    private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
    private Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 800, 800);
    private Scene outputScene = new Scene(outputSceneContainer, 400, 400);

    //Objects related to the visual display
	private NumberAxis ageAxis = new NumberAxis();
	private CategoryAxis youVsAverageAxis = new CategoryAxis();
	private XYChart.Series<Number, String> yourData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> avgData = new XYChart.Series<Number, String>();
	private BarGraph visualDisplay = new BarGraph(ageAxis, youVsAverageAxis, "Results", "Age (years)", 90, yourData, avgData);
	
	//Setting up the Main Menu Scene.
	{mainMenuSceneContainer.getChildren().add(startCalculationButton);
	
    //Setting up the Main Input Scene.
	
	currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
	genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
	smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
	enterTerminalIllnessButton.setTranslateX(100);
	calculateLifeExpectancyButton.setTranslateX(100);
	calculateLifeExpectancyButton.setTranslateY(60);
	
	mainInputSceneContainer.getChildren().addAll(currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
		enterTerminalIllnessButton, calculateLifeExpectancyButton);
	
	
	//Setting up the Terminal Illness Input Scene.
	//
	
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
		huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton, terminalIllnessErrorLabel);
	}
	
	//Setting up the Output Scene
	{
	newCalculationButton.setTranslateX(100);
	newCalculationButton.setTranslateY(10);
	mainMenuButton.setTranslateX(100);
	mainMenuButton.setTranslateY(40);
	outputSceneContainer.getChildren().addAll(outputMessageLabel, newCalculationButton, mainMenuButton, visualDisplay);
	}
	
	//Setting the "onAction"s for the buttons.
	{
	mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	startCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
	doneTerminalIllnessButton.setOnAction(event -> checkForTerminalIllnessErrors());
	newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
	enterTerminalIllnessButton.setOnAction(event -> checkForCurrentAgeError(2));
	calculateLifeExpectancyButton.setOnAction(event -> checkForCurrentAgeError(1));
	}
	
	/** This method checks for errors in current age input.
	 * If there is an error, then an error message is added to mainInputScene.
	 * If there are no errors, then, depending on the number specified in the parameter,
	 * either calculateAndGoToOutputScene() will be called, or the scene will be set to terminalIllnessInputScene.
	 * 
	 * @param sceneChoice (This is a number that corresponds to the scene that you
	 * want to go to after current age input errors have been checked for.
	 * The number should be 1 if you want to go to the Output Scene, and the number
	 * can be any other integer if you want to go to the Terminal Illness Input Scene.)
	 */
	public void checkForCurrentAgeError(int sceneChoice) {
		
		try {
			//Check if the current age entered is less than 18 or more than 100.
			if (Integer.parseInt(currentAgeTextField.getText()) < 18 || Integer.parseInt(currentAgeTextField.getText()) > 100) {
				currentAgeErrorLabel.setText("You entered " + currentAgeTextField.getText() + ". Please enter an integer between 18 and 100.");
				currentAgeErrorLabel.setTextFill(Color.RED);
			
				//"Refresh" the scene so that it now has the error message.
				applicationStage.setScene(mainInputScene);
			} else {
				//Clear the error message for future "gameplays".
				currentAgeErrorLabel.setText("");
				if (sceneChoice == 1)
					calculateAndGoToOutputScene();
				else
					applicationStage.setScene(terminalIllnessInputScene);
			}
		} catch(Exception numberFormatException) {
			currentAgeErrorLabel.setText("You entered " + currentAgeTextField.getText() + " . Please enter an integer.");
			currentAgeErrorLabel.setTextFill(Color.RED);
		}
				
	}
	
	/** This method checks if more than one terminal illness has been entered, or if Alzheimer's disease has been entered when current age is less than 65.
	 * If one of the above errors is present, an error message is added to terminalIllnessInputScene.
	 * Otherwise, the scene will be set to mainInputScene.
	 * 
	 */
	public void checkForTerminalIllnessErrors() {
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
		   	terminalIllnessErrorLabel.setText("You selected " + numberOfYes + " terminal illnesses. Please do not select more than one.");
		   	terminalIllnessErrorLabel.setTextFill(Color.RED);
		   	
		    //Refresh the scene so that it shows the error message.
		   	applicationStage.setScene(terminalIllnessInputScene);
		} else if (Integer.parseInt(currentAgeTextField.getText()) < 65 && alzheimersContainer.getChoiceBox().getValue().equals("Yes")) {
		   	terminalIllnessErrorLabel.setText("You selected Alzheimer's Disease and your age is " + currentAgeTextField.getText() + ". Please do not select Alzheimer's Disease if you are less than 65.");
		   	terminalIllnessErrorLabel.setTextFill(Color.RED);
		   	
		    //Refresh the scene so that it shows the error message.
		   	applicationStage.setScene(terminalIllnessInputScene);
		} else {
			//Clear the error message for future "gameplays".
			terminalIllnessErrorLabel.setText("");
			applicationStage.setScene(mainInputScene);
		}
	}	
	
    /** This method changes the scene to outputScene, setting outputMessage along the way.
     * 
     */
	public void calculateAndGoToOutputScene() {
		
		//Update the instance variables of lifeExpectancy based on user input.
		LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
				alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
				cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
				multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue());
		lifeExpectancy = newLifeExpectancy;
		
		/**
		 * 
		 * //Check if the current age entered contains a non-digit.
		for (char c : currentAgeTextField.getText().toCharArray())
			if (!Character.isDigit(c)) {
				validCurrentAge = false;
				outputMessage = "You entered " + c + " . Please enter a number.";
			}
			
		**/
	    	
		outputMessageLabel.setText("You are expected to live " + lifeExpectancy.calculateLifeExpectancy() + " more years.");
		
		//Setting up a bar graph of the user's results.
		yourData.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeTextField.getText()), ""));
		yourData.setName("Your Age At Death");
		avgData.getData().add(new XYChart.Data<Number, String>(86, ""));
		avgData.setName("Average Age At Death");
		visualDisplay.setLowerData(yourData);
		visualDisplay.setUpperData(avgData);

		applicationStage.setScene(outputScene);
	
	}
    
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}	
    
}