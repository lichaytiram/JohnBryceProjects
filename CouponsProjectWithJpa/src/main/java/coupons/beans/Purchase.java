package coupons.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class create a purchase
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

	// properties

	private static final long serialVersionUID = 1727970319277632036L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true, columnDefinition = "BIGINT(20) UNSIGNED")
	private long id;

	@Column(name = "AMOUNT", nullable = false, unique = false, columnDefinition = "INT(11) UNSIGNED")
	private int amount;

	@Column(name = "DATE", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	@JoinColumn(name = "CUSTOMER", nullable = false, unique = false)
	@ManyToOne
	private Customer customer;

	@JoinColumn(name = "COUPON", nullable = false, unique = false)
	@ManyToOne
	private Coupon coupon;

	// constructor

	/**
	 * constructor for create a show for this class
	 */
	public Purchase() {
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
	 * @return This function return an amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount Receive an amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return This function return a date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date Receive a date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	// java persistence API

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + getId() + ", amount=" + getAmount() + ", date=" + getDate() + "]";
	}

}
