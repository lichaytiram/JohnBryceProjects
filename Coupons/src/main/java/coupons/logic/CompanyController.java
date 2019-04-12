package coupons.logic;

import java.util.List;

import org.springframework.stereotype.Controller;

import coupons.beans.Company;
import coupons.dao.CompaniesDao;
import coupons.dao.CouponsDao;
import coupons.dao.ICompaniesDao;
import coupons.dao.ICouponsDao;
import coupons.dao.IPurchasesDao;
import coupons.dao.IUsersDao;
import coupons.dao.PurchasesDao;
import coupons.dao.UsersDao;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.ValidationUtils;

/**
 * This class manage the all function for company facade
 * 
 * @author Lichay
 */
@Controller
public class CompanyController {

	private ICompaniesDao companiesDao;
	private ICouponsDao couponsDao;
	private IPurchasesDao purchasesDao;
	private IUsersDao userDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public CompanyController() throws ApplicationException {

		companiesDao = new CompaniesDao();
		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
		userDao = new UsersDao();

	}

	/**
	 * @param company Receive a company
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createCompany(Company company) throws ApplicationException {

		if (company == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		ValidationUtils.isValidName(company.getName());
		ValidationUtils.isValidPhoneNumber(company.getPhoneNumber());
		ValidationUtils.isValidEmail(company.getEmail());

		if (companiesDao.isCompanyExists(company.getId()))
			throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage());

		if (companiesDao.isCompanyExists(company.getName()))
			throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage());

		return companiesDao.createCompany(company);

	}

	/**
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCompany(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCompanyId(companyId);
		couponsDao.deleteCouponbyCompanyId(companyId);
		userDao.deleteUserByCompanyId(companyId);
		companiesDao.deleteCompany(companyId);

	}

	/**
	 * @param company Receive a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCompany(Company company) throws ApplicationException {

		if (company == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		ValidationUtils.isValidId(company.getId());
		ValidationUtils.isValidName(company.getName());
		ValidationUtils.isValidPhoneNumber(company.getPhoneNumber());
		ValidationUtils.isValidEmail(company.getEmail());

		if (!companiesDao.isCompanyExists(company.getId()))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		Company companyFromDataBase = companiesDao.getCompany(company.getId());

		if (!companyFromDataBase.getName().equals(company.getName())) {

			if (companiesDao.isCompanyExists(company.getName())) {

				throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage());

			}
		}

		companiesDao.updateCompany(company);

	}

	/**
	 * @return This function return company list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Company> getAllCompany() throws ApplicationException {

		return companiesDao.getAllCompany();

	}

	/**
	 * @param companyId Receive a company id
	 * @return This function return a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Company getCompany(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return companiesDao.getCompany(companyId);

	}

}