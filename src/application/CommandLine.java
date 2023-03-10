package application;
import java.util.Scanner;

/** This class represents the command line input that the user enters.
 * 
 * @author CS219-user
 *
 */
public class CommandLine {

	/** This method prompts the user for input,
	 * calls the getLifeExpectancy() method to calculate life expectancy based on user input,
	 * and then displays the user's life expectancy and asks the user if they want to
	 * re-start the program.
	 * 
	 * @param args
	 */
	  public static void main(String[] args) {
	    String programRun = "r";
	    Scanner input = new Scanner(System.in);

	    while (programRun.equals("r")) {
	      System.out.print("Type y to start calculation: ");
	      String startCalculation = input.nextLine();

	      if (startCalculation.equals("y")) {
	        System.out.print("Enter current age: ");
	        int currentAge = input.nextInt();

	        input.nextLine(); // Clears the buffer for the next input

	        System.out.print("Enter gender (m or f): ");
	        String gender = input.nextLine();

	        System.out.print("Enter smoking habits (h(eavy), m(oderate), l(ight), or n(on-smoker)): ");
	        String smokingHabits = input.nextLine();
	        
	        System.out.print("Enter terminal illness (y or n): ");
	        String terminalIllness = input.nextLine();

	        //Terminal illness variables initialized to "n".
	        String alzheimers = "n";
	        String creutzfeldtJakob = "n";
	        String crohns = "n";
	        String cysticFibrosis = "n";
	        String heartDisease = "n";
	        String hepB = "n";
	        String huntingtons = "n";
	        String multipleSclerosis = "n";
	        String duchenneMD = "n";
	        String rabies = "n";
	        
	        if (terminalIllness.equals("y")) {
	        	//Only ask if the user has Alzheimer's Disease if the user is at least age 65.
	        	if (currentAge >= 65) {
	  	          System.out.print("Alzheimer's Disease (y or n): ");
		          alzheimers = input.nextLine();	
	        	}
	          
	          System.out.print("Creutzfeldt-Jakob Disease (y or n): ");
	          creutzfeldtJakob = input.nextLine();
	          
	          System.out.print("Crohn's Disease (y or n): ");
	          crohns = input.nextLine();
	          
	          System.out.print("Cystic Fibrosis (y or n): ");
	          cysticFibrosis = input.nextLine();

	          System.out.print("Heart Disease (y or n): ");
	          heartDisease = input.nextLine();
	          
	          System.out.print("Hepatitis B (y or n): ");
	          hepB = input.nextLine();
	          
	          System.out.print("Huntington's Disease (y or n): ");
	          huntingtons = input.nextLine();
	          
	          System.out.print("Multiple Sclerosis (y or n): ");
	          multipleSclerosis = input.nextLine();
	          
	          System.out.print("Duchenne Muscular Dystrophy (y or n): ");
	          duchenneMD = input.nextLine();
	          
	          System.out.print("Rabies (y or n): ");
	          rabies = input.nextLine();
	        }
	        
	        //LifeExpectancy lifeExpectancy = new LifeExpectancy(currentAge, gender, smokingHabits, alzheimers,
//creutzfeldtJakob, crohns, cysticFibrosis, heartDisease, hepB, huntingtons, multipleSclerosis, duchenneMD, rabies);	
	        
	        //int yearsLeftToLive = lifeExpectancy.getLifeExpectancy();
	        
	        System.out.println();
	        //System.out.println("You are expected to live " + yearsLeftToLive + " more years.");
	   
	        System.out.println();
	        System.out.print("Type r to re-start the program: ");
	        programRun = input.nextLine();
	        System.out.println();
	      }
	    }
	  }
	

}
