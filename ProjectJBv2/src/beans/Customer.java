package beans;

import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;

/**
 * This class create a customer
 * 
 * @author Lichay
 *
 */
public class Customer {

	// properties

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<Coupon> couponList;
	private User user;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id        Receive an id
	 * @param firstName Receive a first name
	 * @param lastName  Receive a last name
	 * @param email     Receive an email
	 * @param password  Receive a password
	 * @throws ApplicationException Throw an exception by name
	 */
	public Customer(long id, String firstName, String lastName, String email, String password)
			throws ApplicationException {
		this(firstName, lastName, email, password);
		setId(id);
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param firstName Receive a first name
	 * @param lastName  Receive a last name
	 * @param email     Receive an email
	 * @param password  Receive a password
	 * @throws ApplicationException Throw an exception by name
	 */
	public Customer(String firstName, String lastName, String email, String password) throws ApplicationException {
		this();

		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @throws ApplicationException Throw an exception by name
	 */
	public Customer() {
		super();
		couponList = new ArrayList<>();
		user = new User();
	}

	// getter & setter

	/**
	 * @return This function return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id Receive an id and change it for the new one (if it valid)
	 * @throws ApplicationException throw exception by name
	 */
	public void setId(long id) throws ApplicationException {

		if (id > 0)
			this.id = id;
		else
			throw new ApplicationException("Your Id must contain at least 1 digit and be bigger then 0");
	}

	/**
	 * @return This function return a coupon list
	 */
	public List<Coupon> getCouponList() {
		return couponList;
	}

	/**
	 * @param coupon This function add coupon for coupon list
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setCouponList(Coupon coupon) throws ApplicationException {
		for (int i = 0; i < couponList.size(); i++)
			if (couponList.get(i).getId() == coupon.getId() && couponList.get(i).getCompanyId() == coupon.getCompanyId()
					&& couponList.get(i).getCategory().equals(coupon.getCategory()))
				throw new ApplicationException("The coupon already exists");
		couponList.add(coupon);
	}

	/**
	 * @return This function return a password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password This function receive a new password and change the last one
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setPassword(String password) throws ApplicationException {
		if (checkPassword(password))
			this.password = password;
		else
			throw new ApplicationException("The password must contain one digit , one big letter and one small letter");
	}

	/**
	 * @return This function return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email This function receive a new email and change the last one (by
	 *              some definitions)
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setEmail(String email) throws ApplicationException {

		if (!email.contains("@"))
			throw new ApplicationException("Your email invalid (isn't contain <@>)");
		else if (!(email.indexOf('@') + 1 < email.lastIndexOf('.')))
			throw new ApplicationException("Your email invalid (isn't contain <.> after <@> one letter at least)");
		else
			this.email = email;
	}

	/**
	 * @return This function return a first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Name will be first big latter and after small latter
	 * 
	 * @param firstName This function receive a first name and change the last one
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setFirstName(String firstName) throws ApplicationException {
		if (firstName.length() < 2)
			throw new ApplicationException("Your first name must contain at least two letters");
		this.firstName = firstName.charAt(0) <= 'Z'
				? firstName.charAt(0) + firstName.substring(1, firstName.length()).toLowerCase()
				: (char) (firstName.charAt(0) - 32) + firstName.substring(1, firstName.length()).toLowerCase();
	}

	/**
	 * @return This function return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * name will be first big latter and after small latter
	 * 
	 * @param lastName This function receive a last name and change the last one
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setLastName(String lastName) throws ApplicationException {
		if (lastName.length() < 2)
			throw new ApplicationException("Your last name must contain at least two letters");
		this.lastName = lastName.charAt(0) <= 'Z'
				? lastName.charAt(0) + lastName.substring(1, lastName.length()).toLowerCase()
				: (char) (lastName.charAt(0) - 32) + lastName.substring(1, lastName.length()).toLowerCase();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// functions

	/**
	 * @param password Check if password contain big&small letter and one digit at
	 *                 least
	 * @return Check if the password valid and return true or false
	 */
	private boolean checkPassword(String password) {
		if (password == null)
			return false;
		if (password.isEmpty())
			return false;
		char checkLetter = 'a';
		while (checkLetter <= 'z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'z')
				return false;
			checkLetter++;
		}
		checkLetter = 'A';
		while (checkLetter <= 'Z') {
			if (password.contains(checkLetter + ""))
				break;
			if (checkLetter == 'Z')
				return false;
			checkLetter++;
		}

		int checkDigit = 0;
		while (checkDigit < 10) {
			if (password.contains(checkDigit + ""))
				break;
			if (checkDigit == 9)
				return false;
			checkDigit++;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [ id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", email="
				+ getEmail() + ", password=" + getPassword() + ", couponList=" + getCouponList() + " ]";
	}

}
