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
	private ErrorType internalMessage;
	private String externalMessage;

	// constructor

	/**
	 * Constructor for create a show for this class
	 * 
	 * @param statusCode      Receive a status code
	 * @param internalMessage Receive an internal message
	 * @param externalMessage Receive an external message
	 */
	public ErrorBean(int statusCode, ErrorType internalMessage, String externalMessage) {
		this();
		this.statusCode = statusCode;
		this.internalMessage = internalMessage;
		this.externalMessage = externalMessage;
	}

	/**
	 * Constructor for create a show for this class
	 */
	public ErrorBean() {
		super();
	}

	// getter & setter

	/**
	 * @return This function return a status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode Receive a status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return This function return an internal message
	 */
	public ErrorType getInternalMessage() {
		return internalMessage;
	}

	/**
	 * @param internalMessage Receive an internal message
	 */
	public void setInternalMessage(ErrorType internalMessage) {
		this.internalMessage = internalMessage;
	}

	/**
	 * @return This function return an external message
	 */
	public String getExternalMessage() {
		return externalMessage;
	}

	/**
	 * @param externalMessage Receive an external message
	 */
	public void setExternalMessage(String externalMessage) {
		this.externalMessage = externalMessage;
	}

	@Override
	public String toString() {
		return "ErrorBean [statusCode=" + getStatusCode() + ", internalMessage=" + getInternalMessage()
				+ ", externalMessage=" + getExternalMessage() + "]";
	}

}
