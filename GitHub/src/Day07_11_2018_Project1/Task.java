package Day07_11_2018_Project1;

import java.util.Arrays;

public class Task<T> {

	private T taskContent;
	private int taskDuration;

	public Task(T taskContent, int taskDuration) {
		this.taskContent = taskContent;
		this.taskDuration = taskDuration;
	}

	@SuppressWarnings("unchecked")
	public T getTaskContent() {
		if (taskContent instanceof Object[])
			return (T) Arrays.deepToString((Object[]) taskContent);
		return taskContent;
	}

	public void setTaskContent(T taskContent) {
		this.taskContent = taskContent;
	}

	public int getTaskDuration() {
		return taskDuration;
	}

	public void setTaskDuration(int taskDuration) {
		this.taskDuration = taskDuration;
	}

	@Override
	public String toString() {
		return "Task [taskContent=" + getTaskContent() + ", taskDuration=" + getTaskDuration() + "]";
	}

}
