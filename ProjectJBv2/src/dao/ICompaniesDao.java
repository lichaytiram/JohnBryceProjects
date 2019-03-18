package dao;

import java.util.ArrayList;

import beans.Company;
import exception.ApplicationException;

/**
 * This interface will implement by class companiesDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICompaniesDao {

	/**
	 * @param c Receive a company and insert to data base
	 * @throws Exception Can throw an exception
	 */
	void createCompany(Company c) throws ApplicationException;

	/**
	 * @param companyID Receive a company id and delete it from data base
	 * @throws Exception Can throw an exception
	 */
	void deleteCompany(long companyId) throws ApplicationException;

	/**
	 * @param c Receive a new company and update old company
	 * @throws Exception Can throw an exception
	 */
	void updateCompany(Company c) throws ApplicationException;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return Check if company exists and return true or false
	 * @throws Exception Can throw an exception
	 */
	boolean isCompanyExists(String email, String password) throws ApplicationException;

	/**
	 * @param companyId Receive an id
	 * @return Check if company exists and return true or false
	 * @throws Exception Can throw an exception
	 */
	boolean isCompanyExists(long companyId) throws ApplicationException;

	/**
	 * @return This function return all company on data base
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Company> getAllCompany() throws ApplicationException;

	/**
	 * @param companyID Receive a company id
	 * @return This function return one company by his id
	 * @throws Exception Can throw an exception
	 */
	Company getCompany(long companyId) throws ApplicationException;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return company by email and password
	 * @throws Exception Can throw an exception
	 */
	Company getCompanyByEmailAndPassword(String email, String password) throws ApplicationException;

}
