package coupons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import coupons.enums.ClientType;

/**
 * This class create an user
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	// properties

	private static final long serialVersionUID = 1652799167889220323L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true, columnDefinition = "BIGINT(20) UNSIGNED")
	private long id;

	@Column(name = "USER_NAME", nullable = false, unique = true, length = 25)
	private String userName;

	@Column(name = "PASSWORD", nullable = false, unique = false, length = 50)
	private String password;

	@Column(name = "TYPE", nullable = false, unique = false, length = 40)
	@Enumerated(EnumType.STRING)
	private ClientType type;

	@JoinColumn(name = "COMPANY", nullable = true, unique = false)
	@ManyToOne
	private Company company;

	// constructor

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

	// java persistence API

	/**
	 * @return This function return a company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company Receive a company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", userName=" + getUserName() + ", password=" + getPassword() + ", type="
				+ getType() + "]";
	}

}
