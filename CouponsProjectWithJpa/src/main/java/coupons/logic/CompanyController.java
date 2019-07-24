package coupons.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import coupons.beans.UserDataMap;
import coupons.dao.ICompaniesDao;
import coupons.entities.Company;
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

		if (companiesDao.existsById(company.getId()))
			throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS,
					ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage(), false);

		if (companiesDao.existsByName(company.getName()))
			throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS,
					ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage(), false);

		companiesDao.save(company);

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

		if (!companiesDao.existsById(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		// delete all children with cascade
		companiesDao.deleteById(companyId);

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

		if (!companiesDao.existsById(company.getId()))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		Company companyFromDataBase = companiesDao.findById(company.getId()).get();

		if (!companyFromDataBase.getName().equals(company.getName())) {

			if (companiesDao.existsByName(company.getName())) {

				throw new ApplicationException(ErrorType.COMPANY_IS_ALREADY_EXISTS,
						ErrorType.COMPANY_IS_ALREADY_EXISTS.getMessage(), false);

			}
		}

		companiesDao.save(company);

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return company list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Company> getAllCompanies(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		List<Company> companies = new ArrayList<Company>();
		companiesDao.findAll().forEach(companies::add);

		return companies;

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

		if (!companiesDao.existsById(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		return companiesDao.findById(companyId).get();

	}

}