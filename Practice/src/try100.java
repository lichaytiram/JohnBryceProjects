
public class try100 {
	public static void main(String[] args) {

		System.out.println(makeComplement("ATTGC"));

	}

	public static String makeComplement(String dna) {
		String temp = "";
		for (int i = 0; i < dna.length(); i++) {

			switch (dna.charAt(i)) {
			case 'A':
				temp += 'T';
				break;
			case 'T':
				temp += 'A';
				break;

			case 'C':
				temp += 'G';
				break;
			case 'G':
				temp += 'C';
				break;
			}
		}
		return temp;

	}
}
