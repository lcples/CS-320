/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package task_tracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

	/* These test allow me to see if the functions in the Task class are working properly by
	 * testing the setter methods along with the creating a valid task
	 */
    @Test
    public void testCreateTask() {
        Task task = new Task("999", "test", "testing");
        assertEquals("999", task.getId());
        assertEquals("test", task.getName());
        assertEquals("testing", task.getDescription());
    }

    @Test
    public void testSetters() {
        Task task = new Task("999", "test", "testing");
        task.setName("NewName");
        task.setDescription("Updated");
        assertEquals("NewName", task.getName());
        assertEquals("Updated", task.getDescription());
    }

    @Test
    public void testInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("toolongid123", "Name", "Description");
        });
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Testing to see if name is too long to be valid", "Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        String desc = "This description is way too long and should cause an error instead of being valid.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Name", desc);
        });
    }
    
    @Test
    public void testNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
    }

    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", null, "Description");
        });
    }

    @Test
    public void testNullDesc() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Name", null);
        });
    }

    @Test
    public void testSetNullName() {
        Task task = new Task("1", "Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testSetNullDesc() {
        Task task = new Task("1", "Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}

