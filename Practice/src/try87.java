import java.util.ArrayList;

public class try87 {
	public static void main(String[] args) {

		ArrayList<Integer> listbinary = new ArrayList<Integer>();
		listbinary.add(1);
		listbinary.add(2);
		listbinary.add(5);
		System.out.println(ConvertBinaryArrayToInt(listbinary));
	}

	public static int ConvertBinaryArrayToInt(ArrayList<Integer> binary) {
		int inti = 0;
		for (int i = 0; i < binary.size(); i++) {
			inti *= 10;
			inti += binary.get(i);

		}
		String x = Integer.toBinaryString(inti);
		return Integer.parseInt(x);
	}
}
