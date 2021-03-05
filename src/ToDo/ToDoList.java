package ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

	String topic;
	List<Task> tasks = new ArrayList<>();

	public ToDoList(String topicName) {
		topic = topicName;
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
		tasks.add(t);
		System.out.println("Task added successfully.");

	}

}

