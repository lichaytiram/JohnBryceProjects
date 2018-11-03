package Program20;

import java.util.Arrays;

public class Zoo {
	private Animal[] AnimalArr;

	public Zoo() {
		AnimalArr = new Animal[100];
	}

	public Animal getAnimal(int index) {
		return AnimalArr[index];
	}

	public boolean addAnimal(Animal animal) {
		for (int i = 0; i < AnimalArr.length; i++) {
			if (AnimalArr[i] == null) {
				for (int j = 0; j < AnimalArr.length; j++) {
					if (AnimalArr[j] == null) {
						AnimalArr[j] = animal;
						return true;
					}
					if (animal.equals(AnimalArr[j]))
						return false;
				}
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "Zoo [AnimalArr=" + Arrays.toString(AnimalArr) + "]";
	}

}
