package Program48;

public class DataStructure<T> {

	private T info;
	private DataStructure<T> next;

	public DataStructure() {
		super();
	}

	public void add(T info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "DataStructure [info=" + info + ", next=" + next + "]";
	}

}
