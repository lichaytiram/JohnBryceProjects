package Program14;

import java.util.ArrayList;

public class AcousticGuitar extends Guitar {
	private String Acoustic;
	public static ArrayList<AcousticGuitar> list = new ArrayList<AcousticGuitar>();

	public AcousticGuitar(String company, int price) {
		super(company, price);
		this.Acoustic = "acoustic";
	}

	public static void sellAcousticGuitar(int index) {
		if (list.size() > 5) {
			list.remove(index);
			System.out.println("sell has succeeded");
		} else
			System.out.println("no  enough AcousticGuitar on store");
	}

	public static String printAcousticGuitar() {
		return list.toString();
	}

	@Override
	public String toString() {
		return "type [" + Acoustic + "] ," + super.toString();
	}

}
