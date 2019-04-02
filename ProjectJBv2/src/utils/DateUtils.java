package utils;

import java.util.Date;

import enums.ErrorType;
import exception.ApplicationException;

/**
 * This class implements converter from util date to sql date
 * 
 * @author Lichay
 */
public class DateUtils {

	/**
	 * @param javaDate Give an util date and return sql date
	 * @return return sql date
	 */
	public static java.sql.Date javaDateToSqlDate(java.util.Date javaDate) {
		return new java.sql.Date(javaDate.getTime());
	}

	/**
	 * @param startDate Receive a start date
	 * @param endDate   Receive a end date
	 * @return This function return true if date is valid or throw exception if
	 *         isn't
	 * @throws ApplicationException Can throw an exception by name
	 */
	public static void isValidDate(Date startDate, Date endDate) throws ApplicationException {

		if (startDate == null || endDate == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (startDate.after(endDate) || startDate.equals(endDate))
			throw new ApplicationException(
					"have a problem:\n" + "This coupon date isn't valid (start date must be before end date)");

		Date currentDate = new Date();
		if (endDate.before(currentDate))
			throw new ApplicationException(
					"have a problem:\n" + "This coupon date isn't valid (end date must be after current date");

	}
}
