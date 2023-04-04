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
    /** This method sets up the scenes of the "game", then sets the scene to mainInputScene.
     * 
     * @param event (event is something that you want to trigger:
     * (1) a set-up of all the scenes of the "game", and
     * (2) a scene change to mainInputScene.)
     */
    public void setUpScenesAndGoToMainInputScene(ActionEvent event) {
    	setUpMainMenuScene();
    	setUpNumOfPeopleInputScene();
    	setUpMainInputScene();
    	setUpTerminalIllnessInputScene();
    	setUpOutputScene();
    	applicationStage.setScene(mainInputScene);
    }
    
    @FXML
    /** This method sets up the scenes of the "game", then sets the scene to numOfPeopleInputScene.
     * 
     * @param event (event is something that you want to trigger:
     * (1) a set-up of all the scenes of the "game", and
     * (2) a scene change to numOfPeopleInputScene.)
     */
    public void setUpScenesAndGoToNumOfPeopleInputScene(ActionEvent event) {
    	setUpMainMenuScene();
    	setUpNumOfPeopleInputScene();
    	setUpMainInputScene();
    	setUpTerminalIllnessInputScene();
    	setUpOutputScene();
    	applicationStage.setScene(numOfPeopleInputScene);
    }

    private Stage applicationStage;
    private int numOfPeople;
    private LifeExpectancy lifeExpectancy = new LifeExpectancy("18", "Male", "Non-smoker", "No", "No", "No", "No", "No", "No", "No", "No", "No", "No");
    
    //ContainerWithinSceneContainer objects
    private ContainerWithinSceneContainerWithChoiceBox howManyPeopleContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "How many people?", 100, "1", "1", "2", "3");
    
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
    
    //TextField and Label objects
    private TextField currentAgeTextField = new TextField();
    private Label currentAgeErrorLabel = new Label("");
    private Label terminalIllnessErrorLabel = new Label("");
    private Label person1OutputMessageLabel = new Label();
    private Label person2OutputMessageLabel = new Label();
    private Label person3OutputMessageLabel = new Label();
    
    //VBox and Scene objects
    private VBox mainMenuSceneContainer = new VBox();
    private Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
    
    private VBox mainInputSceneContainer = new VBox();
    private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
    
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 650, 650);
    
    private VBox outputSceneContainer = new VBox();
    private Scene outputScene = new Scene(outputSceneContainer, 400, 600);
    
    private VBox numOfPeopleInputSceneContainer = new VBox();
    private Scene numOfPeopleInputScene = new Scene(numOfPeopleInputSceneContainer, 400, 400);

    //Objects related to the visual display
	private NumberAxis ageAxis = new NumberAxis();
	private CategoryAxis youVsAverageAxis = new CategoryAxis();
	private XYChart.Series<Number, String> yourData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> avgData = new XYChart.Series<Number, String>();
	private BarGraph visualDisplay = new BarGraph(ageAxis, youVsAverageAxis, "Results", "Age (years)", 90, yourData, avgData);
	
	/** This method records the number of people entered
	 * in the numOfPeopleInputScene and
	 * changes the scene to person1InputScene.
	 * 
	 */
	public void getNumOfPeopleAndGoToPerson1InputScene() {
		numOfPeople = Integer.parseInt(howManyPeopleContainer.getChoiceBox().getValue());
		//applicationStage.setScene(person1InputScene);
	}
	
	/** This method sets up the Person 1 Input Scene.
	 * 
	 */
	/**public void setUpPerson1InputScene() {
		Label person1ErrorMessage = new Label("");
		Label person1Label = new Label("Person 1");
		TextField nameTextField = new TextField();
		ContainerWithinSceneContainer nameContainer = new ContainerWithinSceneContainer(75, 25, "Name:  ", 100);
		nameContainer.getChildren().addAll(nameContainer.getLabel(), nameTextField);
		
		genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
		
	    smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
		
	    Button enterTerminalIllnessButton = new Button("Enter Terminal Illness");
	    enterTerminalIllnessButton.setTranslateX(100);
		enterTerminalIllnessButton.setOnAction(event -> checkForCurrentAgeError(2));
		
	    Button calculateLifeExpectancyButton = new Button("Calculate");
		calculateLifeExpectancyButton.setTranslateX(100);
		calculateLifeExpectancyButton.setTranslateY(60);
		calculateLifeExpectancyButton.setOnAction(event -> checkForCurrentAgeError(1));


		Button donePerson1Button = new Button();
		donePerson1Button.setTranslateX(100);
		donePerson1Button.setTranslateY(60);
		//donePerson1Button.setOnAction(event -> );
		donePerson1Button.setText("Done Person 1");
		if (numOfPeople > 1)
		//	donePerson1Button.setOnAction(checkForCurrentAgeError(1));
		//VBox person1InputSceneContainer = new VBox();
		//person1InputSceneContainer.getChildren().addAll(person1ErrorMessage, person1Label, nameContainer, ..., enterTerminalIllnessButton, donePerson1Button);
		//Scene person1InputScene = new Scene(person1InputSceneContainer, 400, 400);
		}
	
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
	
	/** This method sets up the input scene for the number
	 * of people to calculate life expectancies for.
	 * 
	 */
	public void setUpNumOfPeopleInputScene() {
		Button doneButton = new Button();
		doneButton.setText("Done");
		//doneButton.setOnAction(event -> getNumOfPeopleAndGoToPerson1InputScene);
	 	numOfPeopleInputSceneContainer.getChildren().addAll(howManyPeopleContainer, doneButton);
	}

	
	/** This method creates the Main Input Scene.
	 * 
	 */
	public void setUpMainInputScene() {
		ContainerWithinSceneContainer currentAgeContainer = new ContainerWithinSceneContainer(75, 25, "Current age: ", 100); 
	    currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
		currentAgeContainer.setTranslateX(20);
		
		currentAgeErrorLabel.setTranslateX(20);
		currentAgeErrorLabel.setTranslateY(-20);
		
		genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
		genderContainer.setTranslateX(20);
		genderContainer.setTranslateY(-10);
		
		smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
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
		alzheimersContainer.getChildren().addAll(alzheimersContainer.getLabel(), alzheimersContainer.getChoiceBox());
		alzheimersContainer.setTranslateX(20);
		alzheimersContainer.getChoiceBox().setTranslateX(10);
		
		creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobContainer.getLabel(), creutzfeldtJakobContainer.getChoiceBox());
		creutzfeldtJakobContainer.setTranslateX(20);
		creutzfeldtJakobContainer.getChoiceBox().setTranslateX(10);
		
		crohnsContainer.getChildren().addAll(crohnsContainer.getLabel(), crohnsContainer.getChoiceBox());
		crohnsContainer.setTranslateX(20);
		crohnsContainer.getChoiceBox().setTranslateX(10);
		
		cysticFibrosisContainer.getChildren().addAll(cysticFibrosisContainer.getLabel(), cysticFibrosisContainer.getChoiceBox());
		cysticFibrosisContainer.setTranslateX(20);
		cysticFibrosisContainer.getChoiceBox().setTranslateX(10);
		
		duchenneMDContainer.getChildren().addAll(duchenneMDContainer.getLabel(), duchenneMDContainer.getChoiceBox());	
		duchenneMDContainer.setTranslateX(20);
		duchenneMDContainer.getChoiceBox().setTranslateX(10);
		
		hepBContainer.getChildren().addAll(hepBContainer.getLabel(), hepBContainer.getChoiceBox());
		hepBContainer.setTranslateX(20);
		hepBContainer.getChoiceBox().setTranslateX(10);
		
		heartDiseaseContainer.getChildren().addAll(heartDiseaseContainer.getLabel(), heartDiseaseContainer.getChoiceBox());
		heartDiseaseContainer.setTranslateX(20);
		heartDiseaseContainer.getChoiceBox().setTranslateX(10);
		
		huntingtonsContainer.getChildren().addAll(huntingtonsContainer.getLabel(), huntingtonsContainer.getChoiceBox());
		huntingtonsContainer.setTranslateX(20);
		huntingtonsContainer.getChoiceBox().setTranslateX(10);
		
		multipleSclerosisContainer.getChildren().addAll(multipleSclerosisContainer.getLabel(), multipleSclerosisContainer.getChoiceBox());
		multipleSclerosisContainer.setTranslateX(20);
		multipleSclerosisContainer.getChoiceBox().setTranslateX(10);
		
		rabiesContainer.getChildren().addAll(rabiesContainer.getLabel(), rabiesContainer.getChoiceBox());
		rabiesContainer.setTranslateX(20);
		rabiesContainer.getChoiceBox().setTranslateX(10);
		
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
		} catch(NumberFormatException numberFormatException) {
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
	public void calculate() {
		
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
	    	

		
	}
	
	
	public void goToOutputScene() {
		
		outputMessageLabel.setText("You are expected to live " + lifeExpectancy.calculateLifeExpectancy() + " more years.");
		
		//Setting up a bar graph of the user's results.
		yourData.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeTextField.getText()), ""));
		yourData.setName("Your Age At Death");
		avgData.getData().add(new XYChart.Data<Number, String>(86, ""));
		avgData.setName("Average Age At Death");
		visualDisplay.setBottomData(yourData);
		visualDisplay.setUpperData(avgData);

		applicationStage.setScene(outputScene);
		
		//Re-setting the default "No" values for all terminal illnesses (for the next calculation).
		alzheimersContainer.getChoiceBox().setValue("No");
		creutzfeldtJakobContainer.getChoiceBox().setValue("No");
		crohnsContainer.getChoiceBox().setValue("No");
		cysticFibrosisContainer.getChoiceBox().setValue("No");
		duchenneMDContainer.getChoiceBox().setValue("No");
		heartDiseaseContainer.getChoiceBox().setValue("No");
		hepBContainer.getChoiceBox().setValue("No");
		huntingtonsContainer.getChoiceBox().setValue("No");
		multipleSclerosisContainer.getChoiceBox().setValue("No");
		rabiesContainer.getChoiceBox().setValue("No");
		
	}
    
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}	
    
}