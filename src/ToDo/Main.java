package ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {


    //private static List<Class<? extends ToDoList>> topicTodoLIst = new ArrayList<Class<? extends ToDoList>>();
    private static List<ToDo.ToDoList> topicTodoLIst = new ArrayList<ToDo.ToDoList>();

    private static String selectedTopic;

    public static void main(String[] args) throws ParseException {

        //The run function will start the menu on the output screen
        run();
    }

    //create your run function with the following menu items
    private static void run() throws ParseException {
        boolean quit = false;
        String mainMenu = "" + "1. Add a topic\n" + "2. Select a topic\n" + "3. Assign Task\n" + "4. Assign Due Date\n"
                + "5. Create a task \n" + "6. Display\n\n" + "7. Quit\n\n";
        while (!quit) {

            //The Scanner will input the user's choice
            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            int choice = input.nextInt();


            switch (choice) {
                case 1:
                    addTopic();
                    break;
                case 2:
                    selectTopic();
                    break;
                case 3:
                   assignTask();
                    break;
                case 4:
                    assignDueDate();
                    break;
                case 5:
                    createTask();
                    break;
                case 6:
                    displayToDoList();
                    break;
                case 7:
                    quit = true;
                    break;


                default:
                    System.out.println("Invalid entry try again");

            }
        }
        System.exit(0);

    }

    private static void displayToDoList() {
        for (int i = 0; i < topicTodoLIst.size(); i++) {
            Iterator<ToDo.Task> taskItr = topicTodoLIst.get(i).tasks.iterator();
            System.out.println("========================="+ topicTodoLIst.get(i).topic+ "========================");
            while (taskItr.hasNext()) {
                ToDo.Task taskData = taskItr.next();
                System.out.println(taskData.geTaskDetails());
                System.out.println("===============================================================");
            }
            System.out.println("�����������������������������������������������������������\n");
        }
    }


    private static void createTask() {
        selectTopic();
        topicTodoLIst.get(Integer.parseInt(selectedTopic)).createTask();
    }

    private static void assignDueDate() throws ParseException {
        String selectedTask = getTaskData();
        Scanner dueDateInput = new Scanner(System.in);
        System.out.println("Please enter due date in dd/MM/yyyy");
        Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDateInput.nextLine());
        topicTodoLIst.get(Integer.parseInt(selectedTopic)).tasks.get(Integer.parseInt(selectedTask)).setDueDate(dueDate);
    }
    private static String userInput(String printstatement)
{
    Scanner asigneeInput = new Scanner(System.in);
    System.out.println(printstatement);
    String asignee = asigneeInput.nextLine();
    return asignee;
}
    private static void assignTask() {
      String selectedTask = getTaskData();
      if (selectedTask != null) {
         // Scanner asigneeInput = new Scanner(System.in);
          //System.out.println("Please enter Asignee name");

          String asignee = userInput("Please enter Asignee name");
          topicTodoLIst.get(Integer.parseInt(selectedTopic)).tasks.get(Integer.parseInt(selectedTask)).setEmployee(asignee);
      }
    }

    private static void selectTopic() {
        if (topicTodoLIst.isEmpty()) {
            System.out.println("There no topics added. Please add topic");
        } else {
            Scanner topicInput = new Scanner(System.in);
            System.out.println("Please select from below topics");
            for (int i = 0; i < topicTodoLIst.size(); i++) {
                System.out.println(i + "."+ topicTodoLIst.get(i).topic);
           }
           selectedTopic = topicInput.nextLine();
 }


    }


    private static void addTopic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter topic name");
        String name = sc.nextLine();

        for (int i = 0; i < topicTodoLIst.size(); i++) {
            if (topicTodoLIst.get(i).topic.equals(name)) {
                System.out.println("Topic already exists. Try again");
                return;
            }
        }

        topicTodoLIst.add(new ToDo.ToDoList(name));
        System.out.println("Topic added successfully");
        System.out.println("topicTodoLIst "+ topicTodoLIst.get(0).topic);

    }

    private static String getTaskData() {
        String selectedTask = null;
        if(selectedTopic == null) {
            System.out.println("Please select any topic");
        } else {
            if (topicTodoLIst.get(Integer.parseInt(selectedTopic)).tasks.isEmpty()) {
                System.out.println("There are no existing task. Please Create Task");
            } else {
                Scanner taskInput = new Scanner(System.in);
                System.out.println("Please select from below Tasks");
                Iterator<ToDo.Task> taskItr = topicTodoLIst.get(Integer.parseInt(selectedTopic)).tasks.iterator();
                int i = 0;
                while (taskItr.hasNext()) {
                    ToDo.Task taskData = taskItr.next();
                    System.out.println(i + "."+taskData.getName());
                    i++;
                }
                selectedTask = taskInput.nextLine();
            }
        }
        return selectedTask;
    }

}
