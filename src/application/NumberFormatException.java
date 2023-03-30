package application;

/** This class represents a NumberFormatException
 * (a specific Exception that occurs when
 * there is non-numeric current age input in this program).
 * 
 * @author CS219-user
 *
 */
public class NumberFormatException extends Exception {
	
	/** This constructor constructs a NumberFormatException object based on
	 * the message specified in the parameter.
	 * 
	 * @param message (This is the message that will be displayed
	 * when this method is called with a String parameter while
	 * there is a NumberFormatException.)
	 */
	NumberFormatException(String message) {
		super(message);
	}

}
