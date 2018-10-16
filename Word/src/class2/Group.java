package class2;

public class Group {
	String name;
	private Note[] arr = new Note[10];
	

	public Group(String name) {
		this.name = name;
	}

	public void addNote(Note note) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = note;
				break;
			}
		}
	}
	public void removeNote(int x) {
		arr[x]=null;
	}
	
	public Note getNote(int value) {
		return arr[value];
	}
}
