package beans;

import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;

/**
 * This class create a company
 * 
 * @author Lichay
 *
 */
public class Company {

	// properties

	private long id;
	private String name;
	private String password;
	private String email;
	private List<Coupon> couponList;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id       Receive an id
	 * @param name     Receive a name for company
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @throws ApplicationException Throw an exception by name
	 */
	public Company(long id, String name, String email, String password) throws ApplicationException {
		this(name, email, password);
		setId(id);
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param name     Receive a name for company
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @throws ApplicationException Throw an exception by name
	 */
	public Company(String name, String email, String password) throws ApplicationException {
		this();
		setName(name);
		setEmail(email);
		setPassword(password);

	}

	/**
	 * constructor for create a show for this class
	 * 
	 */
	public Company() {
		couponList = new ArrayList<>();
	}

	// getter & setter

	/**
	 * @return This function return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id Receive an id and update it for the new one (if it valid)
	 * @throws ApplicationException throw exception by name
	 */
	public void setId(long id) throws ApplicationException {

		if (id > 0)
			this.id = id;
		else
			throw new ApplicationException("Your Id must contain at least 1 digit and be bigger then 0");
	}

	/**
	 * @return this function return a name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name This function set a new name if valid
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setName(String name) throws ApplicationException {
		if (name.length() < 2)
			throw new ApplicationException("Your company name is invalid (must contain at least 2 letters)");
		this.name = name;
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

}