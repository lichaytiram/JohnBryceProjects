package dao;

import java.util.ArrayList;

import javaBeans.Company;

public interface ICompaniesDAO extends IMainDAO {

	void insert(Company c) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(Company c, int index) throws Exception;

	boolean isCompanyExists(String email, String password) throws Exception;
	
	ArrayList<Company> getAllCompany() throws Exception;

	Company getOneCompany(int companyID) throws Exception;
}
