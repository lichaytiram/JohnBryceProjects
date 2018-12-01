
class try80 {
	public static void main(String args[]) {
		B obj = new B();
		System.out.println(obj.i + " " + obj.j);
	}
}

class A {
	public int i;
	public int j;

	A() {
		i = 1;
		j = 2;
	}
}

class B extends A {
	int a;


}