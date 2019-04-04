package utils;

import enums.ErrorType;
import exception.ApplicationException;

public class IdUtils {

	/**
	 * @param id Receive an id
	 * @return This function return true if id is valid or throw exception if didn't
	 * @throws ApplicationException throw exception by name
	 */
	public static void isValidId(long id) throws ApplicationException {

		if (id < 1)
			throw new ApplicationException(ErrorType.INVALID_ID.getMessage());

	}
}
