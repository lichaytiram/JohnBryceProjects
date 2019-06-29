package coupons.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class create a company
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "companies")
@JsonIgnoreProperties({ "coupons", "users" })
public class Company implements Serializable {

	// properties

	private static final long serialVersionUID = 7779786765840219658L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true, columnDefinition = "BIGINT(20) UNSIGNED")
	private long id;

	@Column(name = "NAME", nullable = false, unique = true, length = 15)
	private String name;

	@Column(name = "PHONE_NUMBER", nullable = false, unique = false, length = 10)
	private String phoneNumber;

	@Column(name = "EMAIL", nullable = false, unique = false, length = 25)
	private String email;

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Coupon> coupons;

	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<User> users;

	// constructor

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

	// java persistence API

	/**
	 * @return This function return list of coupons
	 */
	public List<Coupon> getCoupons() {
		return coupons;
	}

	/**
	 * @param coupons Receive list of coupons
	 */
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	/**
	 * @return This function return list of users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users Receive list of users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Company [id=" + getId() + ", name=" + getName() + ", phoneNumber=" + getPhoneNumber() + ", email="
				+ getEmail() + "]";
	}

}