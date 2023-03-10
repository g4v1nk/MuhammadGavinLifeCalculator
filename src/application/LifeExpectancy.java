package application;

import java.util.ArrayList;

/** This class represents the life expectancy of the program user.
 * 
 * @author CS219-user
 *
 */
public class LifeExpectancy {
	
	private int currentAge = 18;
	private String gender = "Male";
	private String smokingHabits = "Non-smoker";
	private String alzheimers = "No";
	private String creutzfeldtJakob = "No";
	private String crohns = "No";
	private String cysticFibrosis = "No";
	private String duchenneMD = "No";
	private String heartDisease = "No";
	private String hepB = "No";
	private String huntingtons = "No";
	private String multipleSclerosis = "No";
	private String rabies = "No";
	
    /** This constructor constructs a LifeExpectancy object with instance variables that keep track of
     * mortality-related information.
     * 
     * @param ageAtPresent (This is the user's current age; an integer between 18 and 100)
     * @param sex (This is the user's gender; either "m" or "f")
     * @param smokingStatus (This is the user's smoking habits: "h"(eavy), "m"(oderate), "l"(ight), or "n"(on-smoker))
     * @param alzheimersStatus (This is the user's Alzheimer's Disease status: "y"(es) or "n"(o))
     * @param creutzfeldtJakobStatus (This is the user's Creutzfeldt-Jakob Disease status: "y"(es) or "n"(o))
     * @param crohnsStatus (This is the user's Crohn's Disease status: "y"(es) or "n"(o))
     * @param cysticFibrosisStatus (This is the user's Cystic Fibrosis status: "y"(es) or "n"(o))
     * @param duchenneMDStatus (This is the user's Duchenne Muscular Dystrophy status: "y"(es) or "n"(o))
     * @param heartDiseaseStatus (This is the user's Heart Disease status: "y"(es) or "n"(o))
     * @param hepBStatus (This is the user's Hepatitis B status: "y"(es) or "n"(o))
     * @param huntingtonsStatus (This is the user's Huntington's Disease status: "y"(es) or "n"(o))
     * @param multipleSclerosisStatus (This is the user's Multiple Sclerosis status: "y"(es) or "n"(o))
     * @param rabiesStatus (This is the user's Rabies status: "y"(es) or "n"(o))
     */
	LifeExpectancy(String ageAtPresent, String sex, String smokingStatus, String alzheimersStatus,
			String creutzfeldtJakobStatus, String crohnsStatus, String cysticFibrosisStatus, String duchenneMDStatus, String heartDiseaseStatus,
			String hepBStatus, String huntingtonsStatus, String multipleSclerosisStatus, String rabiesStatus) {
		
		//To avoid an error, only assign ageAtPresent to currentAge if ageAtPresent is an integer.
		int counter = 0;
		for (char c : ageAtPresent.toCharArray())
			if (!Character.isDigit(c))
				counter += 1;
		if (counter == 0)
			currentAge = Integer.parseInt(ageAtPresent);
		
		gender = sex;
		smokingHabits = smokingStatus;
		alzheimers = alzheimersStatus;
		creutzfeldtJakob = creutzfeldtJakobStatus;
		crohns = crohnsStatus;
		cysticFibrosis = cysticFibrosisStatus;
		duchenneMD = duchenneMDStatus;
		heartDisease = heartDiseaseStatus;
		hepB = hepBStatus;
		huntingtons = huntingtonsStatus;
		multipleSclerosis = multipleSclerosisStatus;
		rabies = rabiesStatus;
		
	}
	
	/**
	 * This method calculates your future lifetime in years based on your current age, gender,
	 * smoking habits, and based on any terminal illnesses you have.
	 * 
	 * @return futureLifetime (This is the life expectancy that the program has calculated.)
	 */
	int getLifeExpectancy() {
		
		//Life expectancy variable initialized to 0.
		int futureLifetime = 0;
		
		if (gender.equals("Male")) {
			if (currentAge <= 19)
				futureLifetime = 65;
			else if (currentAge <= 24)
				futureLifetime = 60;
			else if (currentAge <= 29)
				futureLifetime = 56;
			else if (currentAge <= 34)
				futureLifetime = 51;
			else if (currentAge <= 39)
				futureLifetime = 46;
			else if (currentAge <= 44)
				futureLifetime = 41;
			else if (currentAge <= 49)
				futureLifetime = 37;
			else if (currentAge <= 54)
				futureLifetime = 32;
			else if (currentAge <= 59)
				futureLifetime = 28;
			else if (currentAge <= 64)
				futureLifetime = 23;
			else if (currentAge <= 69)
				futureLifetime = 19;
			else if (currentAge <= 74)
				futureLifetime = 15;
			else if (currentAge <= 79)
				futureLifetime = 12;
			else if (currentAge <= 84)
				futureLifetime = 9;
			else
				futureLifetime = 6;	
		}
		
		else {
			if (currentAge <= 19)
				futureLifetime = 69;
			else if (currentAge <= 24)
				futureLifetime = 64;
			else if (currentAge <= 29)
				futureLifetime = 59;
			else if (currentAge <= 34)
				futureLifetime = 54;
			else if (currentAge <= 39)
				futureLifetime = 49;
			else if (currentAge <= 44)
				futureLifetime = 45;
			else if (currentAge <= 49)
				futureLifetime = 40;
			else if (currentAge <= 54)
				futureLifetime = 35;
			else if (currentAge <= 59)
				futureLifetime = 30;
			else if (currentAge <= 64)
				futureLifetime = 26;
			else if (currentAge <= 69)
				futureLifetime = 22;
			else if (currentAge <= 74)
				futureLifetime = 17;
			else if (currentAge <= 79)
				futureLifetime = 13;
			else if (currentAge <= 84)
				futureLifetime = 10;
			else
				futureLifetime = 7;	
		}
		
        if (alzheimers.equals("Yes"))
        	futureLifetime = (int)((-6.0/25)*currentAge + 24.6);
        else if (creutzfeldtJakob.equals("Yes"))
        	futureLifetime = 1;
        else if (crohns.equals("Yes") && gender.equals("Male"))
        	futureLifetime = 75 - currentAge;
        else if (crohns.equals("Yes") && (!gender.equals("Male")))
        	futureLifetime = 78 - currentAge;
        else if (cysticFibrosis.equals("Yes"))
        	futureLifetime = 44 - currentAge;
        else if (heartDisease.equals("Yes"))
        	futureLifetime *= (1-0.08);
        else if (hepB.equals("Yes"))
        	futureLifetime -= 14;
        else if (huntingtons.equals("Yes"))
        	futureLifetime = 30;
        else if (multipleSclerosis.equals("Yes"))
        	futureLifetime -= 5;
        else if (duchenneMD.equals("Yes"))
        	futureLifetime = 30 - currentAge;
        else if (rabies.equals("Yes"))
        	futureLifetime = 0;
		
        if (smokingHabits.equals("Non-smoker"))
        	futureLifetime -= 0;
        else if (smokingHabits.equals("Light smoker"))
        	futureLifetime -= 5;
        else if (smokingHabits.equals("Moderate smoker"))
        	futureLifetime -= 9;
        else
        	futureLifetime -= 13;
        
        if (futureLifetime < 0)
        	futureLifetime = 0;
        else if (currentAge + futureLifetime > 100)
        	futureLifetime = 100 - currentAge;
        
		return futureLifetime;
		
	}

}