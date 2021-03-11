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


	public void createTask(String title, String employee, Date date)
	{
		Task t = new Task(); //todo have another constructor and use it insead of the next three lines
		t.setName(title);
		t.setDueDate(date); //todo fix this
		t.setEmployee(employee);

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


	public static ArrayList<Task> concatenateList(List<TaskList> bigList)
	{
		ArrayList<Task> result = new ArrayList<>();

		for (TaskList oneTaskListOfConcatenatingList: bigList)
			result.addAll(oneTaskListOfConcatenatingList.getList());

		return result;
	}

	public List<Task> getList()
	{
		return list;
	}




	//todo have a sort method that sort the list here
	public  List<Task> sortByDate()
	{
		return sortByDate(list);
	}


	public static List<Task> sortByDate(List<Task> toBesortedList)
	{
		//Collections.sort(toBesortedList );
		return toBesortedList;
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

