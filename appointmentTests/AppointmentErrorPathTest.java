package appointmentTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import appointments.Appointment;

import java.util.Date;
import java.util.Calendar;

class AppointmentErrorHandlingPathTest {
    private Appointment appointment;

    // Initialize an appointment object for each test.
    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1); // Add one day to current date.
        appointment = new Appointment("1234567890", cal.getTime(), "Initial Description");
    }

    // Test appointment initialization with a long ID.
    @Test
    void testIdTooLong() {
        String id = "12345678910";
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, new Date(), "Test Description");
        });
    }

    // Test appointment initialization with a null ID.
    @Test
    void testIdNull() {
        String id = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, new Date(), "Test Description");
        });
    }

    // Test appointment initialization with an empty ID.
    @Test
    void testIdEmpty() {
        String id = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(id, new Date(), "Valid Description");
        });
    }

    // Test appointment initialization with a null date.
    @Test
    void testDateNull() {
        Date date = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", date, "Test Description");
        });
    }

    // Test appointment initialization with a past date.
    @Test
    void testDatePast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Valid Description");
        });
    }

    // Test appointment initialization with a null description.
    @Test
    void testDescriptionNull() {
        String desc = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), desc);
        });
    }

    // Test appointment initialization with a long description.
    @Test
    void testDescriptionTooLong() {
        String desc = "The max description length is 50 chars, we are far past that limit.";

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), desc);
        });
    }

    // Test appointment initialization with an empty description.
    @Test
    void testDescriptionEmpty() {
        String desc = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(), desc);
        });
    }

    // Test setting the appointment's date to null.
    @Test
    void testSetDateNull() {
        Date date = null;

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(date);
        });
    }

    // Test setting the appointment's date to a past date.
    @Test
    void testSetDatePast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(pastDate);
        });
    }

    // Test setting the appointment's description to null.
    @Test
    void testSetDescriptionNull() {
        String desc = null;

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(desc);
        });
    }

    // Test setting the appointment's description to an empty string.
    @Test
    void testSetDescriptionEmpty() {
        String desc = "";

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(desc);
        });
    }

    // Test setting the appointment's description to a long string.
    @Test
    void testSetDescriptionTooLong() {
        String desc = "The max description length is 50 chars, we are far past that limit";

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(desc);
        });
    }
}
