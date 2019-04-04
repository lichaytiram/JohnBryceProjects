package utils;

import enums.ErrorType;
import exception.ApplicationException;

public class PhoneNumberUtils {

	public static void isValidPhoneNumber(String phoneNumber) throws ApplicationException {

		if (phoneNumber == null || phoneNumber.isEmpty())
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (phoneNumber.charAt(0) != '0')
			throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER.getMessage());

		if (phoneNumber.length() != 10)
			throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER.getMessage());

		for (int i = 0; i < phoneNumber.length(); i++) {
			if (phoneNumber.charAt(i) > '9' || phoneNumber.charAt(i) < '0')
				throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER.getMessage());
		}

	}
}
