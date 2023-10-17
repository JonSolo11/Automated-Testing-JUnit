package tasks;

public class Task {
    // Immutable unique ID for the task.
    private final String id;
    
    // Name of the task.
    private String name;
    
    // Description of the task.
    private String description;

    //Constructor to initialize a new Task.

    public Task(String id, String name, String description) {
        validateId(id);
        validateName(name);
        validateDescription(description);
        
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter for the unique ID.
    public String getId() {
        return id;
    }

    // Getter for name.
    public String getName() {
        return name;
    }

    // Setter for name.
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    // Getter for description.
    public String getDescription() {
        return description;
    }

    // Setter for description.
    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }
    
    //Validates ID privately
    private void validateId(String id) {
        if (id == null || id.length() > 10 || id.length() < 1) {
            throw new IllegalArgumentException("id must be 10 characters or less");
        }
    }
    
    //Validates Name privately
    private void validateName(String name) {
        if (name == null || name.length() > 20 || name.length() < 1) {
            throw new IllegalArgumentException("name must be 20 characters or less");
        }
    }
    
    //Validates description privately
    private void validateDescription(String description) {
        if (description == null || description.length() > 50 || description.length() < 1) {
            throw new IllegalArgumentException("description must be 50 characters or less");
        }
    }
}
