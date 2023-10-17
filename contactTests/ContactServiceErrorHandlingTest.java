package contactTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contacts.Contact;
import contacts.ContactService;

class ContactServiceErrorHandlingTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        // Initialize a default ContactService for each test.
        service = new ContactService();
        Contact contact = new Contact("1234567890", "Peter", "Griffin", "1234567890", "123 Anywhere st");
        service.addContact(contact);
    }

    @Test
    void testReturnByIdNotFound() {
        // Test if retrieving a contact by a non-existent ID raises an exception.
        // Arrange
        String nonExistentId = "0";
        
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getContactById(nonExistentId);
        });
    }

    @Test
    void testAddContactExistingId() {
        // Test if adding a contact with an existing ID raises an exception.
        // Arrange
        Contact duplicateContact = new Contact("1234567890", "Lois", "Griffin", "0987654321", "124 Anywhere st");

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicateContact);
        });
    }

    @Test
    void testDeleteNonExistentContact() {
        // Test if deleting a non-existent contact raises an exception.
        // Arrange
        String nonExistentId = "0";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(nonExistentId);
        });
    }

    @Test
    void testUpdateNonExistentContact() {
        // Test if updating a non-existent contact raises an exception.
        // Arrange
        String nonExistentId = "0000000000";
        String fName = "Petey";
        String lName = "Johnson";
        String phone = "1234567891";
        String address = "125 Anywhere st";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(nonExistentId, fName, lName, phone, address);
        });
    }

    @Test
    void getNonExistentContact() {
        // Test if getting a non-existent contact raises an exception.
        // Arrange
        String nonExistentId = "0000000000";

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getContactById(nonExistentId);
        });
    }
}
