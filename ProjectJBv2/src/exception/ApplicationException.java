package exception;

/**
 * This class create a new exception
 * 
 * @author Lichay
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -1835434097622353495L;

	/**
	 * @param problem   Receive a problem
	 * @param throwable Receive addition exception
	 */
	public ApplicationException(String problem, Throwable throwable) {
		super(problem, throwable);
	}

	/**
	 * @param problem Receive a problem
	 */
	public ApplicationException(String problem) {
		super(problem);
	}
}
