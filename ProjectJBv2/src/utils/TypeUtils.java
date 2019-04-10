package utils;

import enums.ClientType;
import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class create an utilities filter
 * 
 * @author Lichay
 *
 */
public class TypeUtils {

	/**
	 * @param type Receive a type
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidType(ClientType type) throws ApplicationException {

		if (type == null)
			throw new ApplicationException(ErrorType.INVALID_TYPE.getMessage());

	}

}
