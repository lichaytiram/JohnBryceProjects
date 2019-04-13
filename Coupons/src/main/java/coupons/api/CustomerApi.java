package coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.Customer;
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
	 * @return
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createCustomer(Customer customer) throws ApplicationException {

		return customerController.createCustomer(customer);

	}

	/**
	 * @param customerId Receive a customer id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCustomer(long customerId) throws ApplicationException {

		customerController.deleteCustomer(customerId);

	}

	/**
	 * @param customer Receive a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCustomer(Customer customer) throws ApplicationException {

		customerController.updateCustomer(customer);

	}

	/**
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Customer> getAllCustomer() throws ApplicationException {

		return customerController.getAllCustomer();

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("companyId") long customerId) throws ApplicationException {

		return customerController.getCustomer(customerId);

	}

}
