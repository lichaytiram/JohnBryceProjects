package coupons.beans;

/**
 * This class create a login
 * 
 * @author Lichay
 *
 */
public class Login {

	// properties

	private String userName;
	private String password;

	// constructor

	/**
	 * Constructor for create a show for this class
	 * 
	 * @param userName Receive an user name
	 * @param password Receive a password
	 */
	public Login(String userName, String password) {
		this();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Constructor for create a show for this class
	 */
	public Login() {
		super();
	}

	// getter & setter

	/**
	 * @return This function return an user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName Receive an user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return This function return a password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password Receive a password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userName=" + getUserName() + ", password=" + getPassword() + "]";
	}

}
