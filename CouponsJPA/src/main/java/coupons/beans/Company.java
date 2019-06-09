package coupons.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class create a company
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "companies")
public class Company {

	// property

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true, length = 255) // UNSIGNED
	private long id;
	@Column(name = "NAME", nullable = false, unique = true, length = 15)
	private String name;
	@Column(name = "PHONE_NUMBER", nullable = false, unique = false, length = 10)
	private String phoneNumber;
	@Column(name = "EMAIL", nullable = false, unique = false, length = 25)
	private String email;
	@JoinColumn(name = "COUPONS")
	@JsonIgnore
	@OneToMany(mappedBy = "")
	private List<Coupon> coupons;
	// constructor

	/**
	 * Constructor for create a show for this class
	 * 
	 * @param id          Receive an id
	 * @param name        Receive a name for company
	 * @param phoneNumber Receive a phone number
	 * @param email       Receive an email
	 */
	public Company(long id, String name, String phoneNumber, String email) {
		this(name, phoneNumber, email);
		this.id = id;
	}

	/**
	 * Constructor for create a show for this class
	 * 
	 * @param name        Receive a name for company
	 * @param phoneNumber Receive a phone number
	 * @param email       Receive an email
	 */
	public Company(String name, String phoneNumber, String email) {
		this();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;

	}

	/**
	 * Constructor for create a show for this class
	 */
	public Company() {
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
	 * @return This function return a name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Receive a name
	 */
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Company [id=" + getId() + ", name=" + getName() + ", phoneNumber=" + getPhoneNumber() + ", email="
				+ getEmail() + "]";
	}

}