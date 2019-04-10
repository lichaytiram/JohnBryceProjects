package utils;

import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class create an utilities filter
 * 
 * @author Lichay
 *
 */
public class IdUtils {

	/**
	 * @param id Receive an id
	 * @return This function return true if id is valid or throw exception if didn't
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidId(long id) throws ApplicationException {

		if (id < 1)
			throw new ApplicationException(ErrorType.INVALID_ID.getMessage());

	}
}
