package Program3;

public class Dog extends Mammal {

	private boolean isNatural;

	public Dog(String name, String color, int age, int mp, boolean isNatural) {
		super(name, color, age, mp);
		this.isNatural = isNatural;
	}

	public boolean getIsNatural() {
		return isNatural;
	}

	public void setIsNatural(boolean b) {
		this.isNatural = b;
	}
	
	
}
