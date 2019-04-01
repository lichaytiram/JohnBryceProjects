package beans;

import java.util.Date;

public class Purchase {

	// property

	private long id;
	private long customerId;
	private long couponId;
	private int amount;
	private Date date;

	// constructor

	public Purchase(long id, long customerId, long couponId, int amount, Date date) {
		this(customerId, couponId, amount, date);
		this.id = id;

	}

	public Purchase(long customerId, long couponId, int amount, Date date) {
		this();
		this.customerId = customerId;
		this.couponId = couponId;
		this.amount = amount;
		this.date = date;

	}

	public Purchase() {
		super();
	}

	// getter & setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + getId() + ", customerId=" + getCustomerId() + ", couponId=" + getCouponId()
				+ ", amount=" + getAmount() + ", date=" + getDate() + "]";
	}

}
