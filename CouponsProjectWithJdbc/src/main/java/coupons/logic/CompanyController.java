package coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import coupons.beans.Company;
import coupons.beans.UserDataMap;
import coupons.dao.ICompaniesDao;
import coupons.dao.ICouponsDao;
import coupons.dao.IPurchasesDao;
import coupons.dao.IUsersDao;
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

	@Autowired
	private ICompaniesDao companiesDao;
	@Autowired
	private ICouponsDao couponsDao;
	@Autowired
	private IPurchasesDao purchasesDao;
	@Autowired
	private IUsersDao usersDao;

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
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public void deleteCompany(long companyId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		purchasesDao.deletePurchaseByCompanyId(companyId);
		couponsDao.deleteCouponbyCompanyId(companyId);
		usersDao.deleteUserByCompanyId(companyId);
		companiesDao.deleteCompany(companyId);

	}

	/**
	 * @param company  Receive a company
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
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