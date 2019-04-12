package coupons.exception;

import coupons.enums.ErrorType;

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

	/**
	 * @param errorType Receive an error type
	 * @param problem   Receive a problem
	 */
	public ApplicationException(ErrorType errorType, String problem, boolean isCritical) {

		super(problem);
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
