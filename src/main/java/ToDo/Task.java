package ToDo;

import java.util.Date;

/**
 * This class is all about the task
 * like setName,setDue date ,boolean
 */
public class Task {

	private String name;
	private Date deadLine;
	private String employee;
	private boolean isDone;

	public Task()
	{
	}

	public String getName(String e1) {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Task name = " + name + " , Student name = " + employee + " , deadline = " + deadLine + ", Done = " + isDone;
	}

  }

