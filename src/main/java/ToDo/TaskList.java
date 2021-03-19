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

	public TaskList(String topicName) {
		String topic = topicName;
		list = new ArrayList<>();
	}

	public void createTask(String title, String employee, Date date)

	{
		Task t = new Task();
		list.add(t);
		System.out.println("Task added successfully.");
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

