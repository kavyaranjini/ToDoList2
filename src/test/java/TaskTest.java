import ToDo.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest
{
    @Test
    public void testGetAndSetName()
    {
        Task task = new Task();
        task.setName("t1");
        assertEquals("t1", task.getName("e1"));

        task.getName("e1");
    }
}



