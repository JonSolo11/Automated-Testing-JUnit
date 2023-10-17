package appointmentTests;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointments.Appointment;
import appointments.AppointmentService;

class AppointmentServiceErrorHandlingTest {
    private AppointmentService service;
    
    @BeforeEach
    void setUp() {
        // Arrange
        service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new Date(), "Initial doctor appointment");
        service.addAppointment(appointment);
    }
    
    // Test retrieval of an appointment that doesn't exist.
    @Test
    void testGetNonExistentAppointment() {
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointmentByID("0");
        });
    }
    
    // Test adding an appointment with a duplicate ID.
    @Test
    void testAddAppointmentWithExistingID() {
        // Arrange
        Appointment duplicateAppointment = new Appointment("1234567890", new Date(), "Duplicate doctor appointment");

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(duplicateAppointment);
        });
    }
    
    // Test deletion of an appointment that doesn't exist.
    @Test
    void testDeleteNonExistentAppointment() {
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("0");
        });
    }
    
    // Test updating an appointment that doesn't exist.
    @Test
    void testUpdateNonExistentAppointment() {
        // Arrange
        Date newDate = new Date();
        String newDescription = "Updated appointment description";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateAppointment("0000000000", newDate, newDescription);
        });
    }
}
