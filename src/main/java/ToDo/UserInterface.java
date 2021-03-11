package ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    private TopicMapWithList map = new TopicMapWithList();


    public void run()
    {
        boolean quit = false; // todo count done and undone elments
        String mainMenu = "" +
                "1. Add a topic\n" +
                "2. Handling a specific Topic List \n" +  // add and edit and display by specific topic
                "3. Display\n\n" +  // diplay all topics, display by date for all task
                "4. Quit\n\n";
        while (!quit)
        {

            System.out.println(mainMenu);
            int choice = validateInt(1, 7);  // todo

            switch (choice) {
                case 1:
                    String topic = userInput("Please enter topic name"); //done
                    map.addTopic(topic);
                    break;
                case 2:
                    handleSpecigicTopicList();
                    break;
                case 3:
                    display();  //done
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

    private void display()
    {

        int choice = 1; // userInput and scanner
       // "3. Display\n\n" +  // diplay all topics, display by date for all task
        switch (choice)
        {
            case 1 :
                System.out.println(map.printTopics());
                break;
            case 2:
                map.convertMapToOneList();
                //sort //
                // print result
                System.out.println();
        }

    }


    public void handleSpecigicTopicList()
    {

        String topic = chooseTopic();
        TaskList topicList = map.getTopicListFromMap(topic);
        if(topicList == null)
            return;


        // else
        String mainMenu = "topic: " + topic + ": \n" +
                "1. Add a new Task\n" +
                "2. show all tasks in this topic \n" +
                "3. Edit a task (mark as Done, or update title, ...)\n" +
                "4. remove task \n" +
                "5. return to the main menu\n\n";

        System.out.println(mainMenu);
        int choice = validateInt(1, 5);  // todo

        switch (choice) {
            case 1:
                addNewTask(topicList);
                break;
            case 2:
                showAllTask(topicList); //you may need scanner just o decide what type of chossing
                break;
            case 3:
                editTask(topicList);
                break;
            case 4:
                removeTask(topicList);
                break;
            default:
                System.out.println("you endfgdh");
                break;


        }


    }

    private void removeTask(TaskList topicList) {

        /*
        1. print the list to user (sout(topicList))
        2. ask the user to choose an index
        3. topicList.remove(index) // in the topicList class has:  public void remove(int index)
         */

    }


    private void showAllTask(TaskList taskList)
    {
        /*
        1. ask the use if he just want to dispaly or sort by date, title, ....
        2. switch {
            case 1:
                sout(taskList)
            case 2:
                 Array<Task> l = taskList.sortByDate()
                 sout(l)
             case 3:
                    .....

        }

         */
    }



    private void editTask(TaskList taskList)
    {
        // may be have a switch that ask what he want to update exactly ...
    }

    private void addNewTask(TaskList topicList)
    {
        System.out.println("Please enter task name");
        String title = scanner.nextLine();
        System.out.println("Please enter employee name");
        String employee = scanner.nextLine();
        System.out.println("Please enter due date");

        // validate date method:
        System.out.println("Please enter your date in the format dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // until here..........

        topicList.createTask(title, employee, date);



    }


    public String chooseTopic()
    {

        System.out.println(map.printTopics());
        System.out.println("Please select a topic (not the index)");

        return scanner.nextLine();

    }


    private  String userInput(String printStatement)
    {
        System.out.println(printStatement);
        return scanner.nextLine();
    }


    public int validateInt(int min, int max)
    {
        return Integer.parseInt(scanner.nextLine()); //todo extend this
    }






}
