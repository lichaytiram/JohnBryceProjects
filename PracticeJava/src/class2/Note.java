package class2;

public class Note {
	String title, bodyNote, date, status;

	public Note(String title, String bodyNote, String date, String status) {
		this.title = title;
		this.bodyNote = bodyNote;
		this.date = date;
		this.status = status;
	}

	public void changeStatus(String s) {
		this.status = s;
	}

	public void changeDate(String s) {
		this.date = s;
	}

	public String toString() {
		return "Note [title=" + title + ", bodyNote=" + bodyNote + ", date=" + date + ", status=" + status + "]";
	}

}
