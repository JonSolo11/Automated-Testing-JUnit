package appointmentTests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointments.Appointment;
import appointments.AppointmentService;
import java.util.Date;

class AppointmentServiceHappyPathTest {
    private AppointmentService service;
    
    @BeforeEach
    void setUp() {
        // Arrange
        service = new AppointmentService();
        Date date = new Date();
        Appointment appointment = new Appointment("1234567890", date, "Doctor's checkup");
        service.addAppointment(appointment);
    }
    
    // Test adding a valid appointment.
    @Test
    void testAddValidAppointment() {
        // Arrange
        Date date2 = new Date();
        Appointment appointment2 = new Appointment("0123456789", date2, "Dentist appointment");

        // Act
        service.addAppointment(appointment2);
        
        // Assert
        assertEquals(appointment2, service.getAppointmentByID("0123456789"));
        assertEquals(date2, service.getAppointmentByID("0123456789").getAppointmentDate());
        assertEquals("Dentist appointment", service.getAppointmentByID("0123456789").getDescription());
    }
    
    // Test deleting an existing appointment.
    @Test
    void testDeleteAppointment() {
        // Act
        boolean isDeleted = service.deleteAppointment("1234567890");

        // Assert
        assertEquals(true, isDeleted);
    }

    // Test updating details of an existing appointment.
    @Test
    void testUpdateExistingAppointment() {
        // Arrange
        Date updatedDate = new Date();

        // Act
        service.updateAppointment("1234567890", updatedDate, "Updated doctor's checkup");
        
        // Assert
        assertEquals(updatedDate, service.getAppointmentByID("1234567890").getAppointmentDate());
        assertEquals("Updated doctor's checkup", service.getAppointmentByID("1234567890").getDescription());
    }
    
    // Test retrieval of an appointment by its ID.
    @Test
    void testGetAppointmentByIdExists() {
        // Act
        Appointment retrievedAppointment = service.getAppointmentByID("1234567890");
        
        // Assert
        assertEquals("1234567890", retrievedAppointment.getAppointmentID());
        assertEquals(new Date(), retrievedAppointment.getAppointmentDate()); 
        assertEquals("Doctor's checkup", retrievedAppointment.getDescription());
    }
}
