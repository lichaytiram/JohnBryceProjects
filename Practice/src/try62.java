
public class try62 {
	public static void main(String[] args) {
		System.out.println(dashatize(0122));
	}

	public static String dashatize(int num) {
		String tempS = "", S = "";
		tempS += num;
		for (int i = 0; i < tempS.length(); i++) {
			if (tempS.charAt(i) % 2 != 0)
				S += tempS.charAt(i);
			else
				for (int j = i; j < tempS.length(); j++) {
					if (tempS.charAt(j) % 2 == 0) {
						S += tempS.charAt(j);
						i = j;
					} else {
						i = j - 1;
						break;
					}
				}
			S += "-";
		}
		if (S.charAt(S.length() - 1) == '-')
			return S.substring(0, S.length() - 1);
		return S;
	}

}
