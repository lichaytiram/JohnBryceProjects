
public class try55 {
	public static void main(String[] args) {
		System.out.println(encode("   ()(   "));
	}

	static String encode(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j < word.length(); j++) {
				if (word.charAt(i) == word.charAt(j)) {
					word = word.replace(word.charAt(i), 'A');
					break;
				}
			}
			if (word.charAt(i) != 'A')
				word = word.replace(word.charAt(i), '(');
		}
		word = word.replace('A', ')');
		return word;
	}
}