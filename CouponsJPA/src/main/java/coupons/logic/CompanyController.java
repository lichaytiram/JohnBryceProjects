package coupons.logic;

import java.util.List;

import org.springframework.stereotype.Controller;

import coupons.beans.Company;
import coupons.beans.UserDataMap;
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
	 * @param company  Receive a company
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void createCompany(Company company, UserDataMap userData) throws ApplicationException {

		if (company == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidName(company.getName());
		ValidationUtils.isValidPhoneNumber(company.getPhoneNumber());
		ValidationUtils.isValidEmail(company.getEmail());

		if (companiesDao.isCompanyExists(company.getId()))
			throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS,
					ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage(), false);

		if (companiesDao.isCompanyExists(company.getName()))
			throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS,
					ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage(), false);

		companiesDao.createCompany(company);

	}

	/**
	 * @param companyId Receive a company id
	 * @param userData  Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCompany(long companyId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		purchasesDao.deletePurchaseByCompanyId(companyId);
		couponsDao.deleteCouponbyCompanyId(companyId);
		userDao.deleteUserByCompanyId(companyId);
		companiesDao.deleteCompany(companyId);

	}

	/**
	 * @param company  Receive a company
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCompany(Company company, UserDataMap userData) throws ApplicationException {

		if (company == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(company.getId());
		ValidationUtils.isValidName(company.getName());
		ValidationUtils.isValidPhoneNumber(company.getPhoneNumber());
		ValidationUtils.isValidEmail(company.getEmail());

		if (!companiesDao.isCompanyExists(company.getId()))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		Company companyFromDataBase = companiesDao.getCompany(company.getId());

		if (!companyFromDataBase.getName().equals(company.getName())) {

			if (companiesDao.isCompanyExists(company.getName())) {

				throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS,
						ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage(), false);

			}
		}

		companiesDao.updateCompany(company);

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return company list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Company> getAllCompanies(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		return companiesDao.getAllCompanies();

	}

	/**
	 * @param companyId Receive a company id
	 * @param userData  Receive an userData
	 * @return This function return a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Company getCompany(long companyId, UserDataMap userData) throws ApplicationException {

		if (userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getClientType().name().equals("Company")) {
			if (userData.getCompanyId() != companyId)
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		return companiesDao.getCompany(companyId);

	}

}