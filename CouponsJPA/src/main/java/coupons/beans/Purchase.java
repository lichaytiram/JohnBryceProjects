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
	@Column(name = "CUSTOMER_ID", nullable = false, unique = false, columnDefinition = "BIGINT(20) UNSIGNED")
	private long customerId;
	@Column(name = "COUPON_ID", nullable = false, unique = false, columnDefinition = "BIGINT(20) UNSIGNED")
	private long couponId;
	@Column(name = "AMOUNT", nullable = false, unique = false, columnDefinition = "INT(11) UNSIGNED")
	private int amount;
	@Column(name = "DATE", nullable = false, unique = false)
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
	 * 
	 * @param id         Receive an id
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @param amount     Receive an amount
	 * @param date       Receive a date
	 */
	public Purchase(long id, long customerId, long couponId, int amount, Date date) {
		this();
		this.id = id;
		this.customerId = customerId;
		this.couponId = couponId;
		this.amount = amount;
		this.date = date;

	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @param amount     Receive an amount
	 */
	public Purchase(long customerId, long couponId, int amount) {
		this();
		this.customerId = customerId;
		this.couponId = couponId;
		this.amount = amount;
		this.date = new Date();

	}

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
	 * @return This function return a customer id
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId Receive a customer id
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return This function return a coupon id
	 */
	public long getCouponId() {
		return couponId;
	}

	/**
	 * @param couponId Receive a coupon id
	 */
	public void setCouponId(long couponId) {
		this.couponId = couponId;
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
		return "Purchase [id=" + getId() + ", customerId=" + getCustomerId() + ", couponId=" + getCouponId()
				+ ", amount=" + getAmount() + ", date=" + getDate() + "]";
	}

}
