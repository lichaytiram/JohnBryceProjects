package coupons.enums;

/**
 * This enum create an error by names
 * 
 * @author Lichay
 *
 */
public enum ErrorType {
	
	GENERAL_ERROR("General error."),
	PROBLEM("Have a problem:\n"),
	COMPANY_IS_ALREADY_EXISTS("The company you chose is already exist."),
	COMPANY_IS_NOT_EXISTS("The company you chose isn't exist."),
	CUSTOMER_IS_ALREADY_EXISTS("The customer you chose is already exist."),
	CUSTOMER_IS_NOT_EXISTS("The customer you chose isn't exist."),
	USER_IS_ALREADY_EXISTS("The user you chose is already exist."),
	USER_IS_NOT_EXISTS("The user you chose isn't exist."),
	COUPON_IS_ALREADY_EXISTS("The coupon you chose is already exist."),
	COUPON_IS_NOT_EXISTS("The coupon you chose isn't exist."),
	PURCHASE_IS_ALREADY_EXISTS("The purchase you chose is already exist."),
	PURCHASE_IS_NOT_EXISTS("The purchase you chose isn't exist."),
	EMPTY("The input is empty"),
	INVALID_ID("The ID you've enter is invalid."),
	INVALID_CATEGORY("The category you've enter is invalid."),
	INVALID_TYPE("The type you've enter is invalid."),
	INVALID_NAME("The name you've enter is invalid."),
	INVALID_AMOUNT("The amount you've entered is invalid."),
	INVALID_PRICE("The price you've entered is invalid."),
	INVALID_IMAGE("The image you've entered is invalid."),
	INVALID_PHONE_NUMBER("The phone number you've entered is invalid."),
	INVALID_EMAIL("The email you've entered is invalid."),
	INVALID_PASSWORD("The password you've entered is invalid. Please try again.\nThe password must contain one small & big letter and one digit!"),
	INVALID_DATES("The dates you've entered is invalid."),
	
	FIELD_IS_IRREPLACEABLE("You can't change this field."),
	NAME_IS_IRREPLACEABLE("You can't change your name."),
	COUPON_IS_OUT_OF_ORDER("Coupon is out of order."),
	LOGIN_FAILED("Login failed. credentials is incorrect, Please try again.");

	private String internalMessage;

	// constructor
	
	/**
	 * @param problem Receive a problem
	 */
	private ErrorType(String problem) {
		this.internalMessage = problem;
	}

	// getter
	
	/**
	 * @return This function return a message
	 */
	public String getMessage() {
		return internalMessage;
	}

}
