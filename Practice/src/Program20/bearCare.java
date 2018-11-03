package Program20;

public class bearCare extends Animal {
	private String sign;

	public bearCare(String name, String sign) {
		super(name, true, 2);
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return super.toString() + "\nbearCare [sign=" + sign + "]\n";
	}

}
