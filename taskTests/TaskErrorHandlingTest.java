package taskTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import tasks.Task;

class TaskErrorHandlingTest {
    private Task task;

    @BeforeEach
    void setUp() {
        // Initialize a default Task for each test.
        task = new Task("1234567890", "Initial Name", "Initial Description");
    }
    
    @Test
    void testIdTooLong() {
        // Test creating a task with an ID that is too long.
        assertThrows(IllegalArgumentException.class,() ->{
            new Task("12345678910", "Test1", "This is a test task");
        });
    }

    @Test
    void testIdNull() {
        // Test creating a task with a null ID.
        assertThrows(IllegalArgumentException.class,() ->{
            new Task(null, "Test1", "This is a test task");
        });
    }

    @Test
    void testIdEmpty() {
        // Test creating a task with an empty ID.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("", "Valid Name", "Valid Description");
        });
    }

    @Test
    void testNameNull() {
        // Test creating a task with a null name.
        assertThrows(IllegalArgumentException.class,() ->{
            new Task("1234567890", null, "This is a test task");
        });
    }

    @Test
    void testNameEmpty() {
        // Test creating a task with an empty name.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "", "Valid Description");
        });
    }

    @Test
    void testNameTooLong() {
        // Test creating a task with a name that exceeds the allowed length.
        assertThrows(IllegalArgumentException.class,() ->{
            new Task("1234567890", "This name is far too long ", "This is a test task");
        });
    }

    @Test
    void testDescriptionNull() {
        // Test creating a task with a null description.
        assertThrows(IllegalArgumentException.class,() ->{
            new Task("1234567890", "Test1", null);
        });
    }

    @Test
    void testDescriptionTooLong() {
        // Test creating a task with a description that exceeds the allowed length.
        assertThrows(IllegalArgumentException.class,() ->{
            new Task("1234567890", "Test1", "The max description length is 50 chars, we are past that limit");
        });
    }

    @Test
    void testDescriptionEmpty() {
        // Test creating a task with an empty description.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Valid Name", "");
        });
    }

    @Test
    void testSetNameNull() {
        // Test updating the task's name to null.
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    void testSetNameEmpty() {
        // Test updating the task's name to empty.
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("");
        });
    }

    @Test
    void testSetNameTooLong() {
        // Test updating the task's name to a value that exceeds the allowed length.
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is far too long to be allowed");
        });
    }

    @Test
    void testSetDescriptionNull() {
        // Test updating the task's description to null.
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }

    @Test
    void testSetDescriptionEmpty() {
        // Test updating the task's description to empty.
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("");
        });
    }

    @Test
    void testSetDescriptionTooLong() {
        // Test updating the task's description to a value that exceeds the allowed length.
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("The max description length is 50 chars, we are far past that limit");
        });
    }
}
