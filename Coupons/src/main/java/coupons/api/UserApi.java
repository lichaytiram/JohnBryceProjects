package coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.User;
import coupons.enums.ClientType;
import coupons.exception.ApplicationException;
import coupons.logic.UserController;

/**
 * This class create api with the server
 * 
 * @author Lichay
 *
 */
@RestController
@RequestMapping("/users")
public class UserApi {

	@Autowired
	private UserController userController = null;

	// constructor

	/**
	 * Create instance for this class
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public UserApi() throws ApplicationException {

		userController = new UserController();

	}

	/**
	 * @param user Receive an user
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public long createUser(@RequestBody User user) throws ApplicationException {

		return userController.createUser(user);

	}

	/**
	 * @param userId Receive an user id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") long userId) throws ApplicationException {

		userController.deleteUser(userId);

	}

	/**
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{companyId}")
	public void deleteUserByCompanyId(@PathVariable("companyId") long companyId) throws ApplicationException {

		userController.deleteUserByCompanyId(companyId);

	}

	// don't work with @RequestBody
//	/**
//	 * @param userName Receive an user name
//	 * @param password Receive a password
//	 * @param userId   Receive an user id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@PutMapping
//	public void updateUser(@RequestBody String userName, String password, long userId) throws ApplicationException {
//
//		userController.updateUser(userName, password, userId);
//
//	}

	/**
	 * @return This function return an user list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<User> getAllUsers() throws ApplicationException {

		return userController.getAllUsers();

	}

	/**
	 * @param userName Receive an user name
	 * @param password Receive a password
	 * @return This function return a client type
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{login}") // ask avi how to do it
	public ClientType login(@PathVariable("login") String userName, String password) throws ApplicationException {

		return userController.login(userName, password);

	}

}
