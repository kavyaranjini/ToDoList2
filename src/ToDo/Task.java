package ToDo;

import java.util.Date;

public class Task {

	private String name;
	private Date deadLine;
	private String employee;
	private boolean isDone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public void setDueDate(Date d) {
		this.deadLine = d;
	}

	public void setEmployee(String empname) {
		this.employee = empname;
	}
	

	public String geTaskDetails() {
		return "Task name = " + name + " , employee = " + employee + " , deadline = " + deadLine + ", Done = " + isDone;
	}

}

