package coupons.dao;

import java.util.List;

import coupons.beans.Company;
import coupons.exception.ApplicationException;

/**
 * This interface will implement by class companyDao
 * 
 * @author Lichay
 *
 */
public interface ICompaniesDao {

	/**
	 * @param company Receive a company
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createCompany(Company company) throws ApplicationException;

	/**
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCompany(long companyId) throws ApplicationException;

	/**
	 * @param company Receive a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCompany(Company company) throws ApplicationException;

	/**
	 * @return This function return company list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Company> getAllCompanies() throws ApplicationException;

	/**
	 * @param name Receive a name
	 * @return This function return true if company exists
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public boolean isCompanyExists(String name) throws ApplicationException;

	/**
	 * @param companyId Receive a company id
	 * @return This function return true if company exists
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public boolean isCompanyExists(long companyId) throws ApplicationException;

	/**
	 * @param companyId Receive a company id
	 * @return This function return a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Company getCompany(long companyId) throws ApplicationException;

}
