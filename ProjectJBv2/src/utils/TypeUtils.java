package utils;

import enums.ClientType;
import enums.ErrorType;
import exception.ApplicationException;

public class TypeUtils {

	public static void isValidType(ClientType type) throws ApplicationException {

		if (type == null)
			throw new ApplicationException(ErrorType.INVALID_TYPE.getMessage());

	}

}
