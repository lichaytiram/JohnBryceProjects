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
import org.springframework.web.bind.annotation.RequestParam;
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
	private UserController userController;

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
	 * @param userName Receive an user name
	 * @param password Receive a password
	 * @param userId   Receive an user id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateUser(@RequestBody User user) throws ApplicationException {

		userController.updateUser(user);

	}

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
	@GetMapping("/byType")
	public ClientType login(@RequestParam("userName") String userName, @RequestParam("password") String password)
			throws ApplicationException {

		return userController.login(userName, password);

	}

}
