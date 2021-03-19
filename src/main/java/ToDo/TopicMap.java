package ToDo;

import java.text.ParseException;
import java.util.*;

public class TopicMap {

    private Map<String, TaskList> map = new HashMap();

    /**
     * This method will display everything what the user has selected
     */
    public void displayTheEnterData()
    {
        Set<String> topicList = map.keySet();
        for (String topic : topicList) {
            System.out.println("====*******====="  + topic + " =====**************=====");
            System.out.println(map.get(topic));
            System.out.println("=====********========= " + "  ======***********=========");
        }
    }

        /**
         *This method is getting the Topiclist from map
         * @param
         * @return
         */
        public TaskList getTopicListFromMap (String topic)
        {
            return map.get(topic);
        }

        public void addTopic (String topic)
        {
            if (map.containsKey(topic)) {
                System.out.println("Topic already exists. Try again");
                return;
            }
            map.put(topic, new TaskList());

            System.out.println("Topic added successfully");
        }

        /**
         *This method will tell if no topics are available then add a topic
         * @return
         */
        public String printTopics ()
        {
            if (map.isEmpty()) {
                return "There no topics added. Please add topic";
            } else {
                StringBuilder builder = new StringBuilder();

                Set<String> topicList = map.keySet();
                int counter = 0;
                for (String topic : topicList) {
                    builder.append(counter + "." + topic + "\n");
                    counter++;
                }
                return builder.toString();
            }
        }

        public ArrayList<Task> convertMapToOneList ()
        {
            Set<String> keySet = map.keySet();
            List<TaskList> listInit = new ArrayList<>(keySet.size());

            for (String topic : keySet) {
                listInit.add(map.get(topic));
            }

            ArrayList<Task> result = TaskList.concatenateList(listInit);
            return result;
        }
}
