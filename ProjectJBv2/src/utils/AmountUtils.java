package utils;

import enums.ErrorType;
import exception.ApplicationException;

public class AmountUtils {

	public static void isValidAmount(int amount) throws ApplicationException {

		if (amount < 0)
			throw new ApplicationException(ErrorType.INVALID_AMOUNT.getMessage());

	}

}
