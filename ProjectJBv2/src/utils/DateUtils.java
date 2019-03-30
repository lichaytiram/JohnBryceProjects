package utils;

import java.util.Date;

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
	public static boolean isDateValid(Date startDate, Date endDate) throws ApplicationException {

		
		if (startDate == null || endDate == null)
			throw new ApplicationException("This date is empty");

		Date currentDate = new Date();
		if (startDate.before(endDate) && endDate.after(currentDate))
			return true;
		throw new ApplicationException("This date isn't valid");
	}
}
