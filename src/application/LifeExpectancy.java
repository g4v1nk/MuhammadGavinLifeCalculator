package application;

	/** This class represents the life expectancy of the program user.
	 * 
	 * @author CS219-user
	 *
	 */
public class LifeExpectancy {
	//Variables related to life expectancy defined here.
	int currentAge;
	String gender;
	String smokingHabits;
    String alzheimers;
    String creutzfeldtJakob;
    String crohns;
    String cysticFibrosis;
    String heartDisease;
    String hepB;
    String huntingtons;
    String multipleSclerosis;
    String duchenneMD;
    String rabies;
	
	//Creating a constructor for life expectancy.
    /** This constructor constructs a LifeExpectancy object with instance variables that keep track of
     * mortality-related information.
     * 
     * @param ageAtPresent (The user's current age; an integer between 18 and 100)
     * @param sex (The user's gender; either "m" or "f")
     * @param smokingStatus (The user's smoking habits: "h"(eavy), "m"(oderate), "l"(ight), or "n"(on-smoker))
     * @param alzheimersStatus (The user's Alzheimer's Disease status: "y"(es) or "n"(o))
     * @param creutzfeldtJakobStatus (The user's Creutzfeldt-Jakob Disease status: "y"(es) or "n"(o))
     * @param crohnsStatus (The user's Crohn's Disease status: "y"(es) or "n"(o))
     * @param cysticFibrosisStatus (The user's Cystic Fibrosis status: "y"(es) or "n"(o))
     * @param heartDiseaseStatus (The user's Heart Disease status: "y"(es) or "n"(o))
     * @param hepBStatus (The user's Hepatitis B status: "y"(es) or "n"(o))
     * @param huntingtonsStatus (The user's Huntington's Disease status: "y"(es) or "n"(o))
     * @param multipleSclerosisStatus (The user's Multiple Sclerosis status: "y"(es) or "n"(o))
     * @param duchenneMDStatus (The user's Duchenne Muscular Dystrophy status: "y"(es) or "n"(o))
     * @param rabiesStatus (The user's Rabies status: "y"(es) or "n"(o))
     */
	LifeExpectancy(int ageAtPresent, String sex, String smokingStatus, String alzheimersStatus,
			String creutzfeldtJakobStatus, String crohnsStatus, String cysticFibrosisStatus, String heartDiseaseStatus,
			String hepBStatus, String huntingtonsStatus, String multipleSclerosisStatus, String duchenneMDStatus, String rabiesStatus) {
		currentAge = ageAtPresent;
		gender = sex;
		smokingHabits = smokingStatus;
		alzheimers = alzheimersStatus;
		creutzfeldtJakob = creutzfeldtJakobStatus;
		crohns = crohnsStatus;
		cysticFibrosis = cysticFibrosisStatus;
		heartDisease = heartDiseaseStatus;
		hepB = hepBStatus;
		huntingtons = huntingtonsStatus;
		multipleSclerosis = multipleSclerosisStatus;
		duchenneMD = duchenneMDStatus;
		rabies = rabiesStatus;
	}
	
	//Creating a method for calculating life expectancy.
	/**
	 * This method calculates your future lifetime in years based on your current age, gender,
	 * smoking habits, and based on any terminal illnesses you have.
	 * 
	 * @return futureLifetime (The life expectancy that the program has calculated.)
	 */
	int getLifeExpectancy() {
		
        //Life expectancy variable initialized to 0.
        int futureLifetime = 0;
		
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
		
        if (smokingHabits.equals("h"))
        	futureLifetime -= 13;
        else if (smokingHabits.equals("m"))
        	futureLifetime -= 9;
        else if (smokingHabits.equals("l"))
        	futureLifetime -= 5;
        else if (smokingHabits.equals("n"))
        	futureLifetime -= 0;
        
        if (futureLifetime < 0)
        	futureLifetime = 0;
        else if (currentAge + futureLifetime > 100)
        	futureLifetime = 100 - currentAge;
        
		return futureLifetime;
	}

}
