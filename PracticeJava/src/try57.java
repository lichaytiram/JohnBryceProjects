
public class try57 {
	public static void main(String[] args) {
		System.out.println(max(1847, 0));
	}

	public static int max(int x, int index) {
		if (x % 10 > index)
			index = x % 10;
		if(x==0)
			return index;

		return max(x / 10, index);

	}
}
