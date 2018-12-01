package Program14;

public class ElectricGuitar extends Guitar {
	private String Electric;

	public ElectricGuitar(String company, int price) {
		super(company, price);
		this.Electric = "electric";
	}

	@Override
	public String toString() {
		return "type [" + Electric + "] ," + super.toString();
	}

}
