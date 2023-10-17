package taskTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.Task;
import tasks.TaskService;

class TaskServiceErrorHandlingTest {
	private TaskService service;

	@BeforeEach
	void setUp() {
		// Arrange
		// Initialize TaskService and add a default Task for for each test.
		service = new TaskService();
		Task task = new Task("1234567890", "Write task service", "Task service in package tasks is incomplete");
		service.addTask(task);
	}
	
	@Test
	void testGetNonExistentTask() {
		// Test retrieving a task by ID that doesn't exist.
		// Act and Assert
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        service.getTaskByID("0");
	    });
	}
	
	@Test
	void testAddTaskWithExistingID() {
		// Test adding a task with an ID that already exists.
		// Arrange
		Task duplicateTask = new Task("1234567890","Write task service", "Task service in package tasks is incomplete");
		
		// Act and Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        service.addTask(duplicateTask);
	    });
	}
	
	@Test
	void testDeleteNonExistentTask() {
		// Test attempting to delete a task by an ID that doesn't exist.
		// Act and Assert
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        service.deleteTask("0");
	    });
	}
	
	@Test
	void testUpdateNonExistentTask() {
		// Test attempting to update a task by an ID that doesn't exist.
		// Act and Assert
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	service.updateTask("0000000000", "UpdatedTask1", "Task1 is updated");
	    });
	}
	    
	@Test
	void testGetTaskByIdNotExists() {
		// Test attempting to retrieve a task by a non-existing ID.
		// Act and Assert
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTaskByID("nonexistentID");
		});
	}
}
