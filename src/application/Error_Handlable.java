package application;

/** This interface promises the implementation of
 * checkForCurrentAgeError() and checkForTerminalIllnessErrors().
 * 
 * @author CS219-user
 *
 */
public interface Error_Handlable {
	public void checkForCurrentAgeError();
	public void checkForTerminalIllnessErrors();
}
