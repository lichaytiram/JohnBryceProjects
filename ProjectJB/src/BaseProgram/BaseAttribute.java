package BaseProgram;

import Exception.ExceptionName;

public abstract class BaseAttribute {

	// properties
	
	private int id;

	// constructor

	
	public BaseAttribute(int id) throws ExceptionName {
		super();
		setId(id);
	}
	
	// getter & setter

	public int getId() {
		return id;
	}

	public void setId(int id) throws ExceptionName {

		if (id > 0)
			this.id = id;
		else
			throw new ExceptionName("Your Id must contain at least 1 digit!");
	}

	@Override
	public String toString() {
		return "id=" + getId();
	}

}
