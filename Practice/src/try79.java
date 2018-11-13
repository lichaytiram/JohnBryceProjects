
class try79 {
	public static void main(String args[]) {
		static_out obj1 = new static_out();
		static_out obj2 = new static_out();
		int a = 2;
		obj1.add(a, a + 1);
		obj2.add(5, a);
		System.out.println(static_out.x + " " + static_out.y);
		System.out.println(static_out.x + " " + static_out.y);
		System.out.println(static_out.x + " " + static_out.y);
		int a1 = 4;
		double a2 = a1;
		int a3 = (int) a2;
		System.out.println(a2);
		System.out.println(a3);
		float a4 = 4.2F;
		System.out.println(a4);
		double a5 = 44.22222225221113;
		System.out.println(a5);
		System.out.println("try");
		int x = 8;
		System.out.println(x++ * 3 + " " + x);
		int arr[] =  { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(arr[0]);
	}
}

class static_out {
	static int x;
	static int y;

	void add(int a, int b) {
		x = a + b;
		y = x + b;
	}
}
