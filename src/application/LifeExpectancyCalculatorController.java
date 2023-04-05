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
    	setUpSinglePersonOutputScene();
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
    	setUpMultiplePeopleOutputScene();
    	applicationStage.setScene(numOfPeopleInputScene);
    }

    private Stage applicationStage;
    private boolean currentAgeError = false;
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
    
    //TextField, Label, and Button objects
    private TextField person1NameTextField = new TextField();
    private TextField person2NameTextField = new TextField();
    private TextField person3NameTextField = new TextField();
    private TextField currentAgeTextField = new TextField();
    private Label currentAgeErrorLabel = new Label("");
    private Label terminalIllnessErrorLabel = new Label("");
    private Label singlePersonOutputMessageLabel = new Label();
    private Label person1OutputMessageLabel = new Label();
    private Label person2OutputMessageLabel = new Label();
    private Label person3OutputMessageLabel = new Label();
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness");
    
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
	private CategoryAxis yAxis = new CategoryAxis();
	private XYChart.Series<Number, String> yourData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> avgData = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> person1Data = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> person2Data = new XYChart.Series<Number, String>();
	private XYChart.Series<Number, String> person3Data = new XYChart.Series<Number, String>();
	private BarGraph singlePersonVisualDisplay = new BarGraph(ageAxis, yAxis, "Results", "Age (years)", 90, yourData, avgData);
	private BarGraph multiplePeopleVisualDisplayOnePerson = new BarGraph(ageAxis, yAxis, "Results", "Age (years)", 90, person1Data, avgData);
	private BarGraph multiplePeopleVisualDisplayTwoPeople = new BarGraph(ageAxis, yAxis, "Results", "Age (years)", 90, person1Data, person2Data, avgData);
	private BarGraph multiplePeopleVisualDisplayThreePeople = new BarGraph(ageAxis, yAxis, "Results", "Age (years)", 90, person1Data, person2Data, person3Data, avgData);
	
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
	 	
	 	//Set the doneTerminalIllnessButton to change the scene to person1InputScene.
	 	doneTerminalIllnessButton.setOnAction(event -> checkForTerminalIllnessErrors(1));
	
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
		enterTerminalIllnessButton.setOnAction(event -> processEnterTerminalIllnessButtonClick(0));
		
		doneTerminalIllnessButton.setOnAction(event -> checkForTerminalIllnessErrors(0));
		
	    Button calculateLifeExpectancyButton = new Button("Calculate");
		calculateLifeExpectancyButton.setTranslateX(165);
		calculateLifeExpectancyButton.setTranslateY(50);
		calculateLifeExpectancyButton.setOnAction(event -> processCalculateLifeExpectancyButtonClick());
		
		mainInputSceneContainer.getChildren().addAll(currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, calculateLifeExpectancyButton);
		
	}

	
	/** This method sets up the Person 1 Input Scene.
	 * 
	 */
	public void setUpPerson1InputScene() {
		
		Label person1Label = new Label("Person 1");
		
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
		enterTerminalIllnessButton.setOnAction(event -> processEnterTerminalIllnessButtonClick(1));
		
	    Button donePerson1Button = new Button("Done Person 1");
	    donePerson1Button.setTranslateX(165);
	    donePerson1Button.setTranslateY(50);
	    donePerson1Button.setOnAction(event -> processDonePerson1ButtonClick());
		
	    person1InputSceneContainer.getChildren().addAll(person1Label, person1NameContainer, currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, donePerson1Button);
		
	}
	
	/** This method sets up the Person 2 Input Scene.
	 * 
	 */
	public void setUpPerson2InputScene() {
		
		Label person2Label = new Label("Person 2");
		
		ContainerWithinSceneContainer person2NameContainer = new ContainerWithinSceneContainer(75, 25, "Name:  ", 100);
		person2NameContainer.getChildren().addAll(person2NameContainer.getLabel(), person2NameTextField);

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
		enterTerminalIllnessButton.setOnAction(event -> processEnterTerminalIllnessButtonClick(2));
		
	    Button donePerson2Button = new Button("Done Person 2");
	    donePerson2Button.setTranslateX(165);
	    donePerson2Button.setTranslateY(50);
	    donePerson2Button.setOnAction(event -> processDonePerson2ButtonClick());
		
	    person2InputSceneContainer.getChildren().addAll(person2Label, person2NameContainer, currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, donePerson2Button);
		
	}
	
	/** This method sets up the Person 3 Input Scene.
	 * 
	 */
	public void setUpPerson3InputScene() {
		
		Label person3Label = new Label("Person 3");
		
		ContainerWithinSceneContainer person3NameContainer = new ContainerWithinSceneContainer(75, 25, "Name:  ", 100);
		person3NameContainer.getChildren().addAll(person3NameContainer.getLabel(), person3NameTextField);

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
		enterTerminalIllnessButton.setOnAction(event -> processEnterTerminalIllnessButtonClick(3));
		
	    Button donePerson3Button = new Button("Done Person 3");
	    donePerson3Button.setTranslateX(165);
	    donePerson3Button.setTranslateY(50);
	    donePerson3Button.setOnAction(event -> processDonePerson3ButtonClick());
		
	    person3InputSceneContainer.getChildren().addAll(person3Label, person3NameContainer, currentAgeContainer, currentAgeErrorLabel, genderContainer, smokingHabitsContainer,
			enterTerminalIllnessButton, donePerson3Button);
		
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
		
		doneTerminalIllnessButton.setTranslateX(250);
		
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
		
		avgData.getData().add(new XYChart.Data<Number, String>(86, ""));
		avgData.setName("Average Age At Death");
		singlePersonVisualDisplay.setBottomData(yourData);
		singlePersonVisualDisplay.setUpperData(avgData);
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
		
		avgData.getData().add(new XYChart.Data<Number, String>(86, ""));
		avgData.setName("Average Age At Death");
		
		Button newCalculationButton = new Button("New Calculation");
		newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		
	    Button mainMenuButton = new Button("Main Menu");
	    mainMenuButton.setTranslateX(20);
		mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
		
		if (Integer.parseInt(howManyPeopleContainer.getChoiceBox().getValue()) == 1) {
			multiplePeopleOutputSceneContainer.getChildren().addAll(person1OutputMessageLabel, multiplePeopleVisualDisplayOnePerson);
			multiplePeopleVisualDisplayOnePerson.setPerson1Data(person1Data);
			multiplePeopleVisualDisplayOnePerson.setBottomData(avgData);
			multiplePeopleVisualDisplayOnePerson.setTranslateY(40);
		} else if (Integer.parseInt(howManyPeopleContainer.getChoiceBox().getValue()) == 2) {
			multiplePeopleOutputSceneContainer.getChildren().addAll(person2OutputMessageLabel, multiplePeopleVisualDisplayTwoPeople);
			multiplePeopleVisualDisplayTwoPeople.setPerson1Data(person1Data);
			multiplePeopleVisualDisplayTwoPeople.setPerson2Data(person2Data);
			multiplePeopleVisualDisplayTwoPeople.setBottomData(avgData);
			multiplePeopleVisualDisplayTwoPeople.setTranslateY(40);
		} else {
			multiplePeopleOutputSceneContainer.getChildren().addAll(person3OutputMessageLabel, multiplePeopleVisualDisplayThreePeople);
			multiplePeopleVisualDisplayThreePeople.setPerson1Data(person1Data);
			multiplePeopleVisualDisplayThreePeople.setPerson2Data(person2Data);
			multiplePeopleVisualDisplayThreePeople.setPerson3Data(person3Data);
			multiplePeopleVisualDisplayThreePeople.setBottomData(avgData);
			multiplePeopleVisualDisplayThreePeople.setTranslateY(40);
		}
		
		HBox buttonBox = new HBox();
		buttonBox.setTranslateX(100);
		buttonBox.setTranslateY(70);
		buttonBox.getChildren().addAll(newCalculationButton, mainMenuButton);
		multiplePeopleOutputSceneContainer.getChildren().add(buttonBox);
		
	}
	
	/** This method processes the action of clicking the Enter Terminal Illness button.
	 * 
	 * @param currentScene (This is the scene from which the button is pressed.
	 * 0, 1, 2, and 3 correspond to mainInputScene, person1InputScene, person2InputScene, and person3InputScene, respectively.)
	 */
	public void processEnterTerminalIllnessButtonClick(int currentScene) {
		checkForCurrentAgeError(currentScene);
		if (!currentAgeError) {
			//Clear the error message for future "gameplays".
			currentAgeErrorLabel.setText("");
			
			applicationStage.setScene(terminalIllnessInputScene);
		}
	}
	
	/** This method processes the action of clicking the Calculate Life Expectancy button.
	 * 
	 */
	public void processCalculateLifeExpectancyButtonClick() {
		checkForCurrentAgeError(0);
		if (!currentAgeError) {
			//Clear the error message for future "gameplays".
			currentAgeErrorLabel.setText("");
			
			//Update the instance variables of lifeExpectancy based on user input.
			LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
					alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
					cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
					multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue());
			lifeExpectancy = newLifeExpectancy;
			
			singlePersonOutputMessageLabel.setText("You are expected to live " + lifeExpectancy.calculateLifeExpectancy() + " more years.");
			yourData.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeTextField.getText()), ""));
			yourData.setName(person1NameTextField + "Your Age At Death");
			
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
			
			applicationStage.setScene(singlePersonOutputScene);
		}
	}
	
	/** This method processes the action of clicking the Done Person 1 button.
	 * 
	 */
	public void processDonePerson1ButtonClick() {
		checkForCurrentAgeError(1);
		if (!currentAgeError) {
			//Clear the error message for future "gameplays".
			currentAgeErrorLabel.setText("");
			
			//Update the instance variables of lifeExpectancy based on user input.
			LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
					alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
					cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
					multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue());
			lifeExpectancy = newLifeExpectancy;
			
			person1OutputMessageLabel.setText(person1NameTextField + " is expected to live " + lifeExpectancy.calculateLifeExpectancy() + " more years.");
			person1Data.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeTextField.getText()), ""));
			person1Data.setName(person1NameTextField + "'s Age At Death");
			
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
			
			if (Integer.parseInt(howManyPeopleContainer.getChoiceBox().getValue()) > 1) {
				applicationStage.setScene(person2InputScene);
				
				//Set the doneTerminalIllnessButton to change the scene to person2InputScene.
				doneTerminalIllnessButton.setOnAction(event -> checkForTerminalIllnessErrors(2));
			} else applicationStage.setScene(multiplePeopleOutputScene);
		}
	}
	
	/** This method processes the action of clicking the Done Person 2 button.
	 * 
	 */
	public void processDonePerson2ButtonClick() {
		checkForCurrentAgeError(2);
		if (!currentAgeError) {
			//Clear the error message for future "gameplays".
			currentAgeErrorLabel.setText("");
			
			//Update the instance variables of lifeExpectancy based on user input.
			LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
					alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
					cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
					multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue());
			lifeExpectancy = newLifeExpectancy;
			
			person2OutputMessageLabel.setText(person2NameTextField + " is expected to live " + lifeExpectancy.calculateLifeExpectancy() + " more years.");
			person2Data.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeTextField.getText()), ""));
			person2Data.setName(person2NameTextField + "'s Age At Death");
			
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
			
			if (Integer.parseInt(howManyPeopleContainer.getChoiceBox().getValue()) > 2) {
				applicationStage.setScene(person3InputScene);
				
				//Set the doneTerminalIllnessButton to change the scene to person3InputScene.
				doneTerminalIllnessButton.setOnAction(event -> checkForTerminalIllnessErrors(3));
			} else applicationStage.setScene(multiplePeopleOutputScene);
		}
	}
	
	/** This method processes the action of clicking the Done Person 3 button.
	 * 
	 */
	public void processDonePerson3ButtonClick() {
		checkForCurrentAgeError(3);
		if (!currentAgeError) {
			//Clear the error message for future "gameplays".
			currentAgeErrorLabel.setText("");
			
			//Update the instance variables of lifeExpectancy based on user input.
			LifeExpectancy newLifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
					alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
					cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), heartDiseaseContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(),
					multipleSclerosisContainer.getChoiceBox().getValue(), rabiesContainer.getChoiceBox().getValue());
			lifeExpectancy = newLifeExpectancy;
			
			person3OutputMessageLabel.setText(person3NameTextField + " is expected to live " + lifeExpectancy.calculateLifeExpectancy() + " more years.");
			person3Data.getData().add(new XYChart.Data<Number, String>(lifeExpectancy.calculateLifeExpectancy() + Integer.parseInt(currentAgeTextField.getText()), ""));
			person3Data.setName(person3NameTextField + "'s Age At Death");
			
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
			
			applicationStage.setScene(multiplePeopleOutputScene);
		}
	}
	
	/** This method checks for errors in current age input.
	 * If there is an error, then an error message is added to the scene.
	 * 
	 * @param currentScene (This is the scene that is on the stage when this method is called.
	 * 0, 1, 2, and 3 correspond to mainInputScene, person1InputScene, person2InputScene, and person3InputScene, respectively.)
	 */
	public void checkForCurrentAgeError(int currentScene) throws NumberFormatException {
		
		try {
			//Check if the current age entered is less than 18 or more than 100.
			if (Integer.parseInt(currentAgeTextField.getText()) < 18 || Integer.parseInt(currentAgeTextField.getText()) > 100) {
				currentAgeError = true;
				currentAgeErrorLabel.setText("You entered " + currentAgeTextField.getText() + ". Please enter an integer between 18 and 100.");
				currentAgeErrorLabel.setTextFill(Color.RED);
			
				//"Refresh" the scene so that it now has the error message.
				if (currentScene == 0 ) applicationStage.setScene(mainInputScene);
				else if (currentScene == 1) applicationStage.setScene(person1InputScene);
				else if (currentScene == 2) applicationStage.setScene(person2InputScene);
				else applicationStage.setScene(person3InputScene);
			}
		} catch(NumberFormatException numberFormatException) {
			currentAgeErrorLabel.setText("You entered " + currentAgeTextField.getText() + " . Please enter an integer.");
			currentAgeErrorLabel.setTextFill(Color.RED);
			throw numberFormatException;
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