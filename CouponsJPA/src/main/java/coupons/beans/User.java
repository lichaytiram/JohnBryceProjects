package coupons.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import coupons.enums.ClientType;
import coupons.exception.ApplicationException;

/**
 * This class create an user
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	// property

	private static final long serialVersionUID = 1652799167889220323L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true, length = 255) // UNSIGNED
	private long id;
	@Column(name = "USER_NAME", nullable = false, unique = true, length = 25)
	private String userName;
	@Column(name = "PASSWORD", nullable = false, unique = false, length = 50)
	private String password;
	@Column(name = "TYPE", nullable = false, unique = true, length = 50)
	private ClientType type;
	@Column(name = "COMPANY_ID", nullable = true, unique = false, length = 255) // UNSIGNED
	private Long companyId;
	@JoinColumn(name = "COMPANY", nullable = true, unique = false)
	@ManyToOne
	private Company company;

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

	// java persistence API

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", userName=" + getUserName() + ", password=" + getPassword() + ", type="
				+ getType() + ", companyId=" + getCompanyId() + "]";
	}

}
