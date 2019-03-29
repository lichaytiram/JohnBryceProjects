package utils;

import exception.ApplicationException;

public class NameUtils {

	/**
	 * @param name This function set a new name if valid
	 * @throws ApplicationException Throw an exception by name
	 */
	public boolean isNameValid(String name) throws ApplicationException {
		if (name.length() < 2)
			throw new ApplicationException("Your name is invalid (must contain at least 2 letters)");

		return true;
	}

}
