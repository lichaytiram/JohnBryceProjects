package utils;

import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class create an utilities filter
 * 
 * @author Lichay
 *
 */
public class PasswordUtils {

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
