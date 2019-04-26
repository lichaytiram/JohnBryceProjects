package coupons.beans;

public class UserData {

	// property

	private long adminId;
	private Long companyId;
	private long customerId;

	// constructor

	public UserData() {
		super();
	}

	// getter & setter

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
