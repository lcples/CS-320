/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package task_tracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
	
	// These test make sure the methods in the TaskService class that call on the Task class work properly
    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        assertTrue(service.addTask("1", "Test", "Do this"));
        assertEquals("Test", service.getTaskByID("1").getName());
        assertEquals("Do this", service.getTaskByID("1").getDescription());
        assertFalse(service.addTask("1", "Again", "Duplicate")); // Tries to add a duplicate ID
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Delete", "Delete this task");
        assertTrue(service.deleteTask("1"));
        assertNull(service.getTaskByID("1"));
        assertFalse(service.deleteTask("1")); // Tries to delete a non existent ID
    }

    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Old", "Old desc");
        assertTrue(service.updateTask("1", "New", "New desc"));
        assertEquals("New", service.getTaskByID("1").getName());
        assertEquals("New desc", service.getTaskByID("1").getDescription()); // Checks for updated name and description
    }

    @Test
    public void testUpdateNonexistentTask() {
        TaskService service = new TaskService();
        assertFalse(service.updateTask("x", "Nope", "Nope desc"));
        assertNull(service.getTaskByID("x"));
    }
}

