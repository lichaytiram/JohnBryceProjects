package utils;

/**
 * This class implements converter from util date to sql date
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
}
