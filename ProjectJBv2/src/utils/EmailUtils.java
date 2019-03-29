package utils;

import exception.ApplicationException;

public class EmailUtils {

	/**
	 * @param email This function receive a email and check if valid (by some
	 *              definitions)
	 * @throws ApplicationException Throw an exception by name
	 */
	public static boolean setEmail(String email) throws ApplicationException {

		if (!email.contains("@"))
			throw new ApplicationException("Your email invalid (isn't contain <@>)");
		else if (!(email.indexOf('@') + 1 < email.lastIndexOf('.')))
			throw new ApplicationException("Your email invalid (isn't contain <.> after <@> one letter at least)");

		return true;
	}

}
