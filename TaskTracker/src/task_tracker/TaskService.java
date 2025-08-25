/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package task_tracker;

import java.util.ArrayList;

public class TaskService {
	
	// This statement creates an array to house different tasks
    private ArrayList<Task> tasks = new ArrayList<>();

    // This function adds a new task to the array and ensures no tasks with duplicate id's are added
    // Using a boolean will help later in testing to give feedback if the function failed or succeeded
    public boolean addTask(String id, String name, String description) {
        if (getTaskByID(id) != null) 
        	return false;
        
        tasks.add(new Task(id, name, description));
        
        return true;
    }

    // The deleteTask and updateTask functions check if the task with the specified id exists and changes array accordingly
    public boolean deleteTask(String id) {
        Task task = getTaskByID(id);
        
        if (task == null) 
        	return false;
        
        tasks.remove(task);
        
        return true;
    }

    public boolean updateTask(String id, String name, String description) {
        Task task = getTaskByID(id);
        
        if (task == null) 
        	return false;
        
        if (name != null) 
        	task.setName(name);
        
        if (description != null) 
        	task.setDescription(description);
        
        return true;
    }

    // This function checks each id in the array to match the specified id
    public Task getTaskByID(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) 
            	return task;
        }
        
        return null;
    }
}

