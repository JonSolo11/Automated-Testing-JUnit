package taskTests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.Task;
import tasks.TaskService;

class TaskServiceHappyPathTest {
	private TaskService service;

	@BeforeEach
	void setUp() {
		// Arrange
		// Initialize TaskService and add a default Task for each test.
		service = new TaskService();
		Task task = new Task("1234567890", "Write task service", "Task service in package tasks is incomplete");
		service.addTask(task);
	}
	
	@Test
	void testAddValidTask() {
		// Test the addition of a valid task.
		// Arrange
		Task test2 = new Task("0123456789", "task2", "Test task 2 description");
		
		// Act
		service.addTask(test2);
		
		// Assert
		assertEquals(test2, service.getTaskByID("0123456789"));
		assertEquals("task2", service.getTaskByID("0123456789").getName());
		assertEquals("Test task 2 description", service.getTaskByID("0123456789").getDescription());
	}
	
	@Test
	void testDeleteTask()	{
		// Test the successful deletion of a task by ID.
		// Act
		boolean isDeleted = service.deleteTask("1234567890");
		
		// Assert
		assertEquals(true, isDeleted);
	}

	@Test
    void testUpdateExistingTask() {
		// Test updating an existing task.
		// Act
        service.updateTask("1234567890", "UpdatedTask1", "Task1 is updated");
		
		// Assert
		assertEquals("UpdatedTask1", service.getTaskByID("1234567890").getName());
		assertEquals("Task1 is updated", service.getTaskByID("1234567890").getDescription());
    }
	
	@Test
	void testGetTaskByIdExists() {
		// Test retrieving a specific task by ID.
		// Act
		Task retrievedTask = service.getTaskByID("1234567890");
		
		// Assert
		assertEquals("1234567890", retrievedTask.getId());
		assertEquals("Write task service", retrievedTask.getName());
		assertEquals("Task service in package tasks is incomplete", retrievedTask.getDescription());
	}
}
