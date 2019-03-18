package exception;

/**
 * This class create a new Exception that change by name.
 * 
 * @author Lichay
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/**
	 * @param s name of exception that print into the screen
	 */
	public ApplicationException(String s) {
		super(s);
	}
}
