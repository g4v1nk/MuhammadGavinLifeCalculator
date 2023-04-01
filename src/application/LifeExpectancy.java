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
	public LifeExpectancy(String ageAtPresent, String sex, String smokingStatus, String alzheimersStatus,
			String creutzfeldtJakobStatus, String crohnsStatus, String cysticFibrosisStatus, String duchenneMDStatus, String heartDiseaseStatus,
			String hepBStatus, String huntingtonsStatus, String multipleSclerosisStatus, String rabiesStatus) {
		
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
	 * This method calculates your life expectancy in years based on your current age, gender,
	 * smoking habits, and based on any terminal illnesses you have.
	 * 
	 * @return lifeExpectancy (This is the life expectancy that the program has calculated.)
	 */
	public int calculateLifeExpectancy() {
		
		//Life expectancy variable initialized to 0.
		int lifeExpectancy = 0;
		
		if (gender.equals("Male")) {
			if (currentAge <= 19)
				lifeExpectancy = 65;
			else if (currentAge <= 24)
				lifeExpectancy = 60;
			else if (currentAge <= 29)
				lifeExpectancy = 56;
			else if (currentAge <= 34)
				lifeExpectancy = 51;
			else if (currentAge <= 39)
				lifeExpectancy = 46;
			else if (currentAge <= 44)
				lifeExpectancy = 41;
			else if (currentAge <= 49)
				lifeExpectancy = 37;
			else if (currentAge <= 54)
				lifeExpectancy = 32;
			else if (currentAge <= 59)
				lifeExpectancy = 28;
			else if (currentAge <= 64)
				lifeExpectancy = 23;
			else if (currentAge <= 69)
				lifeExpectancy = 19;
			else if (currentAge <= 74)
				lifeExpectancy = 15;
			else if (currentAge <= 79)
				lifeExpectancy = 12;
			else if (currentAge <= 84)
				lifeExpectancy = 9;
			else
				lifeExpectancy = 6;	
		}
		
		else {
			if (currentAge <= 19)
				lifeExpectancy = 69;
			else if (currentAge <= 24)
				lifeExpectancy = 64;
			else if (currentAge <= 29)
				lifeExpectancy = 59;
			else if (currentAge <= 34)
				lifeExpectancy = 54;
			else if (currentAge <= 39)
				lifeExpectancy = 49;
			else if (currentAge <= 44)
				lifeExpectancy = 45;
			else if (currentAge <= 49)
				lifeExpectancy = 40;
			else if (currentAge <= 54)
				lifeExpectancy = 35;
			else if (currentAge <= 59)
				lifeExpectancy = 30;
			else if (currentAge <= 64)
				lifeExpectancy = 26;
			else if (currentAge <= 69)
				lifeExpectancy = 22;
			else if (currentAge <= 74)
				lifeExpectancy = 17;
			else if (currentAge <= 79)
				lifeExpectancy = 13;
			else if (currentAge <= 84)
				lifeExpectancy = 10;
			else
				lifeExpectancy = 7;	
		}
		
        if (alzheimers.equals("Yes"))
        	lifeExpectancy = (int)((-6.0/25)*currentAge + 24.6);
        else if (creutzfeldtJakob.equals("Yes"))
        	lifeExpectancy = 1;
        else if (crohns.equals("Yes") && gender.equals("Male"))
        	lifeExpectancy = 75 - currentAge;
        else if (crohns.equals("Yes") && (!gender.equals("Male")))
        	lifeExpectancy = 78 - currentAge;
        else if (cysticFibrosis.equals("Yes"))
        	lifeExpectancy = 44 - currentAge;
        else if (heartDisease.equals("Yes"))
        	lifeExpectancy *= (1-0.08);
        else if (hepB.equals("Yes"))
        	lifeExpectancy -= 14;
        else if (huntingtons.equals("Yes"))
        	lifeExpectancy = 30;
        else if (multipleSclerosis.equals("Yes"))
        	lifeExpectancy -= 5;
        else if (duchenneMD.equals("Yes"))
        	lifeExpectancy = 30 - currentAge;
        else if (rabies.equals("Yes"))
        	lifeExpectancy = 0;
		
        if (smokingHabits.equals("Non-smoker"))
        	lifeExpectancy -= 0;
        else if (smokingHabits.equals("Light smoker"))
        	lifeExpectancy -= 5;
        else if (smokingHabits.equals("Moderate smoker"))
        	lifeExpectancy -= 9;
        else
        	lifeExpectancy -= 13;
        
        if (lifeExpectancy < 0)
        	lifeExpectancy = 0;
        else if (currentAge + lifeExpectancy > 100)
        	lifeExpectancy = 100 - currentAge;
        
		return lifeExpectancy;
		
	}
	/**
	
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.
	 * currentAge should be an integer between 18 and 100.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
		//currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets gender according to the parameter.
	 * 
	 * @param genderToSet (This is what you want gender to be set to.
	 * gender should be either "Male" or "Female".)
	 */
	//public void setGender(String genderToSet) {
	//	gender = genderToSet;
	//}
	
	/** This method returns gender.
	 * 
	 * @return gender (This is the gender of the user of this program.)
	 */
	//public String getGender() {
	//	return gender;
	//}
	
	/** This method sets smokingHabits according to the parameter.
	 * 
	 * @param smokingHabitsToSet (This is what you want smokingHabits to be set to.)
	 */
	//public void setSmokingHabits(String smokingHabitsToSet) {
	//	smokingHabits = smokingHabitsToSet;
	//}
	
	/** This method returns smokingHabits.
	 * 
	 * @return smokingHabits (This is the smoking habits of the user of this program.)
	 */
	//public String getSmokingHabits() {
	//	return smokingHabits;
	//}
	
	/** This method sets alzheimers according to the parameter.
	 * 
	 * @param alzheimersToSet (This is what you want alzheimers to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
		//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.)
	 */
	//public void setCurrentAge(int currentAgeToSet) {
	//	currentAge = currentAgeToSet;
	//}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	//public int getCurrentAge() {
	//	return currentAge;
	//}

}