package coupons.beans;

public class UserDataMap {

	// property

	private long id;
	private Long companyId;

	// constructor

	public UserDataMap(long id, Long companyId) {
		this();
		this.id = id;
		this.companyId = companyId;
	}

	public UserDataMap() {
		super();
	}

	// getter & setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
