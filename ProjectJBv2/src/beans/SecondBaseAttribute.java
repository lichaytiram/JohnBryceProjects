package beans;

import java.util.ArrayList;

import exception.ExceptionName;

/**
 * This class extends from BaseAttribute and contain more basic attributes
 * 
 * @author Lichay
 *
 */
public abstract class SecondBaseAttribute extends BaseAttribute {

	// properties

	private String password;
	private String email;
	private ArrayList<Coupon> couponList;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id       Receive an id
	 * @param password Receive a password
	 * @param email    Receive an email
	 * @throws ExceptionName Throw an exception by name
	 */
	public SecondBaseAttribute(long id, String password, String email) throws ExceptionName {
		super(id);
		setPassword(password);
		setEmail(email);
		couponList = new ArrayList<>();
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param password Receive a password
	 * @param email    Receive an email
	 * @throws ExceptionName Throw an exception by name
	 */
	public SecondBaseAttribute(String password, String email) throws ExceptionName {
		super();
		setPassword(password);
		setEmail(email);
		couponList = new ArrayList<>();
	}

	// getter & setter

	/**
	 * @return This function return a coupon list
	 */
	public ArrayList<Coupon> getCouponList() {
		return couponList;
	}

	/**
	 * @param coupon This function add coupon for coupon list
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setCouponList(Coupon coupon) throws ExceptionName {
		for (int i = 0; i < couponList.size(); i++)
			if (couponList.get(i).getId() == coupon.getId() && couponList.get(i).getCompanyId() == coupon.getCompanyId()
					&& couponList.get(i).getCategory().equals(coupon.getCategory()))
				throw new ExceptionName("The coupon already exists");
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
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setPassword(String password) throws ExceptionName {
		if (checkPassword(password))
			this.password = password;
		else
			throw new ExceptionName("The password must contain one digit , one big letter and one small letter");
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
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setEmail(String email) throws ExceptionName {

		if (!email.contains("@"))
			throw new ExceptionName("Your email invalid (isn't contain <@>)");
		else if (!(email.indexOf('@') + 1 < email.lastIndexOf('.')))
			throw new ExceptionName("Your email invalid (isn't contain <.> after <@> one letter at least)");
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

	/**
	 * @return This function return as string all attributes
	 */
	@Override
	public String toString() {
		return super.toString() + ", password=" + getPassword() + ", email=" + getEmail() + ", couponList="
				+ getCouponList();
	}

}
