package facade;

import java.util.ArrayList;

import dbdao.CompaniesDBDAO;
import dbdao.CustomerDBDAO;
import exception.ExceptionName;
import javaBeans.Company;
import javaBeans.Customer;

public class AdminFacade extends ClientFacade {

	public AdminFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
	}

	@Override
	boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;
		return false;
	}

	public void addCompany(Company c) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.insert(c);
	}

	public void updateCompany(Company c) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.update(c);
	}

	public void deleteCompany(int companyID) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.delete(companyID);
	}

	public ArrayList<Company> getAllCompanies() throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		return companies.getAllCompany();
	}

	public Company getOneCompany(int companyID) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		return companies.getOneCompany(companyID);
	}

	public void addCustomer(Customer c) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		Customer.insert(c);
	}

	public void updateCustomer(Customer c) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		Customer.update(c);
	}

	public void deleteCustomer(int customerID) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		Customer.delete(customerID);
	}

	public ArrayList<Customer> getAllCustomer() throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		return Customer.getAllCustomer();
	}

	public Customer getOneCustomer(int customerID) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		return Customer.getOneCustomer(customerID);
	}

}
