package logic;

import java.util.List;

import beans.Company;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.PurchasesDao;
import enums.ErrorType;
import exception.ApplicationException;
import utils.ValidationUtils;

/**
 * This class manage the all function for company facade
 * 
 * @author Lichay
 */
public class CompanyController {

	private CompaniesDao companiesDao;
	private CouponsDao couponsDao;
	private PurchasesDao purchasesDao;
	private UserController userController;

	public CompanyController() throws ApplicationException {

		companiesDao = new CompaniesDao();
		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
		userController = new UserController();

	}

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

	public void deleteCompany(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCompanyId(companyId);
		couponsDao.deleteCouponbyCompanyId(companyId);
		userController.deleteUserByCompanyId(companyId);
		companiesDao.deleteCompany(companyId);

	}

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

	public List<Company> getAllCompany() throws ApplicationException {

		return companiesDao.getAllCompany();

	}

	public Company getCompany(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return companiesDao.getCompany(companyId);

	}

}