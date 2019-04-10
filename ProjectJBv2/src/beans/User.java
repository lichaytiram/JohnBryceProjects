package beans;

import enums.ClientType;
import exception.ApplicationException;

/**
 * This class create an user
 * 
 * @author Lichay
 *
 */
public class User {

	// property

	private long id;
	private String userName;
	private String password;
	private ClientType type;
	private Long companyId;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id
	 * @param userName
	 * @param password
	 * @param type
	 * @param companyId
	 * @throws ApplicationException
	 */
	public User(long id, String userName, String password, ClientType type, Long companyId)
			throws ApplicationException {
		this(userName, password, type, companyId);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param userName
	 * @param password
	 * @param type
	 * @param companyId
	 */
	public User(String userName, String password, ClientType type, Long companyId) {
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
