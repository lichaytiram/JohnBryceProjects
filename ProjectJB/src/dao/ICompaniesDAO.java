package dao;

import java.util.ArrayList;

import javaBeans.Company;
import javaBeans.Coupon;

public interface ICompaniesDAO extends IMainDAO {

	void insert(Company c) throws Exception;

	void delete(int companyID) throws Exception;

	void update(Company c) throws Exception;

	boolean isCompanyExists(String email, String password) throws Exception;

	ArrayList<Company> getAllCompany() throws Exception;

	Company getOneCompany(int companyID) throws Exception;

	Company getOneCompanyByEmailAndPassword(String email, String password) throws Exception;



}
