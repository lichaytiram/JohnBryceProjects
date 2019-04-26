package hm2006;

public class Test {
	public static void main(String[] args) {
		MultiOne container = new MultiOne();
		SingleOne s1 = new SingleOne(11, 35);
		container.add(s1);
		s1 = new SingleOne(47, 22);
		container.add(s1);
		s1 = new SingleOne(8, 17);
		container.add(s1);
		MultiOne subContainer = new MultiOne();
		s1 = new SingleOne(53, 40);
		subContainer.add(s1);
		s1 = new SingleOne(21, 13);
		subContainer.add(s1);
		s1 = new SingleOne(39, 62);
		subContainer.add(s1);
		container.add(subContainer);
		container.print();
	}
}

class MultiOne extends Basis {
	private int count = 0;
	private Basis[] arr;

	public MultiOne() {
		this.arr = new Basis[5];
	}

	public void print() {
		for (int i = 0; i < count; i++)
			arr[i].print();
	}

	public void add(Basis b) {
		arr[count] = b;
		count++;
	}
}

class Basis {
	protected int num1;

	public Basis() {
	}

	public Basis(int n) {
		this.num1 = n;
	}

	public void print() {
		System.out.println(this.num1);
	}
}

class SingleOne extends Basis {
	protected int num2;

	SingleOne(int n1, int n2) {
		super(n1);
		this.num2 = n2;
	}

	public void print() {
		super.print();
		System.out.println(this.num2);
	}
}