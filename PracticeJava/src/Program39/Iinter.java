package Program39;

public interface Iinter {

	default boolean try1(Object o) {
		return true;
	}

	static void try2() {
		System.out.println("inside interface");
	}

}
