package beans;

import enums.ClientType;
import exception.ApplicationException;

public class User {

	private long id;
	private String userName;
	private String password;
	private Long companyId;
	private ClientType type;

	public User(long id, String userName, String password, Long companyId, ClientType type)
			throws ApplicationException {
		this(userName, password, companyId, type);
		setId(id);
	}

	public User(String userName, String password, Long companyId, ClientType type) {
		super();
		this.userName = userName;
		this.password = password;
		this.companyId = companyId;
		this.type = type;
	}

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) throws ApplicationException {

		if (id > 0)
			this.id = id;
		else
			throw new ApplicationException("Your Id must contain at least 1 digit and be bigger then 0");
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}

}
