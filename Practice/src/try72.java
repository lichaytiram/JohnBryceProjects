import java.util.Arrays;

public class try72 {

	public static void main(String[] args) {
		int[] arr1 = new int[4];
		int[] ar1 = { 1, 2, 5 };
		int[] ar2 = { 1, 2 };

		ar1 = Arrays.copyOf(ar2, ar2.length);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));
		String s1 = "abcde";
		String s2 = "cd";
		System.out.println(s2.concat(s1));
		char[] c1 = { '2', 'd', '5' };
		System.out.println(Arrays.toString(c1));
		String sx = String.copyValueOf(c1);
		System.out.println(sx);
		char[] d = sx.toCharArray();
		System.out.println(Arrays.toString(d));
		System.out.println('a' - 'A');
		String empty = "";
		System.out.println(empty.isEmpty());
		char v1 = '2';
		int v3 = 2;
		String v2 = String.valueOf(v1);
		v2 += "hi1";
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v3);
		System.out.println();
		System.out.println(v2.intern());
		v2 += "X";
		System.out.println(v2);
		String x = "abcdcdeg";
		System.out.println(x.indexOf("cdc"));
		System.out.println(x.indexOf(3));
		System.out.println(x);
		System.out.println(x.indexOf('c'));
		System.out.println(x);
		System.out.println(x.startsWith("bcdcde", 2));

	}

}
