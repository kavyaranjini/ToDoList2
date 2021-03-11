package ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskList
{


	List<Task> list;

	public TaskList()
	{
		list = new ArrayList<>();
	}

	//todo to be deleted
	public TaskList(String topicName) {
		String topic = topicName;
		list = new ArrayList<>();
	}


	public void createTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter task name");
		String name = sc.nextLine();
		System.out.println("Please enter employee name");
		String empname = sc.nextLine();
		System.out.println("Please enter due date");
		System.out.println("Please enter your date in the format dd/MM/yyyy");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Task t = new Task();
		t.setName(name);
		t.setDueDate(d);
		t.setEmployee(empname);
		list.add(t);
		System.out.println("Task added successfully.");

	}






	private Task getTaskData()
	{
		// todo maybe have a return nul if list is empty
		if (list.isEmpty())
		{
			System.out.println("There are no existing task. Please Create Task");
			return null;
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println(toString()); //todo nour come back please
		System.out.println("Please select from below Tasks");
		int index = Integer.parseInt(scanner.nextLine()); //todo nour come back
		return list.get(index);

	}

	public void assignUser()
	{
		Task selectedTask = getTaskData();
		if (selectedTask != null) {
			String asignee = "nour"; //userInput("Please enter Asignee name"); //todo nour come back
			selectedTask.setEmployee(asignee);
		}
	}

	public void assignDate()
	{

		Task selectedTask = getTaskData();
		if (selectedTask != null) {
			Scanner dueDateInput = new Scanner(System.in);
			System.out.println("Please enter due date in dd/MM/yyyy");
			Date dueDate = new Date(); //new SimpleDateFormat("dd/MM/yyyy").parse(dueDateInput.nextLine()); //todo validate method
			selectedTask.setDueDate(dueDate);
		}


	}














	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			builder.append(i + "." + list.get(i) + "\n") ;
		}
		return builder.toString();
	}



}

