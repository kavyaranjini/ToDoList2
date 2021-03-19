package ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    private TopicMap map = new TopicMap();

    /**
     *In this method user can add a subject after that he can choose topic.
     */

    public void run()
    {
        boolean quit = false; // todo count done and undone elements
        String mainMenu = "" +
                "1. Add a topic\n" +
                "2. Choose a Topic from the List \n" +
                "3. Display\n\n" +
                "4. Quit\n\n";
        while (!quit)
        {
            System.out.println(mainMenu);
            int choice = validateInt(1, 4);  // todo

            switch (choice) {
                case 1:
                    String topic = userInput("Please enter the topic name");
                    map.addTopic(topic);
                    break;
                case 2:
                    chooseSpecificTopicList();
                    break;
                case 3:
                    map.displayTheEnterData();
                    break;
                case 4:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry try again");
            }
        }
        System.exit(0);

    }

    /**In this method user can choose from the following list.
     *The user can add new task or he can edit the task
     */
    public void chooseSpecificTopicList()
    {
        String topic = chooseTopic();
        TaskList topicList = map.getTopicListFromMap(topic);
        if(topicList == null)
            return;

        //else
        String mainMenu = "topic: " + topic + ": \n" +
                "1. Add a new Task\n" +
                "2. show the added topic \n" +
                "3. Edit a task (mark as Done, or update title, ...)\n" +
                "4. Return to the main menu\n\n";

        System.out.println(mainMenu);
        int choice = validateInt(1, 4);  // todo

        switch (choice) {
            case 1:
                addNewTask(topicList);
                break;
            case 2:
                showAllTask(topicList);
                break;
            case 3:
                editTask(topicList);

                default:
                System.out.println("End, You can start again");
                break;
        }
    }

    /**
     *this method will show the task that what student can do.
     * @param topicList
     */
    private void showAllTask(TaskList topicList) {
        System.out.println("Select \n 1.coding \n 2.Reading");
        if (topicList == null)
            return;
    }

    /**
     * In this method user can edit the task like remove or update.
     * @param topiclist
     */
    private void editTask(TaskList topiclist) {
        if(topiclist == null)
            return;
        System.out.println(" Remove a task ");
    }

    /**
     * In this method the user can add a topic.
     * after that the user can assign the topic to the student.
     * and also the user can assign a due date also.
     * validate method
     * @param topicList
     */
    public void addNewTask(TaskList topicList)
    {
        System.out.println("Please add a task from the added Subject");
        String title = scanner.nextLine();
        System.out.println("Please assign a Student to do the task");
        String student = scanner.nextLine();
        System.out.println("Please enter due date");

        System.out.println("Please enter your date in the format dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        topicList.createTask(title, student, date);
    }

    /**
     * Here the user can select the topic by choosing the subject which is available.
     * note:not the index
     * @return
     */

    public String chooseTopic()
    {
        System.out.println(map.printTopics());
        System.out.println("Please select the Subject (not the index)");

        return scanner.nextLine();
    }

    private  String userInput(String printStatement)

    {
        System.out.println(printStatement);
        return scanner.nextLine();
    }


    public int validateInt(int min, int max)
    {
        return Integer.parseInt(scanner.nextLine());
    }
}
