package utils;

import enums.ErrorType;
import exception.ApplicationException;

public class NameUtils {

	/**
	 * @param name This function set a new name if valid
	 * @throws ApplicationException Throw an exception by name
	 */
	public static void isValidName(String name) throws ApplicationException {

		if (name == null || name.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (name.length() < 2)
			throw new ApplicationException("Your name is invalid (must contain at least 2 letters)");

	}

}
