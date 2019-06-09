package coupons.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class create a customer
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "customers")
public class Customer {

	// property

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true, length = 255) // UNSIGNED
	private long id;
	@Column(name = "FIRST_NAME", nullable = false, unique = false, length = 20)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = true, unique = false, length = 20)
	private String lastName;
	@Column(name = "PHONE_NUMBER", nullable = false, unique = false, length = 10)
	private String phoneNumber;
	@Column(name = "EMAIL", nullable = false, unique = false, length = 25)
	private String email;
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
	@OneToOne
	private User user;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id          Receive an id
	 * @param firstName   Receive a first name
	 * @param lastName    Receive a last name
	 * @param phoneNumber Receive a phone number
	 * @param email       Receive an email
	 */

	public Customer(long id, String firstName, String lastName, String phoneNumber, String email) {
		this(firstName, lastName, phoneNumber, email);
		this.id = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param firstName   Receive a first name
	 * @param lastName    Receive a last name
	 * @param phoneNumber Receive a phone number
	 * @param email       Receive an email
	 */
	public Customer(String firstName, String lastName, String phoneNumber, String email) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * constructor for create a show for this class
	 */
	public Customer() {
		super();

	}

	// getter & setter

	/**
	 * @return This function return an id
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
	 * @return This function return a first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName Receive a first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return This function get a last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName Receive a last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return This function return a phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber Receive a phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return This function return an email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email Receive an email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return This function return an user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user Receive an user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param id Receive an id
	 */
	public void setUserId(long id) {
		this.user.setId(id);
	}

	@Override
	public String toString() {
		return "Customer [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ ", phoneNumber=" + getPhoneNumber() + ", email=" + getEmail() + "]";
	}

}
