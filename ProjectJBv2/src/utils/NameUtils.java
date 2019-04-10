package utils;

import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class create an utilities filter
 * 
 * @author Lichay
 *
 */
public class NameUtils {

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

}
