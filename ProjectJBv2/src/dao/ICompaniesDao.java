package dao;

import java.util.List;

import beans.Company;
import exception.ApplicationException;

public interface ICompaniesDao {

	public long createCompany(Company company) throws ApplicationException;

	public void deleteCompany(long companyId) throws ApplicationException;

	public void updateCompany(Company company) throws ApplicationException;

	public List<Company> getAllCompany() throws ApplicationException;

	public boolean isCompanyExists(String name) throws ApplicationException;

	public boolean isCompanyExists(long companyId) throws ApplicationException;

	public Company getCompany(long companyId) throws ApplicationException;

}
