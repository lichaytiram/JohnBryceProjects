package coupons.beans;

import coupons.enums.ClientType;

public class UserDataClient {

	// property

	private ClientType clientType;
	private int token;

	// constructor

	public UserDataClient() {
		super();
	}

	// getter & setter

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

}
