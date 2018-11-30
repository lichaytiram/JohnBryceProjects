package Program34;

public class Bird<T> extends Animal {

	private T high;

	public Bird(String name, int age, T high) {
		super(name, age);
		setHigh(high);
	}

	public T getHigh() {
		return high;
	}

	public void setHigh(T high) {
		this.high = high;
	}

	@Override
	public String toString() {
		return super.toString() + "Bird [High()=" + getHigh() + "]\n";
	}

}
