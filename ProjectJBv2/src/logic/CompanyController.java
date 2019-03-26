package logic;

import java.util.ArrayList;
import java.util.List;

import beans.Company;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.PurchasesDao;
import exception.ApplicationException;

/**
 * This class manage the all function for company facade
 * 
 * @author Lichay
 */
public class CompanyController {

	private CompaniesDao companiesDao;
	private CouponsDao couponsDao;
	private PurchasesDao purchasesDao;

	public CompanyController() throws ApplicationException {
		companiesDao = new CompaniesDao();
		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
	}

	public void createCompany(Company company) throws ApplicationException {
		CompaniesDao companiesDao = new CompaniesDao();

		if (companiesDao.isCompanyExistsByName(company.getName())) {
			throw new ApplicationException("Have a problem:\n" + "This company exist!");
		}
		companiesDao.createCompany(company);
	}

	public void deleteCompany(long companyId) throws ApplicationException {
		List<Long> list = new ArrayList<>();

		if (!companiesDao.isCompanyExists(companyId)) {
			return;
		}

		list = couponsDao.getAllCouponsIdByCompanyId(companyId);
		while (list.size() > 0) {

			purchasesDao.refundCouponByCouponId(list.get(0));
			list.remove(0);

		}
		couponsDao.deleteCouponbyCompanyId(companyId);
		companiesDao.deleteCompany(companyId);

	}

	public void updateCompany(Company company) throws ApplicationException {
		if (companiesDao.isCompanyExistsByName(company.getName())) {
			throw new ApplicationException("Have a problem:\n" + "This company exist");
		}
		companiesDao.updateCompany(company);
	}

	public List<Company> getAllCompany() throws ApplicationException {
		return companiesDao.getAllCompany();
	}

	public Company getCompany(long companyId) throws ApplicationException {
		if (companiesDao.isCompanyExists(companyId)) {
			return companiesDao.getCompany(companyId);
		}
		throw new ApplicationException("Have a problem:\n" + "This company exist");

	}

	public Company getCompanyByEmailAndPassword(String email, String password) throws ApplicationException {
		if (companiesDao.isCompanyExists(email, password)) {
			return companiesDao.getCompanyByEmailAndPassword(email, password);
		}
		throw new ApplicationException("Have a problem:\n" + "This company exist");
	}

}