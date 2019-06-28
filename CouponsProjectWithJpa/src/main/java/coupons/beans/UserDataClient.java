package coupons.beans;

import coupons.enums.ClientType;

/**
 * This class create an user data client
 * 
 * @author Lichay
 *
 */
public class UserDataClient {

	// properties

	private long id;
	private Long companyId;
	private ClientType clientType;
	private int token;

	// constructor

	/**
	 * constructor for create a show for this class
	 */
	public UserDataClient() {
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

	/**
	 * @return This function return token
	 */
	public int getToken() {
		return token;
	}

	/**
	 * @param token Receive a token
	 */
	public void setToken(int token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserDataClient [id=" + getId() + ", companyId=" + getCompanyId() + ", clientType=" + getClientType()
				+ ", token=" + getToken() + "]";
	}

}
