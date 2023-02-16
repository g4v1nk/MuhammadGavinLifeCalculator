package application;
import java.util.Scanner;
public class CommandLine {

	  public static void main(String[] args) {
	    String programRun = "r";
	    Scanner input = new Scanner(System.in);

	    while (programRun.equals("r")) {
	      System.out.print("Type y to start calculation: ");
	      String startCalculation = input.nextLine();

	      if (startCalculation.equals("y")) {
	        System.out.print("Enter current age: ");
	        int currentAge = input.nextInt();

	        int futureLifetime = 0;

	        input.nextLine(); // Clears the buffer for the next input

	        System.out.print("Enter gender (m or f): ");
	        String gender = input.nextLine();

	        System.out.print("Enter smoking habits (h(eavy), m(oderate), l(ight), or n(on-smoker)): ");
	        String smokingHabits = input.nextLine();

	        int smokerStatus = 0;
	        if (smokingHabits.equals("h")) {
	          smokerStatus = 3;
	        } else if (smokingHabits.equals("m")) {
	          smokerStatus = 2;
	        } else if (smokingHabits.equals("l")) {
	          smokerStatus = 1;
	        } else if (smokingHabits.equals("n")) {
	          smokerStatus = 0;
	        }

	        System.out.print("Enter terminal illness (y or n): ");
	        String terminalIllness = input.nextLine();

	        if (terminalIllness.equals("y")) {
	          System.out.print("Alzheimer's disease (y or n): ");
	          String alzheimers = input.nextLine();

	          System.out.print("Cancer (y or n): ");
	          String cancer = input.nextLine();

	          if (cancer.equals("y")) {
	            System.out.print("Bladder cancer (y or n): ");
	            String bladderCancer = input.nextLine();
	            // Repeat with other cancers
	          }
	          // Prompt the user for the rest of the terminal illnesses
	        }
	      }
	    }
	  }
	

}
