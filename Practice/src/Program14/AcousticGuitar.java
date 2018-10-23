package Program14;

import java.util.ArrayList;

public class AcousticGuitar extends Guitar {
	private String Acoustic;
	private ArrayList<AcousticGuitar> list = new ArrayList<AcousticGuitar>();

	public AcousticGuitar(String company, int price) {
		super(company, price);
		this.Acoustic = "acoustic";
		list.add(new AcousticGuitar(company, price));
	}

	// public ArrayList<AcousticGuitar> getArrayList() {

//	}

	@Override
	public String toString() {
		return "type [" + Acoustic + "] ," + super.toString();
	}

}
