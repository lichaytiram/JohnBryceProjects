package coupons.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.UserDataMap;
import coupons.entities.Company;
import coupons.exception.ApplicationException;
import coupons.logic.CompanyController;

/**
 * This class create api with the server
 * 
 * @author Lichay
 *
 */
@RestController
@RequestMapping("/companies")
public class CompanyApi {

	@Autowired
	private CompanyController companyController;

	/**
	 * @param company Receive a company
	 * @param request Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public void createCompany(@RequestBody Company company, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		companyController.createCompany(company, userData);

	}

	/**
	 * @param companyId Receive a company id
	 * @param request   Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{companyId}")
	public void deleteCompany(@PathVariable("companyId") long companyId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		companyController.deleteCompany(companyId, userData);

	}

	/**
	 * @param company Receive a company
	 * @param request Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateCompany(@RequestBody Company company, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		companyController.updateCompany(company, userData);

	}

	/**
	 * @param request Receive a httpServletRequest
	 * @return This function return company list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Company> getAllCompanies(HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return companyController.getAllCompanies(userData);

	}

	/**
	 * @param companyId Receive a company id
	 * @param request   Receive a httpServletRequest
	 * @return This function return a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{companyId}")
	public Company getCompany(@PathVariable("companyId") long companyId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return companyController.getCompany(companyId, userData);

	}

}
