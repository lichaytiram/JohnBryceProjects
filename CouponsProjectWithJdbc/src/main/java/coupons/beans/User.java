package coupons.beans;

import coupons.enums.ClientType;
import coupons.exception.ApplicationException;

/**
 * This class create an user
 * 
 * @author Lichay
 *
 */
public class User {

	// properties

	private long id;
	private String userName;
	private String password;
	private ClientType type;
	private Long companyId;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id        Receive an id
	 * @param userName  Receive an user name
	 * @param password  Receive a password
	 * @param type      Receive a type
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public User(long id, String userName, String password, ClientType type, Long companyId)
			throws ApplicationException {
		this(userName, password, type, companyId);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param userName  Receive an user name
	 * @param password  Receive a password
	 * @param type      Receive a type
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public User(String userName, String password, ClientType type, Long companyId) throws ApplicationException {
		this();
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.companyId = companyId;
	}

	/**
	 * constructor for create a show for this class
	 */
	public User() {
		super();

	}

	// getter & setter

	/**
	 * @return This function receive an id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id Receive an id
	 */
	public void setId(long id) {
		this.id = id;
	}

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

	/**
	 * @return This function return a type
	 */
	public ClientType getType() {
		return type;
	}

	/**
	 * @param type Receive a type
	 */
	public void setType(ClientType type) {
		this.type = type;
	}

	/**
	 * @return This function return a company id
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId Receive a company id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", userName=" + getUserName() + ", password=" + getPassword() + ", type="
				+ getType() + ", companyId=" + getCompanyId() + "]";
	}

}
