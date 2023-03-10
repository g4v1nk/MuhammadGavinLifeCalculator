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
    private ContainerWithinSceneContainer currentAgeContainer = new ContainerWithinSceneContainer(75, 25, "Current age: ", 100); {
    	currentAgeContainer.getChildren().addAll(currentAgeContainer.getLabel(), currentAgeTextField);
    }
    private ContainerWithinSceneContainerWithChoiceBox genderContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Gender: ", 100, "Male", "Male", "Female", null, null); {
    	genderContainer.getChildren().addAll(genderContainer.getLabel(), genderContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox smokingHabitsContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Smoking habits: ", 100,
			"Non-smoker", "Non-smoker", "Light smoker", "Moderate smoker", "Heavy smoker"); {
		smokingHabitsContainer.getChildren().addAll(smokingHabitsContainer.getLabel(), smokingHabitsContainer.getChoiceBox());
	}
    private ContainerWithinSceneContainerWithChoiceBox alzheimersContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 25, "Alzheimer's Disease: ", 100, "No", "No", "Yes", null, null); {
    	alzheimersContainer.getChildren().addAll(alzheimersContainer.getLabel(), alzheimersContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox creutzfeldtJakobContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Creutzfeldt-Jakob Disease: ", 100, "No", "No", "Yes", null, null); {
    	creutzfeldtJakobContainer.getChildren().addAll(creutzfeldtJakobContainer.getLabel(), creutzfeldtJakobContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox crohnsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Crohn's Disease: ", 100, "No", "No", "Yes", null, null); {
    	crohnsContainer.getChildren().addAll(crohnsContainer.getLabel(), crohnsContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox cysticFibrosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Cystic Fibrosis: ", 100, "No", "No", "Yes", null, null); {
    	cysticFibrosisContainer.getChildren().addAll(cysticFibrosisContainer.getLabel(), cysticFibrosisContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox duchenneMDContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Duchenne Muscular Dystrophy: ", 100, "No", "No", "Yes", null, null); {
    	duchenneMDContainer.getChildren().addAll(duchenneMDContainer.getLabel(), duchenneMDContainer.getChoiceBox());	
    }
    private ContainerWithinSceneContainerWithChoiceBox hepBContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Hepatitis B: ", 100, "No", "No", "Yes", null, null); {
    	hepBContainer.getChildren().addAll(hepBContainer.getLabel(), hepBContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox heartDiseaseContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Heart Disease: ", 100, "No", "No", "Yes", null, null); {
    	heartDiseaseContainer.getChildren().addAll(heartDiseaseContainer.getLabel(), heartDiseaseContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox huntingtonsContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Huntington's Disease: ", 100, "No", "No", "Yes", null, null); {
    	huntingtonsContainer.getChildren().addAll(huntingtonsContainer.getLabel(), huntingtonsContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox multipleSclerosisContainer = new ContainerWithinSceneContainerWithChoiceBox(50, 0, "Multiple Sclerosis: ", 100, "No", "No", "Yes", null, null); {
    	multipleSclerosisContainer.getChildren().addAll(multipleSclerosisContainer.getLabel(), multipleSclerosisContainer.getChoiceBox());
    }
    private ContainerWithinSceneContainerWithChoiceBox rabiesContainer = new ContainerWithinSceneContainerWithChoiceBox(75, 0, "Rabies: ", 100, "No", "No", "Yes", null, null); {
    	rabiesContainer.getChildren().addAll(rabiesContainer.getLabel(), rabiesContainer.getChoiceBox());
    }
    
    //Declaring variables that reference objects that will be added to scene containers.
    private Label errorMessage = new Label("Error message");
    private Button startCalculationButton = new Button("Start Calculation");
    private Button enterTerminalIllnessButton = new Button("Enter Terminal Illness"); {
    	enterTerminalIllnessButton.setTranslateX(100);
	}
    private Button calculateLifeExpectancyButton = new Button("Calculate Life Expectancy"); {
    	calculateLifeExpectancyButton.setTranslateX(100);
    	calculateLifeExpectancyButton.setTranslateY(25);
    }
    private Button doneTerminalIllnessButton = new Button("Done Terminal Illness"); {
    	doneTerminalIllnessButton.setTranslateX(100);
    }
    private Button newCalculationButton = new Button("New Calculation"); {
    	newCalculationButton.setTranslateX(100);
    	newCalculationButton.setTranslateX(100);
    }
    private Button mainMenuButton = new Button("Main Menu"); {
    	mainMenuButton.setTranslateX(100);
    }
	
	//Checking for errors in current age entered.
    private boolean validCurrentAge = true; {
	for (char c : currentAgeTextField.getText().toCharArray())  {
		if (!Character.isDigit(c))
			validCurrentAge = false;
	}
	if (Integer.parseInt(currentAgeTextField.getText()) < 18)
		validCurrentAge = false;	
    }
    
    //Checking for errors in number of terminal illnesses entered.
  	private boolean validTerminalIllnessNumber = true;
  	private ArrayList<String> yesOrNoList = new ArrayList<String>(); {
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
      		validTerminalIllnessNumber = false;
      }
    
    //Calculating the user's life expectancy (but only if all user input is valid).
	{if (validCurrentAge && validTerminalIllnessNumber)
		private LifeExpectancy lifeExpectancy = new LifeExpectancy(currentAgeTextField.getText(), genderContainer.getChoiceBox().getValue(), smokingHabitsContainer.getChoiceBox().getValue(),
		alzheimersContainer.getChoiceBox().getValue(), creutzfeldtJakobContainer.getChoiceBox().getValue(), crohnsContainer.getChoiceBox().getValue(),
		cysticFibrosisContainer.getChoiceBox().getValue(), duchenneMDContainer.getChoiceBox().getValue(), hepBContainer.getChoiceBox().getValue(),
		heartDiseaseContainer.getChoiceBox().getValue(), huntingtonsContainer.getChoiceBox().getValue(), multipleSclerosisContainer.getChoiceBox().getValue(),
		rabiesContainer.getChoiceBox().getValue());
	
	//Only invoke getLifeExpectancy() on lifeExpectancy if the parameters passed to the LifeExpectancy constructor survived error handling.
	if (!lifeExpectancy.currentAge == Integer.parseInt(currentAgeTextField.getText()))
		//Error message
	if (!lifeExpectancy.alzheimersStatus == alzheimersContainer.getChoiceBox().getValue())
		//Error message
	else
		private int yearsLeftToLive = lifeExpectancy.getLifeExpectancy();
    
    /* Need to define messageContainer separately from the other variables that reference containers that will be added to scene containers,
    because messageContainer is constructed based on the variable yearsLeftToLive, which is not declared until just above here. */
    private ContainerWithinSceneContainer messageContainer = new ContainerWithinSceneContainer(50, 0, "Your Life Expectancy is " + yearsLeftToLive + " more years", 100); {
    	messageContainer.getChildren().addAll(messageContainer.getLabel());
    }
    
    //Declaring variables that reference scene containers.
    private VBox mainMenuSceneContainer = new VBox(); {
    	mainMenuSceneContainer.getChildren().add(startCalculationButton);
    }
    private VBox mainInputSceneContainer = new VBox(); {
		mainInputSceneContainer.getChildren().addAll(currentAgeContainer, genderContainer, smokingHabitsContainer,
		enterTerminalIllnessButton, calculateLifeExpectancyButton);
    }
    private VBox terminalIllnessInputSceneContainer = new VBox(); { 
		terminalIllnessInputSceneContainer.getChildren().addAll(alzheimersContainer, creutzfeldtJakobContainer,
		crohnsContainer, cysticFibrosisContainer, duchenneMDContainer, hepBContainer, heartDiseaseContainer,
		huntingtonsContainer, multipleSclerosisContainer, rabiesContainer, doneTerminalIllnessButton);
	}
    private VBox outputSceneContainer = new VBox(); {
		outputSceneContainer.getChildren().addAll(messageContainer, newCalculationButton, mainMenuButton);
	}
    
    //Declaring variables that reference scenes.
    /* Note: The Main Menu Scene is also created in the Main class, but it needs to be re-created here since the Main Menu Scene is referenced in this class
    (outside the scope of where the Main Menu Scene is created in the Main class.) */
    private Scene mainMenuScene = new Scene(mainMenuSceneContainer, 400, 400);
	private Scene mainInputScene = new Scene(mainInputSceneContainer, 400, 400);
	private Scene terminalIllnessInputScene = new Scene(terminalIllnessInputSceneContainer, 400, 400);
	private Scene outputScene = new Scene(outputSceneContainer, 400, 400);
	
	//Setting the "onAction"s for each button.
	{
		enterTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(terminalIllnessInputScene));
		if (validCurrentAge == false) {
			calculateLifeExpectancyButton.setOnAction(event -> mainInputSceneContainer.getChildren().add(errorMessage));
			applicationStage.setScene(mainInputScene);
		}
		else
			calculateLifeExpectancyButton.setOnAction(event -> applicationStage.setScene(outputScene));
		if (validTerminalIllnessNumber == false) {
			doneTerminalIllnessButton.setOnAction(event -> mainInputSceneContainer.getChildren().add(errorMessage));
			applicationStage.setScene(terminalIllnessInputScene);
		}
		else	
			doneTerminalIllnessButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		newCalculationButton.setOnAction(event -> applicationStage.setScene(mainInputScene));
		mainMenuButton.setOnAction(event -> applicationStage.setScene(mainMenuScene));
	}
    
	/** This method sets the variable applicationStage to the parameter passed in.
	 * 
	 * @param stage (This is what you want to be assigned to applicationStage.)
	 */
    public void setApplicationStage(Stage stage) {
		applicationStage = stage;
	}

}