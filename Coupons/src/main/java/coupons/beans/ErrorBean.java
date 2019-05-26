package coupons.beans;

import coupons.enums.ErrorType;

/**
 * This class create an error bean
 * 
 * @author Lichay
 *
 */
public class ErrorBean {

	// property

	private int statusCode;
	private ErrorType errorType;
	private String internalMessage;

	// constructor

	public ErrorBean(int statusCode, ErrorType errorType, String internalMessage) {
		this();
		this.statusCode = statusCode;
		this.errorType = errorType;
		this.internalMessage = internalMessage;
	}

	public ErrorBean() {
		super();
	}

	// getter & setter

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatus(int statusCode) {
		this.statusCode = statusCode;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setExternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	@Override
	public String toString() {
		return "ErrorBean [statusCode=" + getStatusCode() + ", errorType=" + getErrorType() + ", internalMessage="
				+ getInternalMessage() + "]";
	}

}
