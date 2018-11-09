import java.util.Arrays;

public class try75 {
	public static <T> void print(T[] o) {
		System.out.println(Arrays.toString(o));
	}

	public static void main(String[] args) {

		Integer[] arr1 = { 1, 2, 3, 4, 5 };
		String[] arr2 = { "a", "b", "c" };
		print(arr1);
		print(arr2);
		Name<String> t1 = new Name<String>();
		System.out.println(t1);
		t1.s = "hd";
		System.out.println(t1);
		Name<Double> t2 = new Name<>();
		t2.s = 4.44;
		System.out.println(t2);

	}

	public static class Name<a> {
		
		a s;
		@Override
		public String toString() {
			return "name [s=" + s + "]";
		}

	}
}
