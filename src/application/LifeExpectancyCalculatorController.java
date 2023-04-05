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
    	setUpPerson1InputScene();
    	setUpPerson2InputScene();
    	setUpPerson3InputScene();
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
    private Label singlePersonOutputMessageLabel = new Label();
    private Label person1OutputMessageLabel = new Label();
    private Label person2OutputMessageLabel = new Label();
    private Label person3OutputMessageLabel = new Label();
    
    //VBox and Scene objects
    private VBox mainMenuSceneContainer = new VBox();
    private Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
    
    private VBox numOfPeopleInputSceneContainer = new VBox();
    private Scene numOfPeopleInputScene = new Scene(numOfPeopleInputSceneContainer, 400, 400);
    
    private VBox mainInputSceneContainer = new VBox();
    private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
    
    private VBox person1InputSceneContainer = new VBox();
    private Scene person1InputScene = new Scene(person1InputSceneContainer, 400, 400);
    
    private VBox person2InputSceneContainer = new VBox();
    private Scene person2InputScene = new Scene(person2InputSceneContainer, 400, 400);
    
    private VBox person3InputSceneContainer = new VBox();
    private Scene person3InputScene = new Scene(person3InputSceneContainer, 400, 400);
    
    private VBox terminalIllnessInputSceneContainer = new VBox();
    private Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 650, 650);
    
    private VBox singlePersonOutputSceneContainer = new VBox();
    private Scene singlePersonOutputScene = new Scene(singlePersonOutputSceneContainer, 400, 600);
    
    private VBox multiplePeopleOutputSceneContainer = new VBox();
    private Scene multiplePeopleOutputScene = new Scene(multiplePeopleOutputSceneContainer, 400, 600);

    //Objects related to the visual display
	private NumberAxis ageAxis = new NumberAxis();
	private CategoryAxis youVsAverageAxis = new CategoryAxis();
	private XYChart.Series<Number, String> yourData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> avgData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> person1Data = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> person2Data = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> person3Data = new XYChart.Series<Number, String>();
	private BarGraph singlePersonVisualDisplay = new BarGraph(ageAxis, youVsAverageAxis, "Results", "Age (years)", 90, yourData, avgData);
	private BarGraph multiplePeopleVisualDisplay = new BarGraph(ageAxis, youVsAverageAxis, "Results", "Age (years)", 90, person1Data, person2Data, person3Data, avgData);
	
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
	public void setUpPerson1InputScene() {
		Label person1Label = new Label("Person 1");
		
		TextField person1NameTextField = new TextField();
		ContainerWithinSceneContainer person1NameContainer = new ContainerWithinSceneContainer(75, 25, "Name:  ", 100);
		person1NameContainer.getChildren().addAll(person1NameContainer.getLabel(), person1NameTextField);

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
		
	    Button donePerson1Button = new Button("Done Person 1");
	    donePerson1Button.setTranslateX(165);
	    donePerson1Button.setTranslateY(50);
	    donePerson1Button.setOnAction(event -> checkForCurrentAgeError(1));
		
	    person1InputSceneContainer.getChildren().addAll(person1Label, person1NameContainer, currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, donePerson1Button);
		}
	
	/** This method creates the Main Menu Scene.
	 * 
	 */
	public void setUpMainMenuScene() {
		Label title = new Label("Life Expectancy Calculator");
		title.setTranslateX(60);
		title.setTranslateY(80);
		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		
		Button singlePersonButton = new Button("Single Person");
		singlePersonButton.setTranslateX(150);
		singlePersonButton.setTranslateY(150);
		singlePersonButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		
		Button multiplePeopleButton = new Button("Multiple People");
		multiplePeopleButton.setTranslateX(150);
		multiplePeopleButton.setTranslateY(250);
		multiplePeopleButton.setOnAction(event -> applicationStage.setScene(numOfPeopleInputScene));
		
	    mainMenuSceneContainer.getChildren().addAll(title, singlePersonButton);
	}
	
	/** This method sets up the input scene for the number
	 * of people to calculate life expectancies for.
	 * 
	 */
	public void setUpNumOfPeopleInputScene() {
		Button doneButton = new Button();
		doneButton.setText("Done");
		doneButton.setOnAction(event -> applicationStage.setScene(person1InputScene));
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

	
	/** This method sets up the Single Person Output Scene.
	 * 
	 */
	public void setUpSinglePersonOutputScene() {
		singlePersonOutputMessageLabel.setTranslateX(70);
		singlePersonOutputMessageLabel.setTranslateY(20);
		singlePersonOutputMessageLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		singlePersonVisualDisplay.setTranslateY(40);
		
		Button newCalculationButton = new Button("New Calculation");
		newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		
	    Button mainMenuButton = new Button("Main Menu");
	    mainMenuButton.setTranslateX(20);
		mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	    
		HBox buttonBox = new HBox();
		buttonBox.setTranslateX(100);
		buttonBox.setTranslateY(70);
		buttonBox.getChildren().addAll(newCalculationButton, mainMenuButton);
		
		singlePersonOutputSceneContainer.getChildren().addAll(singlePersonOutputMessageLabel, singlePersonVisualDisplay, buttonBox);
	}
	
	/** This method sets up the Multiple People Output Scene.
	 * 
	 */
	public void setUpMultiplePeopleOutputScene() {
		person1OutputMessageLabel.setTranslateX(70);
		person1OutputMessageLabel.setTranslateY(20);
		person1OutputMessageLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		person2OutputMessageLabel.setTranslateX(70);
		person2OutputMessageLabel.setTranslateY(20);
		person2OutputMessageLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		person3OutputMessageLabel.setTranslateX(70);
		person3OutputMessageLabel.setTranslateY(20);
		person3OutputMessageLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		multiplePeopleVisualDisplay.setTranslateY(40);
		
		Button newCalculationButton = new Button("New Calculation");
		newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		
	    Button mainMenuButton = new Button("Main Menu");
	    mainMenuButton.setTranslateX(20);
		mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	    
		HBox buttonBox = new HBox();
		buttonBox.setTranslateX(100);
		buttonBox.setTranslateY(70);
		buttonBox.getChildren().addAll(newCalculationButton, mainMenuButton);
		
		multiplePeopleOutputSceneContainer.getChildren().addAll(person1OutputMessageLabel, person2OutputMessageLabel, person3OutputMessageLabel, multiplePeopleVisualDisplay, buttonBox);
	}
	
	/** This method checks for errors in current age input.
	 * If there is an error, then an error message is added to the scene.
	 * If there are no errors, then, depending on the number specified in the parameter,
	 * either calculateAndGoToOutputScene() will be called, or the scene will be set to terminalIllnessInputScene.
	 * 
	 * @param currentScene (This is the scene that is on the stage when this method is called.
	 * 0, 1, 2, and 3 correspond to mainInputScene, person1InputScene, person2InputScene, and person3InputScene, respectively.)
	 * @param nextScene (This is the scene that you want to be on the stage if there are no current age errors.
	 * 0, 1, 2, and 3 correspond to terminalIllnessInputScene, outputScene, person2InputScene, and person3InputScene, respectively.)
	 */
	public void checkForCurrentAgeError(int currentScene, int nextScene) throws NumberFormatException {
		
		try {
			//Check if the current age entered is less than 18 or more than 100.
			if (Integer.parseInt(currentAgeTextField.getText()) < 18 || Integer.parseInt(currentAgeTextField.getText()) > 100) {
				currentAgeErrorLabel.setText("You entered " + currentAgeTextField.getText() + ". Please enter an integer between 18 and 100.");
				currentAgeErrorLabel.setTextFill(Color.RED);
			
				//"Refresh" the scene so that it now has the error message.
				if (currentScene == 0 ) applicationStage.setScene(mainInputScene);
				else if (currentScene == 1) applicationStage.setScene(person1InputScene);
				else if (currentScene == 2) applicationStage.setScene(person2InputScene);
				else applicationStage.setScene(person3InputScene);
			} else {
				//Clear the error message for future "gameplays".
				currentAgeErrorLabel.setText("");
				if (nextScene == 0) applicationStage.setScene(terminalIllnessInputScene);
				else if (nextScene == 1) calculate(1);
				else if (nextScene == 2) applicationStage.setScene(person2InputScene);
				else applicationStage.setScene(person3InputScene);
			}
		} catch(NumberFormatException numberFormatException) {
			currentAgeErrorLabel.setText("You entered " + currentAgeTextField.getText() + " . Please enter an integer.");
			currentAgeErrorLabel.setTextFill(Color.RED);
		}
				
	}
	
	/** This method checks if more than one terminal illness has been entered, or if Alzheimer's disease has been entered when current age is less than 65.
	 * If one of the above errors is present, an error message is added to terminalIllnessInputScene.
	 * Otherwise, the scene will be set to the previous scene that was displayed.
	 * 
	 * @param sceneToReturnTo (This is an integer from 0 to 3, corresponding
	 * to the input scene that you want the program to return to after
	 * checking for terminal illness errors. 0, 1, 2, and 3 correspond to
	 * mainInputScene, person1InputScene, person2InputScene, and person3InputScene, respectively.)
	 */
	public void checkForTerminalIllnessErrors(int inputSceneToReturnTo) {
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
			if (inputSceneToReturnTo == 0) applicationStage.setScene(mainInputScene);
			else if (inputSceneToReturnTo == 1) applicationStage.setScene(person1InputScene);
			else if (inputSceneToReturnTo == 2) applicationStage.setScene(person2InputScene);
			else applicationStage.setScene(person3InputScene);
		}
	}	
	
    /** This method changes the scene to outputScene, setting outputMessage along the way.
     * 
     */
	public void calculate() {
		
		//Update the instance variables of lifeExpectancy based on user input.
		
		if 
		
		LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
				alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
				cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
				multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue());
		
		lifeExpectancy = newLifeExpectancy;
		
		
	}
	
	public void addDataToBarGraph() {
		
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
    
    /** This method returns applicationStage.
     * 
     * @return applicationStage (This is the stage of the application.)
     */
    public Stage getApplicationStage() {
    	return applicationStage;
    }
    
    /** This method sets numOfPeople according to the parameter.
     * 
     * @param numOfPeopleToSet (This is what you want numOfPeople to be set to.)
     */
    public void setNumOfPeople(int numOfPeopleToSet) {
    	numOfPeople = numOfPeopleToSet;
    }
    
    /** This method returns numOfPeople.
     * 
     * @return numOfPeople (This is the number of people selected if the
     * "Multiple People" option is chosen.)
     */
    public int getNumOfPeople() {
    	return numOfPeople;
    }
    
    /** This method sets lifeExpectancy according to the parameter.
     * 
     * @param lifeExpectancyToSet (This is what you want lifeExpectancy to be set to.)
     */
    public void setLifeExpectancy(LifeExpectancy lifeExpectancyToSet) {
    	lifeExpectancy = lifeExpectancyToSet;
    }
    
    /** This method returns lifeExpectancy.
     * 
     * @return lifeExpectancy (This is the life expectancy of the user of the program.)
     */
    public LifeExpectancy getLifeExpectancy() {
    	return lifeExpectancy;
    }
    
}