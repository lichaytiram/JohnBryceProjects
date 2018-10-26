package Program15;

public class Program {
	public static void main(String[] args) {

		Shape[] sArr = new Shape[5];
		sArr[0] = new Rectangle(3, "red", 4, 4);
		sArr[1] = new Triangle(3, "red", 2, 3);
		sArr[2] = new Moon(3, "black", 3, 4);
		sArr[3] = new Circle(3, "blue", 4);
		sArr[4] = new Ellipse(3, "green", 3, 4);
		int sumvertices = 0;
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i] instanceof Rectangle)
				sumvertices += ((Rectangle) sArr[i]).vertices();
			if (sArr[i] instanceof Triangle)
				sumvertices += ((Triangle) sArr[i]).vertices();
			if (sArr[i] instanceof Moon)
				sumvertices += ((Moon) sArr[i]).vertices();
		}
		System.out.println("The sum of vertices is " + sumvertices);
		System.out.println(((Triangle) sArr[1]).shapeWithVertices(sArr[0], sArr[1]));
		System.out.println(((Moon) sArr[2]).roll());
		System.out.println(((Circle) sArr[3]).roll());
		System.out.println(((Ellipse) sArr[4]).roll());

	}
}
