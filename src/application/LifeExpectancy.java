package application;

/** This class represents the life expectancy of the program user.
 * 
 * @author CS219-user
 *
 */
public class LifeExpectancy {
	
	private int currentAge = 18;
	private String gender = "Male";
	private String smokingHabits = "Non-smoker";
	private boolean alzheimers = false;
	private boolean creutzfeldtJakob = false;
	private boolean crohns = false;
	private boolean cysticFibrosis = false;
	private boolean duchenneMD = false;
	private boolean heartDisease = false;
	private boolean hepB = false;
	private boolean huntingtons = false;
	private boolean multipleSclerosis = false;
	private boolean rabies = false;
	
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
		alzheimers = strToBool(alzheimersStatus);
		creutzfeldtJakob = strToBool(creutzfeldtJakobStatus);
		crohns = strToBool(crohnsStatus);
		cysticFibrosis = strToBool(cysticFibrosisStatus);
		duchenneMD = strToBool(duchenneMDStatus);
		heartDisease = strToBool(heartDiseaseStatus);
		hepB = strToBool(hepBStatus);
		huntingtons = strToBool(huntingtonsStatus);
		multipleSclerosis = strToBool(multipleSclerosisStatus);
		rabies = strToBool(rabiesStatus);
		
	}
	
	/** This method converts the parameter from String to boolean.
	 * 
	 * @param str (This is what you want to convert to a boolean type.
	 * This should be either "Yes", or "No".)
	 * @return true (or @return false) (Either true or false is returned, depending on the parameter.)
	 */
	public boolean strToBool (String str) {
		if (str == "Yes")
			return true;
		else
			return false;
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
		
        if (alzheimers)
        	lifeExpectancy = (int)((-6.0/25)*currentAge + 24.6);
        else if (creutzfeldtJakob)
        	lifeExpectancy = 1;
        else if (crohns && gender.equals("Male"))
        	lifeExpectancy = 75 - currentAge;
        else if (crohns && (!gender.equals("Male")))
        	lifeExpectancy = 78 - currentAge;
        else if (cysticFibrosis)
        	lifeExpectancy = 44 - currentAge;
        else if (heartDisease)
        	lifeExpectancy *= (1-0.08);
        else if (hepB)
        	lifeExpectancy -= 14;
        else if (huntingtons)
        	lifeExpectancy = 30;
        else if (multipleSclerosis)
        	lifeExpectancy -= 5;
        else if (duchenneMD)
        	lifeExpectancy = 30 - currentAge;
        else if (rabies)
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
	
	/** This method sets currentAge according to the parameter.
	 * 
	 * @param currentAgeToSet (This is what you want currentAge to be set to.
	 * currentAge should be an integer between 18 and 100.)
	 */
	public void setCurrentAge(int currentAgeToSet) {
		currentAge = currentAgeToSet;
	}
	
	/** This method returns currentAge.
	 * 
	 * @return currentAge (This is the current age of the user of this program.)
	 */
	public int getCurrentAge() {
		return currentAge;
	}
	
	/** This method sets gender according to the parameter.
	 * 
	 * @param genderToSet (This is what you want gender to be set to.
	 * gender should be either "Male" or "Female".)
	 */
	public void setGender(String genderToSet) {
		gender = genderToSet;
	}
	
	/** This method returns gender.
	 * 
	 * @return gender (This is the gender of the user of this program.)
	 */
	public String getGender() {
		return gender;
	}
	
	/** This method sets smokingHabits according to the parameter.
	 * 
	 * @param smokingHabitsToSet (This is what you want smokingHabits to be set to.)
	 */
	public void setSmokingHabits(String smokingHabitsToSet) {
		smokingHabits = smokingHabitsToSet;
	}
	
	/** This method returns smokingHabits.
	 * 
	 * @return smokingHabits (This is the smoking habits of the user of this program.)
	 */
	public String getSmokingHabits() {
		return smokingHabits;
	}
	
	/** This method sets alzheimers according to the parameter.
	 * 
	 * @param alzheimersStatus (This is what you want alzheimers to be set to
	 * (either true or false).)
	 */
	public void setAlzheimers (boolean alzheimersStatus) {
		alzheimers = alzheimersStatus;
	}
	
	/** This method returns alzheimers.
	 * 
	 * @return alzheimers (This is the Alzheimer's Disease status of the user of this program
	 * (either true or false).)
	 */
	public boolean getAlzheimers() {
		return alzheimers;
	}
	
	/** This method sets creutzfeldtJakob according to the parameter.
	 * 
	 * @param creutzfeldtJakobStatus (This is what you want creutzfeldtJakob to be set to
	 * (either true or false).)
	 */
	public void setCreutzfeldtJakob (boolean creutzfeldtJakobStatus) {
		creutzfeldtJakob = creutzfeldtJakobStatus;
	}
	
	/** This method returns creutzfeldtJakob.
	 * 
	 * @return creutzfeldtJakob (This is the Creutzfeldt-Jakob Disease status of the user of this program
	 * (either true or false).)
	 */
	public boolean getCreutzfeldtJakob() {
		return creutzfeldtJakob;
	}
	
	/** This method sets crohns according to the parameter.
	 * 
	 * @param crohnsStatus (This is what you want crohns to be set to
	 * (either true or false).)
	 */
	public void setCrohns (boolean crohnsStatus) {
		crohns = crohnsStatus;
	}
	
	/** This method returns crohns.
	 * 
	 * @return crohns (This is the Crohn's Disease status of the user of this program
	 * (either true or false).)
	 */
	public boolean getCrohns() {
		return crohns;
	}
	
	/** This method sets cysticFibrosis according to the parameter.
	 * 
	 * @param cysticFibrosisStatus (This is what you want cysticFibrosis to be set to
	 * (either true or false).)
	 */
	public void setCysticFibrosis (boolean cysticFibrosisStatus) {
		cysticFibrosis = cysticFibrosisStatus;
	}
	
	/** This method returns cysticFibrosis.
	 * 
	 * @return cysticFibrosis (This is the Cystic Fibrosis status of the user of this program
	 * (either true or false).)
	 */
	public boolean getCysticFibrosis() {
		return cysticFibrosis;
	}
	
	/** This method sets duchenneMD according to the parameter.
	 * 
	 * @param duchenneMDStatus (This is what you want duchenneMD to be set to
	 * (either true or false).)
	 */
	public void setDuchenneMD (boolean duchenneMDStatus) {
		duchenneMD = duchenneMDStatus;
	}
	
	/** This method returns duchenneMD.
	 * 
	 * @return duchenneMD (This is the Duchenne Muscular Dystrophy status of the user of this program
	 * (either true or false).)
	 */
	public boolean getDuchenneMD() {
		return duchenneMD;
	}
	
	/** This method sets heartDisease according to the parameter.
	 * 
	 * @param heartDiseaseStatus (This is what you want heartDisease to be set to
	 * (either true or false).)
	 */
	public void setHeartDisease (boolean heartDiseaseStatus) {
		heartDisease = heartDiseaseStatus;
	}
	
	/** This method returns heartDisease.
	 * 
	 * @return heartDisease (This is the Heart Disease status of the user of this program
	 * (either true or false).)
	 */
	public boolean getHeartDisease() {
		return heartDisease;
	}
	
	/** This method sets hepB according to the parameter.
	 * 
	 * @param hepBStatus (This is what you want hepB to be set to
	 * (either true or false).)
	 */
	public void setHepB (boolean hepBStatus) {
		hepB = hepBStatus;
	}
	
	/** This method returns hepB.
	 * 
	 * @return hepB (This is the Hepatitis B status of the user of this program
	 * (either true or false).)
	 */
	public boolean getHepB() {
		return hepB;
	}
	
	/** This method sets huntingtons according to the parameter.
	 * 
	 * @param huntingtonsStatus (This is what you want huntingtons to be set to
	 * (either true or false).)
	 */
	public void setHuntingtons (boolean huntingtonsStatus) {
		huntingtons = huntingtonsStatus;
	}
	
	/** This method returns huntingtons.
	 * 
	 * @return huntingtons (This is the Huntington's Disease status of the user of this program
	 * (either true or false).)
	 */
	public boolean getHuntingtons() {
		return huntingtons;
	}
	
	/** This method sets multipleSclerosis according to the parameter.
	 * 
	 * @param multipleSclerosisStatus (This is what you want multipleSclerosis to be set to
	 * (either true or false).)
	 */
	public void setMultipleSclerosis (boolean multipleSclerosisStatus) {
		multipleSclerosis = multipleSclerosisStatus;
	}
	
	/** This method returns multipleSclerosis.
	 * 
	 * @return multipleSclerosis (This is the Multiple Sclerosis status of the user of this program
	 * (either true or false).)
	 */
	public boolean getMultipleSclerosis() {
		return multipleSclerosis;
	}
	
	/** This method sets rabies according to the parameter.
	 * 
	 * @param rabiesStatus (This is what you want rabies to be set to
	 * (either true or false).)
	 */
	public void setRabies (boolean rabiesStatus) {
		rabies = rabiesStatus;
	}
	
	/** This method returns rabies.
	 * 
	 * @return rabies (This is the Rabies status of the user of this program
	 * (either true or false).)
	 */
	public boolean getRabies() {
		return rabies;
	}
	
}