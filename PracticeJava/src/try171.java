
public class try171 {
	public static void main(String[] args) {

		System.out.println(isPalindrome(new int[] { 1, 2, 1 }, 0));

	}

	public static boolean isPalindrome(int[] arr, int index) {

		if (arr == null || arr.length < 1 || index == arr.length)
			return true;

		if (arr[index] != arr[arr.length - 1 - index])
			return false;

		return isPalindrome(arr, ++index);

	}

}
