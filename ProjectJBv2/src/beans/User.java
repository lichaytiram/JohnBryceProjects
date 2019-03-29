package beans;

import enums.ClientType;
import exception.ApplicationException;

public class User {

	// properties

	private long id;
	private String userName;
	private String password;
	private ClientType type;
	private Long companyId;

	// constructor

	public User(long id, String userName, String password, ClientType type, Long companyId)
			throws ApplicationException {
		this(userName, password, type, companyId);
		this.id = id;
	}

	public User(String userName, String password, ClientType type, Long companyId) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.companyId = companyId;
	}

	public User() {
	}

	// getter & setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", userName=" + getUserName() + ", password=" + getPassword() + ", type="
				+ getType() + ", companyId=" + getCompanyId() + "]";
	}

}
