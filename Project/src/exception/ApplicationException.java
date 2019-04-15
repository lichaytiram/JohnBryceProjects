package exception;

import enums.ErrorType;

/**
 * This class create a new exception
 * 
 * @author Lichay
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -1835434097622353495L;

	private ErrorType errorType;
	private boolean isCritical;

	// constructor

	/**
	 * @param errorType  Receive an error type
	 * @param message    Receive a message
	 * @param isCritical Receive is critical
	 * @param throwable  Receive a throwable
	 */
	public ApplicationException(ErrorType errorType, String message, boolean isCritical, Throwable throwable) {

		super(message, throwable);
		this.errorType = errorType;
		this.isCritical = isCritical;

	}

	/**
	 * @param errorType  Receive an error type
	 * @param message    Receive a message
	 * @param isCritical Receive is critical
	 */
	public ApplicationException(ErrorType errorType, String message, boolean isCritical) {

		super(message);
		this.errorType = errorType;
		this.isCritical = isCritical;

	}

	// getter

	/**
	 * @return This function return the error type
	 */
	public ErrorType getErrorType() {

		return errorType;

	}

	/**
	 * @return This function return true if critical
	 */
	public boolean getIsCritical() {

		return isCritical;

	}

}
