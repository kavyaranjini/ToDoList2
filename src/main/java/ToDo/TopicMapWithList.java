package ToDo;

import java.text.ParseException;
import java.util.*;

public class TopicMapWithList {

    private Map<String, TaskList> map = new HashMap();

    public void run()
    {
        boolean quit = false;
        String mainMenu = "" + "1. Add a topic\n" + "2. Select a topic\n" + "3. Assign Task\n" + "4. Create a task \n"
                + "5. Assign Due Date  \n" + "6. Display\n\n" + "7. Quit\n\n";
        while (!quit) {

            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            int choice = input.nextInt();  // todo

            switch (choice) {
                case 1:
                    addTopic(); //done
                    break;
                case 3:
                    assignTask(); //done
                    break;
                case 4:
                    createTask();  //done
                    break;
                case 5:
                    assignDueDate(); //done
                    break;
                case 6:
                    displayToDoList(); //done
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

    private void displayToDoList()
    {

        Set<String> topicList = map.keySet();

        for (String topic : topicList) {
            System.out.println("=========================" + topic + "========================");
            System.out.println(map.get(topic));
            System.out.println("--------------------");
        }


//        for (int i = 0; i < topicTodoLIst.size(); i++)
//        {
//            Iterator<ToDo.Task> taskItr = topicTodoLIst.get(i).tasks.iterator();
//            System.out.println("=========================" + topicTodoLIst.get(i).topic + "========================");
//            while (taskItr.hasNext()) {
//                ToDo.Task taskData = taskItr.next();
//                System.out.println(taskData.toString());
//                System.out.println("===============================================================");
//            }
//            System.out.println("�����������������������������������������������������������\n");
//        }
    }


    private  void createTask()
    {
        TaskList list = selectTopic();
        if(list == null)
            return;

        list.createTask();
    }

    private  void assignDueDate()
    {

        TaskList list = selectTopic();
        if(list == null)
            return;

        list.assignDate();

    }

    private  String userInput(String printstatement) {
        Scanner asigneeInput = new Scanner(System.in);
        System.out.println(printstatement);
        String userentervalue = asigneeInput.nextLine();
        return userentervalue;
    }

    private  void assignTask()
    {
        TaskList list = selectTopic();
        if(list == null)
            return;

        list.assignUser();

    }

    public TaskList selectTopic()
    {
        String topic = selectTopicHelper();
        if(topic == null) //todo print error message or something to th euser
            return null;

        return map.get(topic);
    }



    //todo may delete this
    private String selectTopicHelper() {
        if (map.isEmpty()) {
            System.out.println("There no topics added. Please add topic");
            return null;
        }
        else
        {
            Scanner topicInput = new Scanner(System.in);
            System.out.println("Please select from below topics");

            Set<String> topicList = map.keySet();
            int counter = 0;
            for (String topic : topicList) {
                System.out.println(counter + "." + topic);
                counter++;
            }
            return topicInput.nextLine(); //todo have a globlal vaiable or not
        }
    }

    private void addTopic()
    {
        String topic = userInput("Please enter topic name");
        if(map.containsKey(topic))
        {
            System.out.println("Topic already exists. Try again");
            return;
        }
        map.put(topic, new TaskList());



//        for (int i = 0; i < topicTodoLIst.size(); i++) {
//            if (topicTodoLIst.get(i).topic.equals(name)) {
//                System.out.println("Topic already exists. Try again");
//                break;
//            }
//        }
//        topicTodoLIst.add(new ToDoList(topic));
        System.out.println("Topic added successfully");
//        System.out.println("topicTodoLIst " + topicTodoLIst.get(0).topic);

    }


}
