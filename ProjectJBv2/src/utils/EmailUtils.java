package utils;

import exception.ApplicationException;

public class EmailUtils {

	/**
	 * @param email This function receive a email and check if valid (by some
	 *              definitions)
	 * @throws ApplicationException Throw an exception by name
	 */
	public static void isValidEmail(String email) throws ApplicationException {

		if (email == null || email.isEmpty())
			throw new ApplicationException("Your email is empty");

		if (!email.contains("@"))
			throw new ApplicationException("Your email invalid (isn't contain <@>)");

		if (!(email.indexOf('@') + 1 < email.lastIndexOf('.')))
			throw new ApplicationException("Your email invalid (isn't contain <.> after <@> one letter at least)");

	}

}
