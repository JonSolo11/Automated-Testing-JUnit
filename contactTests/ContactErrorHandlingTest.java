package contactTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contacts.Contact;

public class ContactErrorHandlingTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        // Initialize a default contact for each test.
        contact = new Contact("1234567890", "Peter", "Griffin", "1234567890", "123 Anywhere st");
    }

    @Test
    void testSetfNameTooLong() {
        // Test if a too-long first name raises an exception.
        // Arrange
        String tooLongName = "Peter Griffin";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setfName(tooLongName));
    }

    @Test
    void testSetfNameNull() {
        // Test if setting a null first name raises an exception.
        // Arrange
        String nullName = null;

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setfName(nullName));
    }

    @Test
    void testSetlNameTooLong() {
        // Test if a too-long last name raises an exception.
        // Arrange
        String tooLongLastName = "Peter Griffin";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setlName(tooLongLastName));
    }

    @Test
    void testSetlNameNull() {
        // Test if setting a null last name raises an exception.
        // Arrange
        String nullLastName = null;
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setlName(nullLastName));
    }

    @Test
    void testSetPhoneNumTooLong() {
        // Test if a too-long phone number raises an exception.
        // Arrange
        String tooLongPhoneNumber = "12345678910";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum(tooLongPhoneNumber));
    }
    
    @Test
    void testSetPhoneNumTooShort() {
        // Test if a too-short phone number raises an exception.
        // Arrange
        String tooShortPhoneNumber = "1234";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum(tooShortPhoneNumber));
    }
    
    @Test
    void testSetPhoneNumNotNumbers() {
        // Test if a phone number with non-numeric characters raises an exception.
        // Arrange
        String notNumbers = "aaaaaaaaaa";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum(notNumbers));
    }

    @Test
    void testSetPhoneNumNull() {
        // Test if setting a null phone number raises an exception.
        // Arrange
        String nullPhoneNumber = null;
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNum(nullPhoneNumber));
    }

    @Test
    void testSetAddressTooLong() {
        // Test if a too-long address raises an exception.
        // Arrange
        String tooLongAddress = "123 Anywhere st, Providence, Rhode Island";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setAddress(tooLongAddress));
    }

    @Test
    void testSetAddressNull() {
        // Test if setting a null address raises an exception.
        // Arrange
        String nullAddress = null;
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setAddress(nullAddress));
    }
}
