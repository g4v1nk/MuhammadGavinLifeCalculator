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
	        
	        System.out.print("Enter terminal illness (y or n): ");
	        String terminalIllness = input.nextLine();

	        if (terminalIllness.equals("y")) {
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
	        
	        if (currentAge >= 15 && currentAge <= 19 && gender.equals("m"))
	        	futureLifetime = 65;
	        else if (currentAge >= 20 && currentAge <= 24 && gender.equals("m"))
	        	futureLifetime = 60;
	        else if (currentAge >= 25 && currentAge <= 29 && gender.equals("m"))
	        	futureLifetime = 56;
	        else if (currentAge >= 30 && currentAge <= 24 && gender.equals("m"))
	        	futureLifetime = 51;
	        else if (currentAge >= 35 && currentAge <= 39 && gender.equals("m"))
	        	futureLifetime = 46;
	        else if (currentAge >= 40 && currentAge <= 44 && gender.equals("m"))
	        	futureLifetime = 41;
	        else if (currentAge >= 45 && currentAge <= 49 && gender.equals("m"))
	        	futureLifetime = 37;
	        else if (currentAge >= 50 && currentAge <= 54 && gender.equals("m"))
	        	futureLifetime = 32;
	        else if (currentAge >= 55 && currentAge <= 59 && gender.equals("m"))
	        	futureLifetime = 28;
	        else if (currentAge >= 60 && currentAge <= 64 && gender.equals("m"))
	        	futureLifetime = 23;
	        else if (currentAge >= 65 && currentAge <= 69 && gender.equals("m"))
	        	futureLifetime = 19;
	        else if (currentAge >= 70 && currentAge <= 74 && gender.equals("m"))
	        	futureLifetime = 15;
	        else if (currentAge >= 75 && currentAge <= 79 && gender.equals("m"))
	        	futureLifetime = 12;
	        else if (currentAge >= 80 && currentAge <= 84 && gender.equals("m"))
	        	futureLifetime = 9;
	        else if (currentAge >= 85 && gender.equals("m"))
	        	futureLifetime = 6;	        
	        
	        else if (currentAge >= 15 && currentAge <= 19 && gender.equals("f"))
	        	futureLifetime = 69;
	        else if (currentAge >= 20 && currentAge <= 24 && gender.equals("f"))
	        	futureLifetime = 64;
	        else if (currentAge >= 25 && currentAge <= 29 && gender.equals("f"))
	        	futureLifetime = 59;
	        else if (currentAge >= 30 && currentAge <= 24 && gender.equals("f"))
	        	futureLifetime = 54;
	        else if (currentAge >= 35 && currentAge <= 39 && gender.equals("f"))
	        	futureLifetime = 49;
	        else if (currentAge >= 40 && currentAge <= 44 && gender.equals("f"))
	        	futureLifetime = 45;
	        else if (currentAge >= 45 && currentAge <= 49 && gender.equals("f"))
	        	futureLifetime = 40;
	        else if (currentAge >= 50 && currentAge <= 54 && gender.equals("f"))
	        	futureLifetime = 35;
	        else if (currentAge >= 55 && currentAge <= 59 && gender.equals("f"))
	        	futureLifetime = 30;
	        else if (currentAge >= 60 && currentAge <= 64 && gender.equals("f"))
	        	futureLifetime = 26;
	        else if (currentAge >= 65 && currentAge <= 69 && gender.equals("f"))
	        	futureLifetime = 22;
	        else if (currentAge >= 70 && currentAge <= 74 && gender.equals("f"))
	        	futureLifetime = 17;
	        else if (currentAge >= 75 && currentAge <= 79 && gender.equals("f"))
	        	futureLifetime = 13;
	        else if (currentAge >= 80 && currentAge <= 84 && gender.equals("f"))
	        	futureLifetime = 10;
	        else if (currentAge >= 85 && gender.equals("f"))
	        	futureLifetime = 7;
	        
	        //We are assuming that the user enters at most one terminal illness.
	        if (alzheimers.equals("y"))
	        	futureLifetime = (int)((-6.0/25)*currentAge + 24.6);
	        else if (creutzfeldtJakob.equals("y"))
	        	futureLifetime = 1;
	        else if (crohns.equals("y") && gender.equals("m"))
	        	futureLifetime = 75 - currentAge;
	        else if (crohns.equals("y") && gender.equals("f"))
	        	futureLifetime = 78 - currentAge;
	        else if (cysticFibrosis.equals("y"))
	        	futureLifetime = 44 - currentAge;
	        else if (heartDisease.equals("y"))
	        	futureLifetime *= (1-0.08);
	        else if (hepB.equals("y"))
	        	futureLifetime -= 14;
	        else if (huntingtons.equals("y"))
	        	futureLifetime = 30;
	        else if (multipleSclerosis.equals("y"))
	        	futureLifetime -= 5;
	        else if (duchenneMD.equals("y"))
	        	futureLifetime = 30 - currentAge;
	        else if (rabies.equals("y"))
	        	futureLifetime = 0;
	        
	          System.out.println();
	          System.out.println("Current age: " + currentAge);
	          System.out.println("Future lifetime: " + futureLifetime);
	          System.out.println("Gender: " + gender);
	          System.out.println("Smoking habits: " + smokingHabits);
	          System.out.println("Terminal illness: " + terminalIllness);
	          System.out.println("Alzheimer's Disease: " + alzheimers);
	          System.out.println("Creutzfeldt-Jakob Disease: " + creutzfeldtJakob);
	          System.out.println("Crohn's Disease: " + crohns);
	          System.out.println("Cystic Fibrosis: " + cysticFibrosis);
	          System.out.println("Hepatitis B: " + hepB);
	          System.out.println("Heart Disease: " + heartDisease);
	          System.out.println("Huntington's Disease: " + huntingtons);
	          System.out.println("Multiple Sclerosis: " + multipleSclerosis);
	          System.out.println("Duchenne Muscular Dystrophy: " + duchenneMD);
	          System.out.println("Rabies: " + rabies);
	          System.out.println();
	          System.out.print("Type r to re-start the program: ");
	          programRun = input.nextLine();
	          System.out.println();
	      }
	    }
	  }
	

}
