package utils;

import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class create an utilities filter
 * 
 * @author Lichay
 *
 */
public class AmountUtils {

	/**
	 * @param amount Receive an amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidAmount(int amount) throws ApplicationException {

		if (amount < 0)
			throw new ApplicationException(ErrorType.INVALID_AMOUNT.getMessage());

	}

}
