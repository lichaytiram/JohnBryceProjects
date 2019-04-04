package utils;

import enums.ErrorType;
import exception.ApplicationException;

public class PasswordUtils {

	/**
	 * @param password This function receive a password and check if the password
	 *                 valid
	 * @throws ApplicationException Throw an exception by name
	 */
	public static void isValidPassword(String password) throws ApplicationException {

		if (!checkPassword(password))
			throw new ApplicationException(ErrorType.INVALID_PASSWORD.getMessage());

	}

	/**
	 * @param password Check if password contain big&small letter and one digit at
	 *                 least
	 * @return Check if the password valid and return true or false
	 */
	private static boolean checkPassword(String password) throws ApplicationException {

		if (password == null || password.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		char checkLetter = 'a';

		while (checkLetter <= 'z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'z')
				return false;
			checkLetter++;
		}

		checkLetter = 'A';
		while (checkLetter <= 'Z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'Z')
				return false;
			checkLetter++;
		}

		int checkDigit = 0;
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
