import ToDo.Task;
import ToDo.TaskList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest
{

    @Test
    public void testCreateTask()
    {
        TaskList l = new TaskList();
        Date d = new Date();
        l.createTask("t1", "e1", d);

        List<Task> l2 = l.getList();
        assertEquals(1, l2.size());
        assertEquals("t1", l2.size());
        assertEquals("e1",l2.size());

    }

}



