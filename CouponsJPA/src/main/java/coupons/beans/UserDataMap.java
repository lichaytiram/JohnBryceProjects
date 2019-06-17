package coupons.beans;

import coupons.enums.ClientType;

/**
 * This class create an user data map
 * 
 * @author Lichay
 *
 */
public class UserDataMap {

	// properties

	private long id;
	private Long companyId;
	private ClientType clientType;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id         Receive an id
	 * @param companyId  Receive a company id
	 * @param clientType Receive a client type
	 */
	public UserDataMap(long id, Long companyId, ClientType clientType) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.clientType = clientType;
	}

	/**
	 * constructor for create a show for this class
	 */
	public UserDataMap() {
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
	 * @return This function return a company id
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId Receive a company id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return This function return a client type
	 */
	public ClientType getClientType() {
		return clientType;
	}

	/**
	 * @param clientType Receive a client type
	 */
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "UserDataMap [id=" + getId() + ", companyId=" + getCompanyId() + ", clientType=" + getClientType() + "]";
	}

}
