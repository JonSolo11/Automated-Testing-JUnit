package contactTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contacts.Contact;

class ContactHappyPathTest {

    private Contact contact;

    @BeforeEach
    void setup() {
        // Initialize a default contact for each test.
        contact = new Contact("1234567890", "Peter", "Griffin", "1234567890", "123 Anywhere st");
    }

    @Test
    void testContactCreation() {
        // Verify all attributes of a newly created contact.
        // Arrange
        Contact localContact = new Contact("9876543210", "Lois", "Griffin", "0987654321", "456 Everywhere st");

        // Act
        String id = localContact.getId();
        String fName = localContact.getfName();
        String lName = localContact.getlName();
        String phoneNum = localContact.getPhoneNum();
        String address = localContact.getAddress();

        // Assert
        assertEquals("9876543210", id);
        assertEquals("Lois", fName);
        assertEquals("Griffin", lName);
        assertEquals("0987654321", phoneNum);
        assertEquals("456 Everywhere st", address);
    }

    @Test
    void testIdAtLimit() {
        // Ensure that the maximum limit for ID is correctly handled.
        // Arrange
        Contact localContact = new Contact("9999999999", "John", "Doe", "1234567890", "789 Nowhere st");

        // Act
        String id = localContact.getId();

        // Assert
        assertEquals("9999999999", id);
    }

    @Test
    void testIdAtMin() {
        // Ensure that the minimum limit for ID is correctly handled.
        // Arrange
        Contact localContact = new Contact("1", "John", "Doe", "1234567890", "789 Nowhere st");

        // Act
        String id = localContact.getId();

        // Assert
        assertEquals("1", id);
    }

    @Test
    void testfNameAtLimit() {
        // Ensure that the maximum limit for the first name is correctly handled.
        // Arrange
        String name = "ABCDEFGHIJ";
        Contact localContact = new Contact("123", name, "Doe", "1234567890", "789 Nowhere st");

        // Act
        String fName = localContact.getfName();

        // Assert
        assertEquals(name, fName);
    }

    @Test
    void testfNameAtMin() {
        // Ensure that the minimum limit for the first name is correctly handled.
        // Arrange
        String name = "A";
        Contact localContact = new Contact("123", name, "Doe", "1234567890", "789 Nowhere st");

        // Act
        String fName = localContact.getfName();

        // Assert
        assertEquals(name, fName);
    }

    @Test
    void testlNameAtLimit() {
        // Ensure that the maximum limit for the last name is correctly handled.
        // Arrange
        String name = "ABCDEFGHIJ";
        Contact localContact = new Contact("123", "John", name, "1234567890", "789 Nowhere st");

        // Act
        String lName = localContact.getlName();

        // Assert
        assertEquals(name, lName);
    }

    @Test
    void testlNameAtMin() {
        // Ensure that the minimum limit for the last name is correctly handled.
        // Arrange
        String name = "A";
        Contact localContact = new Contact("123", "John", name, "1234567890", "789 Nowhere st");

        // Act
        String lName = localContact.getlName();

        // Assert
        assertEquals(name, lName);
    }

    @Test
    void testAddressAtLimit() {
        // Ensure the maximum limit for address is correctly handled.
        // Arrange
        String address = "123456789012345678901234567890";
        Contact localContact = new Contact("123", "John", "Doe", "1234567890", address);

        // Act
        String addr = localContact.getAddress();

        // Assert
        assertEquals(address, addr);
    }

    @Test
    void testAddressAtMin() {
        // Ensure the minimum limit for address is correctly handled.
        // Arrange
        String address = "1";
        Contact localContact = new Contact("123", "John", "Doe", "1234567890", address);

        // Act
        String addr = localContact.getAddress();

        // Assert
        assertEquals(address, addr);
    }

    @Test
    void testPhoneNumValid() {
        // Validate a correct phone number.
        // Arrange
        String phone = "9876543210";
        Contact localContact = new Contact("123", "John", "Doe", phone, "789 Nowhere st");

        // Act
        String phoneNum = localContact.getPhoneNum();

        // Assert
        assertEquals(phone, phoneNum);
    }

    @Test
    void testSetfName() {
        // Test the setting of first name.
        // Arrange
        contact.setfName("Brian");

        // Act
        String fName = contact.getfName();

        // Assert
        assertEquals("Brian", fName);
    }

    @Test
    void testSetlName() {
        // Test the setting of last name.
        // Arrange
        contact.setlName("Johnson");

        // Act
        String lName = contact.getlName();

        // Assert
        assertEquals("Johnson", lName);
    }

    @Test
    void testSetPhoneNum() {
        // Test the setting of phone number.
        // Arrange
        contact.setPhoneNum("0987654321");

        // Act
        String phoneNum = contact.getPhoneNum();

        // Assert
        assertEquals("0987654321", phoneNum);
    }

    @Test
    void testSetAddress() {
        // Test the setting of address.
        // Arrange
        contact.setAddress("456 B Street");

        // Act
        String address = contact.getAddress();

        // Assert
        assertEquals("456 B Street", address);
    }
}
