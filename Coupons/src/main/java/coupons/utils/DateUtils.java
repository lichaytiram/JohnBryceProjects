package coupons.utils;

import java.util.Date;

import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;

/**
 * This class create an utilities filter
 * 
 * @author Lichay
 *
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
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public static void isValidDate(Date startDate, Date endDate) throws ApplicationException {

		if (startDate == null || endDate == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		Date currentDate = new Date();

		// check if date is valid
		if (startDate.after(endDate) || startDate.equals(endDate) || endDate.before(currentDate))
			throw new ApplicationException(ErrorType.INVALID_DATES, ErrorType.INVALID_DATES.getMessage(), false);

	}
}
