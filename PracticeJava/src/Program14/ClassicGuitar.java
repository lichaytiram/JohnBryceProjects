package Program14;

public class ClassicGuitar extends Guitar {
	private String Classic;

	public ClassicGuitar(String company, int price) {
		super(company, price);
		Classic = "classic";
	}

	@Override
	public String toString() {
		return "type [" + Classic + "] ," + super.toString();
	}

}
