package application;

import java.lang.NumberFormatException;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** This class represents a controller for the GUI this program uses.
 * 
 * @author CS219-user
 *
 */
public class LifeExpectancyCalculatorController implements ErrorHandlable {

    @FXML
    /** This method sets up the scenes of the "game", then sets the scene to mainInputScene.
     * 
     * @param event (event is something that you want to trigger:
     * (1) a set-up of all the scenes of the "game", and
     * (2) a scene change to mainInputScene.)
     */
    void setUpScenesAndGoToMainInputScene(ActionEvent event) {
    	setUpMainMenuScene();
    	setUpMainInputScene();
    	setUpTerminalIllnessInputScene();
    	setUpOutputScene();
    	applicationStage.setScene(mainInputScene);
    }

    private Stage applicationStage;
    private LifeExpectancy lifeExpectancy = new LifeExpectancy("18", "Male", "Non-smoker", "No", "No", "No", "No", "No", "No", "No", "No", "No", "No");
    
    //ContainerWithinSceneContainer objects
    private ContainerWithinSceneContainerWithTextField currentAgeContainer = new ContainerWithinSceneContainerWithTextField(75, 25, "Current age: ", 100); 
    private ContainerWithinSceneContainerWithChoiceBox genderContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Gender: ", 100, "Male", "Male", "Female"); 
    private ContainerWithinSceneContainerWithChoiceBox smokingHabitsContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Smoking habits: ", 100,
		"Non-smoker", "Non-smoker", "Light smoker", "Moderate smoker", "Heavy smoker"); 
    
    private ContainerWithinSceneContainerWithChoiceBox alzheimersContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 25, "Alzheimer's Disease: ", 0, "No", "No", "Yes"); 
    private ContainerWithinSceneContainerWithChoiceBox creutzfeldtJakobContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Creutzfeldt-Jakob Disease: ", 0, "No", "No", "Yes"); 
    private ContainerWithinSceneContainerWithChoiceBox crohnsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Crohn's Disease: ", 0, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox cysticFibrosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Cystic Fibrosis: ", 0, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox duchenneMDContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Duchenne Muscular Dystrophy: ", 100, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox heartDiseaseContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Heart Disease: ", 0, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox hepBContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Hepatitis B: ", 0, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox huntingtonsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Huntington's Disease: ", 0, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox multipleSclerosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Multiple Sclerosis: ", 0, "No", "No", "Yes");
    private ContainerWithinSceneContainerWithChoiceBox rabiesContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Rabies: ", 0, "No", "No", "Yes");
   
    //Label objects
    private Label currentAgeErrorLabel = new Label("");
    private Label terminalIllnessErrorLabel = new Label("");
    private Label outputMessageLabel = new Label();
    
    //VBox and Scene objects  
    private VBox mainMenuSceneContainer = new VBox();
    private Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
    
    private VBox mainInputSceneContainer = new VBox();
    private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
    
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 650, 650);
    
    private VBox outputSceneContainer = new VBox();
    private Scene outputScene = new Scene(outputSceneContainer, 400, 550);

    //Objects related to the visual display
	private NumberAxis ageAxis = new NumberAxis();
	private CategoryAxis youVsAverageAxis = new CategoryAxis();
	private XYChart.Series<Number, String> yourData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> avgData = new XYChart.Series<Number, String>();
	private BarGraph visualDisplay = new BarGraph(ageAxis, youVsAverageAxis, "Results", "Age (years)", 90, yourData, avgData);
	
	/** This method creates the Main Menu Scene.
	 * 
	 */
	public void setUpMainMenuScene() {
		Label title = new Label("Life Expectancy Calculator");
		title.setTranslateX(60);
		title.setTranslateY(80);
		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		Button startCalculationButton = new Button("Start Calculation");
		startCalculationButton.setTranslateX(150);
		startCalculationButton.setTranslateY(150);
		
	    startCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		
	    mainMenuSceneContainer.getChildren().addAll(title, startCalculationButton);
	}
	
	/** This method creates the Main Input Scene.
	 * 
	 */
	public void setUpMainInputScene() {
	    currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeContainer.getControl());
		currentAgeContainer.setTranslateX(20);
		
		currentAgeErrorLabel.setTranslateX(20);
		currentAgeErrorLabel.setTranslateY(-20);
		
		genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getControl());
		genderContainer.setTranslateX(20);
		genderContainer.setTranslateY(-10);
		
		smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getControl());
		smokingHabitsContainer.setTranslateX(20);
				
	    Button enterTerminalIllnessButton = new Button("Enter Terminal Illness");
	    enterTerminalIllnessButton.setTranslateX(120);
	    enterTerminalIllnessButton.setTranslateY(-10);
		enterTerminalIllnessButton.setOnAction(event -> checkForCurrentAgeError(2));
		
	    Button calculateLifeExpectancyButton = new Button("Calculate");
		calculateLifeExpectancyButton.setTranslateX(165);
		calculateLifeExpectancyButton.setTranslateY(50);
		calculateLifeExpectancyButton.setOnAction(event -> checkForCurrentAgeError(1));
		
		mainInputSceneContainer.getChildren().addAll(currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, calculateLifeExpectancyButton);
	}
	
	/** This method creates the Terminal Illness Input Scene.
	 * 
	 */
	public void setUpTerminalIllnessInputScene() {
		alzheimersContainer.getChildren().addAll(alzheimersContainer.getLabel(), alzheimersContainer.getControl());
		alzheimersContainer.setTranslateX(20);
		alzheimersContainer.getControl().setTranslateX(10);
		
		creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobContainer.getLabel(), creutzfeldtJakobContainer.getControl());
		creutzfeldtJakobContainer.setTranslateX(20);
		creutzfeldtJakobContainer.getControl().setTranslateX(10);
		
		crohnsContainer.getChildren().addAll(crohnsContainer.getLabel(), crohnsContainer.getControl());
		crohnsContainer.setTranslateX(20);
		crohnsContainer.getControl().setTranslateX(10);
		
		cysticFibrosisContainer.getChildren().addAll(cysticFibrosisContainer.getLabel(), cysticFibrosisContainer.getControl());
		cysticFibrosisContainer.setTranslateX(20);
		cysticFibrosisContainer.getControl().setTranslateX(10);
		
		duchenneMDContainer.getChildren().addAll(duchenneMDContainer.getLabel(), duchenneMDContainer.getControl());	
		duchenneMDContainer.setTranslateX(20);
		duchenneMDContainer.getControl().setTranslateX(10);
		
		hepBContainer.getChildren().addAll(hepBContainer.getLabel(), hepBContainer.getControl());
		hepBContainer.setTranslateX(20);
		hepBContainer.getControl().setTranslateX(10);
		
		heartDiseaseContainer.getChildren().addAll(heartDiseaseContainer.getLabel(), heartDiseaseContainer.getControl());
		heartDiseaseContainer.setTranslateX(20);
		heartDiseaseContainer.getControl().setTranslateX(10);
		
		huntingtonsContainer.getChildren().addAll(huntingtonsContainer.getLabel(), huntingtonsContainer.getControl());
		huntingtonsContainer.setTranslateX(20);
		huntingtonsContainer.getControl().setTranslateX(10);
		
		multipleSclerosisContainer.getChildren().addAll(multipleSclerosisContainer.getLabel(), multipleSclerosisContainer.getControl());
		multipleSclerosisContainer.setTranslateX(20);
		multipleSclerosisContainer.getControl().setTranslateX(10);
		
		rabiesContainer.getChildren().addAll(rabiesContainer.getLabel(), rabiesContainer.getControl());
		rabiesContainer.setTranslateX(20);
		rabiesContainer.getControl().setTranslateX(10);
		
	    Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
		doneTerminalIllnessButton.setTranslateX(250);
		doneTerminalIllnessButton.setOnAction(event -> checkForTerminalIllnessErrors());
		
		terminalIllnessErrorLabel.setTranslateX(20);
		terminalIllnessErrorLabel.setTranslateY(20);
		
		terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
			crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
			huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton, terminalIllnessErrorLabel);
	}

	
	/** This method sets up the Output Scene.
	 * 
	 */
	public void setUpOutputScene() {
		outputMessageLabel.setTranslateX(70);
		outputMessageLabel.setTranslateY(20);
		outputMessageLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		visualDisplay.setTranslateY(40);
		
		Button newCalculationButton = new Button("New Calculation");
		newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		
	    Button mainMenuButton = new Button("Main Menu");
	    mainMenuButton.setTranslateX(20);
		mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	    
		HBox buttonBox = new HBox();
		buttonBox.setTranslateX(100);
		buttonBox.setTranslateY(70);
		buttonBox.getChildren().addAll(newCalculationButton, mainMenuButton);
		
		outputSceneContainer.getChildren().addAll(outputMessageLabel, visualDisplay, buttonBox);
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
	public void checkForCurrentAgeError(int sceneChoice) throws NumberFormatException {
		
		try {
			//Check if the current age entered is less than 18 or more than 100.
			if (Integer.parseInt(currentAgeContainer.getControl().getText()) < 18 || Integer.parseInt(currentAgeContainer.getControl().getText()) > 100) {
				currentAgeErrorLabel.setText("You entered " + currentAgeContainer.getControl().getText() + ". Please enter an integer between 18 and 100.");
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
		} catch(NumberFormatException numberFormatException) {
			currentAgeErrorLabel.setText("You entered " + currentAgeContainer.getControl().getText() + " . Please enter an integer.");
			currentAgeErrorLabel.setTextFill(Color.RED);
			throw numberFormatException;
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
		   	yesOrNoList.add(alzheimersContainer.getControl().getValue());
		   	yesOrNoList.add(creutzfeldtJakobContainer.getControl().getValue());
		   	yesOrNoList.add(crohnsContainer.getControl().getValue());
		   	yesOrNoList.add(cysticFibrosisContainer.getControl().getValue());
		   	yesOrNoList.add(duchenneMDContainer.getControl().getValue());
		   	yesOrNoList.add(heartDiseaseContainer.getControl().getValue());
		   	yesOrNoList.add(hepBContainer.getControl().getValue());
		   	yesOrNoList.add(huntingtonsContainer.getControl().getValue());
		   	yesOrNoList.add(multipleSclerosisContainer.getControl().getValue());
		   	yesOrNoList.add(rabiesContainer.getControl().getValue());
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
		} else if (Integer.parseInt(currentAgeContainer.getControl().getText()) < 65 && alzheimersContainer.getControl().getValue().equals("Yes")) {
		   	terminalIllnessErrorLabel.setText("You selected Alzheimer's Disease and your age is " + currentAgeContainer.getControl().getText() + ". Please do not select Alzheimer's Disease if you are less than 65.");
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
		LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeContainer.getControl().getText(), genderContainer.getControl().getValue(), smokingHabitsContainer.getControl().getValue(),
				alzheimersContainer.getControl().getValue(), creutzfeldtJakobContainer.getControl().getValue(), crohnsContainer.getControl().getValue(),
				cysticFibrosisContainer.getControl().getValue(), duchenneMDContainer.getControl().getValue(), heartDiseaseContainer.getControl().getValue(), hepBContainer.getControl().getValue(),
				huntingtonsContainer.getControl().getValue(), multipleSclerosisContainer.getControl().getValue(), rabiesContainer.getControl().getValue());
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
		yourData.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeContainer.getControl().getText()), ""));
		yourData.setName("Your Age At Death");
		avgData.getData().add(new XYChart.Data<Number, String>(86, ""));
		avgData.setName("Average Age At Death");
		visualDisplay.setLowerData(yourData);
		visualDisplay.setUpperData(avgData);

		applicationStage.setScene(outputScene);
		
		//Re-setting the default "No" values for all terminal illnesses (for the next calculation).
		alzheimersContainer.getControl().setValue("No");
		creutzfeldtJakobContainer.getControl().setValue("No");
		crohnsContainer.getControl().setValue("No");
		cysticFibrosisContainer.getControl().setValue("No");
		duchenneMDContainer.getControl().setValue("No");
		heartDiseaseContainer.getControl().setValue("No");
		hepBContainer.getControl().setValue("No");
		huntingtonsContainer.getControl().setValue("No");
		multipleSclerosisContainer.getControl().setValue("No");
		rabiesContainer.getControl().setValue("No");
	
	}
    
	/** This method returns applicationStage.
	 * 
	 * @return applicationStage (This is the application stage.)
	 */
	public Stage getApplicationStage() {
		return applicationStage;
	}
	
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}
    
    /** This method returns lifeExpectancy.
     * 
     * @return lifeExpectancy (This is the life expectancy of the user of the program.)
     */
    public LifeExpectancy getLifeExpectancy() {
    	return lifeExpectancy;
    }
    
    /** This method sets lifeExpectancy according to the parameter.
     * 
     * @param lifeExpectancyToSet (This is what you want to set lifeExpectancy to.)
     */
    public void setLifeExpectancy(LifeExpectancy lifeExpectancyToSet) {
    	lifeExpectancy = lifeExpectancyToSet;
    }
    
    /** This method returns currentAgeContainer.
     * 
     * @return currentAgeContainer (This is a container that holds widgets related to current age.)
     */
    public ContainerWithinSceneContainerWithTextField getCurrentAgeContainer() {
    	return currentAgeContainer;
    }
    
    /** This method sets currentAgeContainer according to the parameter.
     * 
     * @param currentAgeContainerToSet (This is what you want currentAgeContainer to be set to.)
     */
    public void setCurrentAgeContainer(ContainerWithinSceneContainerWithTextField currentAgeContainerToSet) {
    	currentAgeContainer = currentAgeContainerToSet;
    }
    
    /** This method returns genderContainer.
     * 
     * @return genderContainer (This is a container that holds widgets related to gender.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getGenderContainer() {
    	return genderContainer;
    }
    
    /** This method sets genderContainer according to the parameter.
     * 
     * @param genderContainerToSet (This is what you want genderContainer to be set to.)
     */
    public void setGenderContainer(ContainerWithinSceneContainerWithChoiceBox genderContainerToSet) {
    	genderContainer = genderContainerToSet;
    }
    
    /** This method returns smokingHabitsContainer.
     * 
     * @return smokingHabitsContainer (This is a container that holds widgets related to smoking habits.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getSmokingHabitsContainer() {
    	return smokingHabitsContainer;
    }
    
    /** This method sets smokingHabitsContainer according to the parameter.
     * 
     * @param smokingHabitsContainerToSet (This is what you want smokingHabitsContainer to be set to.)
     */
    public void setSmokingHabitsContainer(ContainerWithinSceneContainerWithChoiceBox smokingHabitsContainerToSet) {
    	smokingHabitsContainer = smokingHabitsContainerToSet;    	
    }
    
    /** This method returns alzheimersContainer.
     * 
     * @return alzheimersContainer (This is a container that holds widgets related to Alzheimer's.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getAlzheimersContainer() {
    	return alzheimersContainer;
    }
    
    /** This method sets alzheimersContainer according to the parameter.
     * 
     * @param alzheimersContainerToSet (This is what you want alzheimersContainer to be set to.)
     */
    public void setAlzheimersContainer(ContainerWithinSceneContainerWithChoiceBox alzheimersContainerToSet) {
    	alzheimersContainer = alzheimersContainerToSet;
    }
    
    /** This method returns creutzfeldtJakobContainer.
     * 
     * @return creutzfeldtJakobContainer (This is a container that holds widgets related to Creutzfeldt-Jakob.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getCreutzfeldtJakobContainer() {
    	return creutzfeldtJakobContainer;
    }
    
    /** This method sets creutzfeldtJakobContainer according to the parameter.
     * 
     * @param creutzfeldtJakobContainerToSet (This is what you want creutzfeldtJakobContainer to be set to.)
     */
    public void setCreutzfeldtJakobContainer(ContainerWithinSceneContainerWithChoiceBox creutzfeldtJakobContainerToSet) {
    	creutzfeldtJakobContainer = creutzfeldtJakobContainerToSet;    	
    }
    
    /** This method returns crohnsContainer.
     * 
     * @return crohnsContainer (This is a container that holds widgets related to Crohns.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getCrohnsContainer() {
    	return crohnsContainer;
    }
    
    /** This method sets crohnsContainer according to the parameter.
     * 
     * @param crohnsContainerToSet (This is what you want crohnsContainer to be set to.)
     */
    public void setCrohnsContainer(ContainerWithinSceneContainerWithChoiceBox crohnsContainerToSet) {
    	crohnsContainer = crohnsContainerToSet;    	
    }
    
    /** This method returns cysticFibrosisContainer.
     * 
     * @return cysticFibrosisContainer (This is a container that holds widgets related to Cystic Fibrosis.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getCysticFibrosisContainer() {
    	return cysticFibrosisContainer;
    }
    
    /** This method sets cysticFibrosisContainer according to the parameter.
     * 
     * @param cysticFibrosisContainerToSet (This is what you want cysticFibrosisContainer to be set to.)
     */
    public void setCysticFibrosisContainer(ContainerWithinSceneContainerWithChoiceBox cysticFibrosisContainerToSet) {
    	cysticFibrosisContainer = cysticFibrosisContainerToSet;    	
    }
    
    /** This method returns duchenneMDContainer.
     * 
     * @return duchenneMDContainer (This is a container that holds widgets related to Duchenne MD.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getDuchenneMDContainer() {
    	return duchenneMDContainer;
    }
    
    /** This method sets duchenneMDContainer according to the parameter.
     * 
     * @param duchenneMDContainerToSet (This is what you want duchenneMDContainer to be set to.)
     */
    public void setDuchenneMDContainer(ContainerWithinSceneContainerWithChoiceBox duchenneMDContainerToSet) {
    	duchenneMDContainer = duchenneMDContainerToSet;    	
    }
    
    /** This method returns heartDiseaseContainer.
     * 
     * @return heartDiseaseContainer (This is a container that holds widgets related to Heart Disease.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getHeartDiseaseContainer() {
    	return heartDiseaseContainer;
    }
    
    /** This method sets heartDiseaseContainer according to the parameter.
     * 
     * @param heartDiseaseContainerToSet (This is what you want heartDiseaseContainer to be set to.)
     */
    public void setHeartDiseaseContainer(ContainerWithinSceneContainerWithChoiceBox heartDiseaseContainerToSet) {
    	heartDiseaseContainer = heartDiseaseContainerToSet;    	
    }
    
    /** This method returns hepBContainer.
     * 
     * @return hepBContainer (This is a container that holds widgets related to Hep B.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getHepBContainer() {
    	return hepBContainer;
    }
    
    /** This method sets hepBContainer according to the parameter.
     * 
     * @param hepBContainerToSet (This is what you want hepBContainer to be set to.)
     */
    public void setHepBContainer(ContainerWithinSceneContainerWithChoiceBox hepBContainerToSet) {
    	hepBContainer = hepBContainerToSet;    	
    }
    
    /** This method returns huntingtonsContainer.
     * 
     * @return huntingtonsContainer (This is a container that holds widgets related to Huntington's.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getHuntingtonsContainer() {
    	return huntingtonsContainer;
    }
    
    /** This method sets huntingtonsContainer according to the parameter.
     * 
     * @param huntingtonsContainerToSet (This is what you want huntingtonsContainer to be set to.)
     */
    public void setHuntingtonsContainer(ContainerWithinSceneContainerWithChoiceBox huntingtonsContainerToSet) {
    	huntingtonsContainer = huntingtonsContainerToSet;    	
    }
    
    /** This method returns multipleSclerosisContainer.
     * 
     * @return multipleSclerosisContainer (This is a container that holds widgets related to Multiple Sclerosis.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getMultipleSclerosisContainer() {
    	return multipleSclerosisContainer;
    }
    
    /** This method sets multipleSclerosisContainer according to the parameter.
     * 
     * @param multipleSclerosisContainerToSet (This is what you want multipleSclerosisContainer to be set to.)
     */
    public void setMultipleSclerosisContainer(ContainerWithinSceneContainerWithChoiceBox multipleSclerosisContainerToSet) {
    	multipleSclerosisContainer = multipleSclerosisContainerToSet;    	
    }
    
    /** This method returns rabiesContainer.
     * 
     * @return rabiesContainer (This is a container that holds widgets related to Rabies.)
     */
    public ContainerWithinSceneContainerWithChoiceBox getRabiesContainer() {
    	return rabiesContainer;
    }
    
    /** This method sets rabiesContainer according to the parameter.
     * 
     * @param rabiesContainerToSet (This is what you want rabiesContainer to be set to.)
     */
    public void setRabiesContainer(ContainerWithinSceneContainerWithChoiceBox rabiesContainerToSet) {
    	rabiesContainer = rabiesContainerToSet;    	
    }
    
    /** This method returns currentAgeErrorLabel.
     * 
     * @return currentAgeErrorLabel (This is the error message for current age input.)
     */
    public Label getCurrentAgeErrorLabel() {
    	return currentAgeErrorLabel;
    }
    
    /** This method sets currentAgeErrorLabel according to the parameter.
     * 
     * @param currentAgeErrorLabelToSet (This is what you want currentAgeErrorLabel to be set to.)
     */
    public void setCurrentAgeErrorLabel(Label currentAgeErrorLabelToSet) {
    	currentAgeErrorLabel = currentAgeErrorLabelToSet;    	
    }
    
    /** This method returns terminalIllnessErrorLabel.
     * 
     * @return terminalIllnessErrorLabel (This is the error message for terminal illness input.)
     */
    public Label getTerminalIllnessLabel() {
    	return terminalIllnessErrorLabel;
    }
    
    /** This method sets terminalIllnessErrorLabel according to the parameter.
     * 
     * @param terminalIllnessErrorLabelToSet (This is what you want terminalIllnessErrorLabel to be set to.)
     */
    public void setTerminalIllnessErrorLabel(Label terminalIllnessErrorLabelToSet) {
    	terminalIllnessErrorLabel = terminalIllnessErrorLabelToSet;    	
    }
    
    /** This method returns outputMessageLabel.
     * 
     * @return outputMessageLabel (This is the output message.)
     */
    public Label getoutputMessageLabel() {
    	return outputMessageLabel;
    }
    
    /** This method sets outputMessageLabel according to the parameter.
     * 
     * @param outputMessageLabelToSet (This is what you want outputMessageErrorLabel to be set to.)
     */
    public void setOutputMessageLabel(Label outputMessageLabelToSet) {
    	outputMessageLabel = outputMessageLabelToSet;    	
    }
    
    /** This method returns mainMenuSceneContainer.
     * 
     * @return mainMenuSceneContainer (This is what shows in the Main Menu Scene.)
     */
    public VBox getMainMenuSceneContainer() {
    	return mainMenuSceneContainer;
    }
    
    /** This method sets mainMenuSceneContainer according to the parameter.
     * 
     * @param mainMenuSceneContainerToSet (This is what you want mainMenuSceneContainer to be set to.)
     */
    public void setMainMenuSceneContainer(VBox mainMenuSceneContainerToSet) {
    	mainMenuSceneContainer = mainMenuSceneContainerToSet;    	
    }
    
    /** This method returns mainMenuScene.
     * 
     * @return mainMenuScene (This is the Main Menu Scene.)
     */
    public Scene getMainMenuScene() {
    	return mainMenuScene;
    }
    
    /** This method sets mainMenuScene according to the parameter.
     * 
     * @param mainMenuSceneToSet (This is what you want mainMenuScene to be set to.)
     */
    public void setMainMenuScene(Scene mainMenuSceneToSet) {
    	mainMenuScene = mainMenuSceneToSet;    	
    }
    
    /** This method returns mainInputSceneContainer.
     * 
     * @return mainInputSceneContainer (This is what shows in the Main Input Scene.)
     */
    public VBox getMainInputSceneContainer() {
    	return mainInputSceneContainer;
    }
    
    /** This method sets mainInputSceneContainer according to the parameter.
     * 
     * @param mainInputSceneContainerToSet (This is what you want mainInputSceneContainer to be set to.)
     */
    public void setMainInputSceneContainer(VBox mainInputSceneContainerToSet) {
    	mainInputSceneContainer = mainInputSceneContainerToSet;    	
    }
    
    /** This method returns mainInputScene.
     * 
     * @return mainInputScene (This is the Main Input Scene.)
     */
    public Scene getMainInputScene() {
    	return mainInputScene;
    }
    
    /** This method sets mainInputScene according to the parameter.
     * 
     * @param mainInputSceneToSet (This is what you want mainInputScene to be set to.)
     */
    public void setMainInputScene(Scene mainInputSceneToSet) {
    	mainInputScene = mainInputSceneToSet;    	
    }
    
    /** This method returns terminalIllnessInputSceneContainer.
     * 
     * @return terminalIllnessInputSceneContainer (This is what shows in the Terminal Illness Input Scene.)
     */
    public VBox getTerminalIllnessInputSceneContainer() {
    	return terminalIllnessInputSceneContainer;
    }
    
    /** This method sets terminalIllnessInputSceneContainer according to the parameter.
     * 
     * @param terminalIllnessInputSceneContainerToSet (This is what you want terminalIllnessInputSceneContainer to be set to.)
     */
    public void setTerminalIllnessInputSceneContainer(VBox terminalIllnessInputSceneContainerToSet) {
    	terminalIllnessInputSceneContainer = terminalIllnessInputSceneContainerToSet;    	
    }
    
    /** This method returns terminalIllnessInputScene.
     * 
     * @return terminalIllnessInputScene (This is the Terminal Illness Input Scene.)
     */
    public Scene getTerminalIllnessInputScene() {
    	return terminalIllnessInputScene;
    }
    
    /** This method sets terminalIllnessInputScene according to the parameter.
     * 
     * @param terminalIllnessInputSceneToSet (This is what you want terminalIllnessInputScene to be set to.)
     */
    public void setTerminalIllnessInputScene(Scene terminalIllnessInputSceneToSet) {
    	terminalIllnessInputScene = terminalIllnessInputSceneToSet;    	
    }
    
    /** This method returns outputSceneContainer.
     * 
     * @return outputSceneContainer (This is what shows in the Output Scene.)
     */
    public VBox getOutputSceneContainer() {
    	return outputSceneContainer;
    }
    
    /** This method sets outputSceneContainer according to the parameter.
     * 
     * @param outputContainerToSet (This is what you want outputSceneContainer to be set to.)
     */
    public void setOutputSceneContainer(VBox outputSceneContainerToSet) {
    	outputSceneContainer = outputSceneContainerToSet;    	
    }
    
    /** This method returns outputScene.
     * 
     * @return outputScene (This is the Output Scene.)
     */
    public Scene getOutputScene() {
    	return outputScene;
    }
    
    /** This method sets outputScene according to the parameter.
     * 
     * @param outputSceneToSet (This is what you want outputScene to be set to.)
     */
    public void setOutputScene(Scene outputSceneToSet) {
    	outputScene = outputSceneToSet;    	
    }
    
    /** This method returns ageAxis.
     * 
     * @return ageAxis (This is the x-axis of the bar graph.)
     */
    public NumberAxis getAgeAxis() {
    	return ageAxis;
    }
    
    /** This method sets ageAxis according to the parameter.
     * 
     * @param ageAxisToSet (This is what you want ageAxis to be set to.)
     */
    public void setAgeAxis(NumberAxis ageAxisToSet) {
    	ageAxis = ageAxisToSet;    	
    }
    
    /** This method returns youVsAverageAxis.
     * 
     * @return youVsAverageAxis (This is the y-axis of the bar graph.)
     */
    public CategoryAxis getYouVsAverageAxis() {
    	return youVsAverageAxis;
    }
    
    /** This method sets youVsAverageAxis according to the parameter.
     * 
     * @param youVsAverageAxisToSet (This is what you want youVsAverageAxis to be set to.)
     */
    public void setYouVsAverageAxis(CategoryAxis youVsAverageAxisToSet) {
    	youVsAverageAxis = youVsAverageAxisToSet;    	
    }
    
    /** This method returns yourData.
     * 
     * @return yourData (This is your data in the bar graph.)
     */
    public XYChart.Series<Number, String> getYourData() {
    	return yourData;
    }
    
    /** This method sets yourData according to the parameter.
     * 
     * @param yourData (This is what you want yourData to be set to.)
     */
    public void setYourData(XYChart.Series<Number, String> yourDataToSet) {
    	yourData = yourDataToSet;    	
    }
    
    /** This method returns avgData.
     * 
     * @return avgData (This is the "average" data in the bar graph.)
     */
    public XYChart.Series<Number, String> getAvgData() {
    	return avgData;
    }
    
    /** This method sets avgData according to the parameter.
     * 
     * @param avgData (This is what you want avgData to be set to.)
     */
    public void setAvgData(XYChart.Series<Number, String> avgDataToSet) {
    	avgData = avgDataToSet;    	
    }
    
    /** This method returns visualDisplay.
     * 
     * @return visualDisplay (This is the bar graph.)
     */
    public BarGraph getVisualDisplay() {
    	return visualDisplay;
    }
    
    /** This method sets visualDisplay according to the parameter.
     * 
     * @param visualDisplay (This is what you want visualDisplay to be set to.)
     */
    public void setVisualDisplay(BarGraph visualDisplayToSet) {
    	visualDisplay = visualDisplayToSet;    	
    }
    
}