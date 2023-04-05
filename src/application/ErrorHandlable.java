package application;

/** This interface promises the implementation of
 * checkForCurrentAgeError() and checkForTerminalIllnessErrors().
 * 
 * @author CS219-user
 *
 */
public interface ErrorHandlable {
	/** This method checks for errors in current age input.
	 * 
	 * @param currentScene (This is the current scene where the age input is taken from.)
	 */
	public void checkForCurrentAgeError(int currentScene);
	
	/** This method checks for errors in terminal illness input.
	 * 
	 * @param inputSceneToReturnTo (This is the input scene you want to be able to switch
	 * back and forth between with the Terminal Illness Input Scene.)
	 */
	public void checkForTerminalIllnessErrors(int inputSceneToReturnTo);
}
