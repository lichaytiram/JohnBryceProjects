package coupons.beans;

import coupons.enums.ClientType;

public class UserDataClient {

	// property

	private long id;
	private ClientType clientType;
	private int token;

	// constructor

	public UserDataClient() {
		super();
	}

	// getter & setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserDataClient [id=" + id + ", clientType=" + clientType + ", token=" + token + "]";
	}

}
