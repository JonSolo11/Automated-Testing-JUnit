package taskTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.Task;

class TaskHappyPathTest {
    private Task task;

    @BeforeEach
    void setup() {
        // Setup a default Task object for each test.
        task = new Task("1234567890", "Initial Name", "Initial Description");
    }
    
    @Test
    void testTaskCreation() {
        // Test creating a valid task.
        Task localTask = new Task("0123456789", "Test1", "This is a test task");
        assertEquals("0123456789", localTask.getId());
        assertEquals("Test1", localTask.getName());
        assertEquals("This is a test task", localTask.getDescription());
    }

    @Test
    void testTask2Creation() {
        // Test creating another valid task.
        Task localTask = new Task("1237894560", "Test2", "This is a 2nd test task");
        assertEquals("1237894560", localTask.getId());
        assertEquals("Test2", localTask.getName());
        assertEquals("This is a 2nd test task", localTask.getDescription());
    }

    @Test
    void testIdAtLimit() {
        // Test creating a task with maximum ID length.
        Task localTask = new Task("9999999999", "Valid Name", "Valid Description");
        assertEquals("9999999999", localTask.getId());
    }

    @Test
    void testNameAtLimit() {
        // Test creating a task with maximum name length.
        Task localTask = new Task("123", "This is exactly 20", "Valid Description");
        assertEquals("This is exactly 20", localTask.getName());
    }

    @Test
    void testDescriptionAtLimit() {
        // Test creating a task with maximum description length.
        Task localTask = new Task("123", "Valid Name", "This is exactly 50 characters in total okay.");
        assertEquals("This is exactly 50 characters in total okay.", localTask.getDescription());
    }

    @Test
    void testIdAtMin() {
        // Test creating a task with minimum ID length.
        Task localTask = new Task("1", "Valid Name", "Valid Description");
        assertEquals("1", localTask.getId());
    }

    @Test
    void testNameAtMin() {
        // Test creating a task with minimum name length.
        Task localTask = new Task("123", "1", "Valid Description");
        assertEquals("1", localTask.getName());
    }

    @Test
    void testDescriptionAtMin() {
        // Test creating a task with minimum description length.
        Task localTask = new Task("123", "Valid Name", "1");
        assertEquals("1", localTask.getDescription());
    }

    @Test
    void testSetNameAtMax() {
        // Test updating task's name to maximum allowed length.
        String name = "This is exactly 20";
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    void testSetNameAtMin() {
        // Test updating task's name to minimum allowed length.
        String name = "1";
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    void testSetDescriptionAtLimit() {
        // Test updating task's description to maximum allowed length.
        String description = "This is exactly 50 characters in total okay.";
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void testSetDescriptionMin() {
        // Test updating task's description to minimum allowed length.
        String description = "1";
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void testGetId() {
        // Test retrieving the task's ID.
        assertEquals("1234567890", task.getId());
    }

    @Test
    void testGetName() {
        // Test retrieving the task's name.
        assertEquals("Initial Name", task.getName());
    }

    @Test
    void testGetDescription() {
        // Test retrieving the task's description.
        assertEquals("Initial Description", task.getDescription());
    }
}
