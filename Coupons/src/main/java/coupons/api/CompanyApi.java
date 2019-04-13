package coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.Company;
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
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public long createCompany(@RequestBody Company company) throws ApplicationException {

		System.out.println(company);

		return companyController.createCompany(company);

	}

	/**
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{companyId}")
	public void deleteCompany(@PathVariable("companyId") long companyId) throws ApplicationException {

		companyController.deleteCompany(companyId);

	}

	/**
	 * @param company Receive a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateCompany(@RequestBody Company company) throws ApplicationException {

		companyController.updateCompany(company);

	}

	/**
	 * @return This function return company list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Company> getAllCompany() throws ApplicationException {

		return companyController.getAllCompany();

	}

	/**
	 * @param companyId Receive a company id
	 * @return This function return a company
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{companyId}")
	public Company getCompany(@PathVariable("companyId") long companyId) throws ApplicationException {

		return companyController.getCompany(companyId);

	}

}
