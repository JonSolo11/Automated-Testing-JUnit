package tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	// Map to store tasks with their IDs as keys.
	private final Map<String, Task> tasks = new HashMap<>();
	
	// Adds a new task to the map.

	public void addTask(Task task) {
		if(tasks.containsKey(task.getId())) {
			throw new IllegalArgumentException("Task with this ID already exists");
		}
		tasks.put(task.getId(), task);
	}
	
	//Deletes a task from the map using its ID.
	public boolean deleteTask(String taskID) {
		if(!tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("Task with this ID doesn't exist");
		}
		tasks.remove(taskID);
		return true;
	}
	
	//Updates the name and description of an existing task.

	public void updateTask(String taskID, String name, String description) {
		Task task = tasks.get(taskID);
		if(task == null) {
			throw new IllegalArgumentException("Task with this ID doesn't exist");
		}
		task.setName(name);
		task.setDescription(description);
	}
	
	//Retrieves a task using its ID
	public Task getTaskByID(String ID) {
		if(!tasks.containsKey(ID)) {
			throw new IllegalArgumentException("Task with this ID not found");
		}
		return tasks.get(ID);
	}
}
