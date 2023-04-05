package application;

/** This interface represents an error-handlable object.
 * 
 * @author CS219-user
 *
 */
public interface ErrorHandlable {
	
	/** This method checks for errors in current age input, then sets the scene
	 * according to the parameter.
	 * 
	 * @param SceneChoice (This is the scene you want the stage to be set to
	 * once errors are checked for.
	 * 1 corresponds to Output Scene; any other number corresponds to Terminal Illness Input Scene.)
	 */
	public void checkForCurrentAgeError(int SceneChoice);
	
	/** This method checks for errors in terminal illness input.
	 * 
	 */
	public void checkForTerminalIllnessErrors();

}
