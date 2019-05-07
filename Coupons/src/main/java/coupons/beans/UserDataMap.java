package coupons.beans;

import coupons.enums.ClientType;

public class UserDataMap {

	// property

	private long id;
	private Long companyId;
	private ClientType clientType;

	// constructor

	public UserDataMap(long id, Long companyId, ClientType clientType) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.clientType = clientType;
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

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "UserDataMap [id=" + id + ", companyId=" + companyId + ", clientType=" + clientType + "]";
	}

}
