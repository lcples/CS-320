/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/
package task_tracker;

public class Task {
    private final String id;
    private String name;
    private String description;

    
    // This function sets the task variables and ensures they meet requirements
    public Task(String id, String name, String description) {
        if (id == null || id.length() > 10)
        	throw new IllegalArgumentException("Invalid ID");
        
        if (name == null || name.length() > 20)
        	throw new IllegalArgumentException("Invalid Name");
        
        if (description == null || description.length() > 50) 
        	throw new IllegalArgumentException("Invalid Description");

        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters and setter methods
    public String getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
    public String getDescription() { 
    	return description; 
    }
    
    // Setters required an input check to ensure they meet requirements when updated
    public void setName(String name) {
        if (name == null || name.length() > 20) 
        	throw new IllegalArgumentException("Invalid Name");
        
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) 
        	throw new IllegalArgumentException("Invalid Description");
        
        this.description = description;
    }
}

