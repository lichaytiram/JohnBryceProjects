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

import coupons.beans.Customer;
import coupons.beans.Name;
import coupons.beans.UserDataMap;
import coupons.exception.ApplicationException;
import coupons.logic.CustomerController;

/**
 * This class create api with the server
 * 
 * @author Lichay
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerApi {

	@Autowired
	private CustomerController customerController;

	/**
	 * @param customer Receive a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping("/unsecured")
	public void createCustomer(@RequestBody Customer customer) throws ApplicationException {

		customerController.createCustomer(customer);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param request    Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		customerController.deleteCustomer(customerId, userData);

	}

	/**
	 * @param customer Receive a customer
	 * @param request  Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateCustomer(@RequestBody Customer customer, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		customerController.updateCustomer(customer, userData);

	}

	/**
	 * @param request Receive a httpServletRequest
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Customer> getAllCustomers(HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return customerController.getAllCustomers(userData);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param request    Receive a httpServletRequest
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return customerController.getCustomer(customerId, userData);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param request    Receive a httpServletRequest
	 * @return This function return customer name
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/name/{customerId}")
	public Name getCustomerName(@PathVariable("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return customerController.getCustomerName(customerId, userData);

	}

}
