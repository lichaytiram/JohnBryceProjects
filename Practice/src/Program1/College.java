package Program1;

public class College {
	private String name;
	private int numOfLecturers;
	private Lecturer[] allLecturers = new Lecturer[3];

	public College(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public int getNumOfLecturers() {
		return numOfLecturers;
	}

	public boolean addLecturer(Lecturer lecturer) {
		for (int i = 0; i < allLecturers.length; i++) {
			if (allLecturers[i] == null) {
				allLecturers[i] = lecturer;
				numOfLecturers++;
				return true;
			}
		}
		return false;
	}

	public Lecturer getLecturer(int value) {
		return allLecturers[value];
	}

	public void fixL() {
		Lecturer[] fixLe = new Lecturer[allLecturers.length];
		int index = 0, num = 0;
		while (fixLe[fixLe.length - 1] == null) {
			for (int i = 0; i < allLecturers.length; i++) {
				if (allLecturers[i].getNumOfTimesPenFalls() == num) {
					fixLe[index] = allLecturers[i];
					index++;
				}
			}
			num++;
		}

		for (int i = 0; i < allLecturers.length; i++) {
			allLecturers[i] = fixLe[i];
		}
	}

}
