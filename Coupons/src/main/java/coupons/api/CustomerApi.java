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
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public long createCustomer(@RequestBody Customer customer) throws ApplicationException {

		return customerController.createCustomer(customer);

	}

	/**
	 * @param customerId Receive a customer id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") long customerId) throws ApplicationException {

		customerController.deleteCustomer(customerId);

	}

	/**
	 * @param customer Receive a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateCustomer(@RequestBody Customer customer) throws ApplicationException {

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
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") long customerId) throws ApplicationException {

		return customerController.getCustomer(customerId);

	}

}
