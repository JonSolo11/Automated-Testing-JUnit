package appointmentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointments.Appointment;
import java.util.Calendar;
import java.util.Date;

class AppointmentHappyPathTest {
    private Appointment appointment;
    private Date futureDate;

    @BeforeEach
    void setup() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        futureDate = calendar.getTime();

        appointment = new Appointment("1234567890", futureDate, "Initial Description");
    }
    
    // Test successful creation of an appointment.
    @Test
    void testAppointmentCreation() {
        // Arrange
        Appointment localAppointment = new Appointment("0123456789", futureDate, "This is a test appointment");

        // Act & Assert
        assertEquals("0123456789", localAppointment.getAppointmentID());
        assertEquals(futureDate, localAppointment.getAppointmentDate());
        assertEquals("This is a test appointment", localAppointment.getDescription());
    }

    // Test creation of an appointment with ID at maximum length.
    @Test
    void testIdAtLimit() {
        // Arrange
        Appointment localAppointment = new Appointment("9999999999", futureDate, "Valid Description");

        // Act & Assert
        assertEquals("9999999999", localAppointment.getAppointmentID());
    }

    // Test creation of an appointment with description at maximum length.
    @Test
    void testDescriptionAtLimit() {
        // Arrange
        String desc = "This is exactly 50 characters long to the end.";
        Appointment localAppointment = new Appointment("123", futureDate, desc);

        // Act & Assert
        assertEquals(desc, localAppointment.getDescription());
    }

    // Test creation of an appointment with ID at minimum length.
    @Test
    void testIdAtMin() {
        // Arrange
        Appointment localAppointment = new Appointment("1", futureDate, "Valid Description");

        // Act & Assert
        assertEquals("1", localAppointment.getAppointmentID());
    }

    // Test creation of an appointment with description at minimum length.
    @Test
    void testDescriptionAtMin() {
        // Arrange
        String desc = "A";  
        Appointment localAppointment = new Appointment("123", futureDate, desc);

        // Act & Assert
        assertEquals(desc, localAppointment.getDescription());
    }

    // Test setting the description at maximum length.
    @Test
    void testSetDescriptionAtLimit() {
        // Arrange
        String description = "This is exactly 50 characters long to the end.";

        // Act
        appointment.setDescription(description);

        // Assert
        assertEquals(description, appointment.getDescription());
    }
    
    // Test setting the description at minimum length.
    @Test
    void testSetDescriptionMin() {
        // Arrange
        String description = "A";

        // Act
        appointment.setDescription(description);

        // Assert
        assertEquals(description, appointment.getDescription());
    }

    // Test retrieval of appointment ID.
    @Test
    void testGetId() {
        // Act & Assert
        assertEquals("1234567890", appointment.getAppointmentID());
    }

    // Test retrieval of appointment date.
    @Test
    void testGetDate() {
        // Act & Assert
        assertEquals(futureDate, appointment.getAppointmentDate());
    }

    // Test retrieval of appointment description.
    @Test
    void testGetDescription() {
        // Act & Assert
        assertEquals("Initial Description", appointment.getDescription());
    }
}
