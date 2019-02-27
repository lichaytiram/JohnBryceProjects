package exception;

/**
 * This class create a new Exception that change by name.
 * 
 * @author Lichay
 *
 */
@SuppressWarnings("serial")
public class ExceptionName extends Exception {

	/**
	 * @param s name of exception that print into the screen
	 */
	public ExceptionName(String s) {
		super(s);
	}
}
