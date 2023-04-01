package application;

/** This class represents a NumberFormatException
 * (a specific Exception that occurs when
 * there is non-numeric current age input in this program).
 * 
 * @author CS219-user
 *
 */
public class NumberFormatException extends Exception {
	
	/** This constructor constructs a NumberFormatException object.
	 * 
	 */
	public NumberFormatException() {}
	
	/** This constructor constructs a NumberFormatException object based on
	 * the message specified in the parameter.
	 * 
	 * @param message (This is the message that will be displayed
	 * when this method is called with a String parameter while
	 * there is a NumberFormatException.)
	 */
	public NumberFormatException(String message) {
		super(message);
	}
	
	/** This constructor constructs a NumberFormatException object
	 * based on the cause specified in the parameter.
	 * 
	 * @param cause (This is the reason for the NumberFormatException.)
	 */
	public NumberFormatException(Throwable cause) {
		super(cause);
	}
	
	/** This constructor constructs an object of type NumberFormatException
	 * based on the message and cause specified in the parameters.
	 * 
	 * @param message (This is the message that will be displayed
	 * when this method is called with a String parameter while
	 * there is a NumberFormatException.)
	 * @param cause (This is the reason for the NumberFormatException.)
	 */
	public NumberFormatException(String message, Throwable cause) {
		super(message, cause);
	}

}
