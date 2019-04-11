package utils;

import enums.ClientType;
import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class check validations
 * 
 * @author Lichay
 *
 */
public class ValidationUtils {

	/**
	 * @param id Receive an id
	 * @return This function return true if id is valid or throw exception if didn't
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidId(long id) throws ApplicationException {

		if (id < 1)
			throw new ApplicationException(ErrorType.INVALID_ID.getMessage());

	}

	/**
	 * @param name This function set a new name if valid
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidName(String name) throws ApplicationException {

		if (name == null || name.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (name.length() < 2)
			throw new ApplicationException(ErrorType.INVALID_NAME.getMessage());

	}

	/**
	 * @param phoneNumber Receive a phone number
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidPhoneNumber(String phoneNumber) throws ApplicationException {

		if (phoneNumber == null || phoneNumber.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (phoneNumber.charAt(0) != '0')
			throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER.getMessage());

		if (phoneNumber.length() != 10)
			throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER.getMessage());

		// check if all char contain a digit
		for (int i = 0; i < phoneNumber.length(); i++) {
			if (phoneNumber.charAt(i) > '9' || phoneNumber.charAt(i) < '0')
				throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER.getMessage());
		}

	}

	/**
	 * @param email This function receive a email and check if valid (by some
	 *              definitions)
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidEmail(String email) throws ApplicationException {

		if (email == null || email.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (!email.contains("@"))
			throw new ApplicationException(ErrorType.INVALID_EMAIL.getMessage());

		if (!(email.indexOf('@') + 1 < email.lastIndexOf('.')))
			throw new ApplicationException(ErrorType.INVALID_EMAIL.getMessage());

	}

	/**
	 * @param amount Receive an amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidAmount(int amount) throws ApplicationException {

		if (amount < 0)
			throw new ApplicationException(ErrorType.INVALID_AMOUNT.getMessage());

	}

	/**
	 * @param type Receive a type
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidType(ClientType type) throws ApplicationException {

		if (type == null)
			throw new ApplicationException(ErrorType.INVALID_TYPE.getMessage());

	}

	/**
	 * @param password Receive a password
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidPassword(String password) throws ApplicationException {

		if (!checkPassword(password))
			throw new ApplicationException(ErrorType.INVALID_PASSWORD.getMessage());

	}

	/**
	 * @param password Receive a password
	 * @return Check if the password valid and return true or false
	 * @throws ApplicationException This function can throw an applicationException
	 */
	private static boolean checkPassword(String password) throws ApplicationException {

		if (password == null || password.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		char checkLetter = 'a';

		// check if checkLetter contain at least lower case letter
		while (checkLetter <= 'z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'z')
				return false;
			checkLetter++;
		}

		checkLetter = 'A';

		// check if checkLetter contain at least upper case letter
		while (checkLetter <= 'Z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'Z')
				return false;
			checkLetter++;
		}

		int checkDigit = 0;

		// check if checkLetter contain at least one digit
		while (checkDigit < 10) {
			if (password.contains(checkDigit + ""))
				break;
			if (checkDigit == 9)
				return false;
			checkDigit++;
		}
		return true;

	}

}
