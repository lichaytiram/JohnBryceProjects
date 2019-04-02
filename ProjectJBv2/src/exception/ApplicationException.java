package exception;

/**
 * This class create a new Exception that change by name.
 * 
 * @author Lichay
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -1835434097622353495L;

	/**
	 * @param problem   Name of exception that print into the screen
	 * @param throwable Addition exception that print into the screen
	 */
	public ApplicationException(String problem, Throwable throwable) {
		super(problem, throwable);
	}

	/**
	 * @param problem name of exception that print into the screen
	 */
	public ApplicationException(String problem) {
		super(problem);
	}
}
