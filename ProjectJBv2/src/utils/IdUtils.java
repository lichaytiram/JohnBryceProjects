package utils;

import exception.ApplicationException;

public class IdUtils {

	/**
	 * @param id Receive an id and change it for the new one (if it valid)
	 */

	/**
	 * @param id Receive an id
	 * @return This function return true if id is valid or throw exception if didn't
	 * @throws ApplicationException throw exception by name
	 */
	public static boolean isIdvalid(long id) throws ApplicationException {
		if (id > 0)
			return true;

		throw new ApplicationException("Your Id must contain at least 1 digit and be bigger then 0");
	}
}
