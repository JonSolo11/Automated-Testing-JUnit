package contactTests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contacts.Contact;
import contacts.ContactService;

class ContactServiceHappyPathTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        // Initialize a default ContactService for each test.
        service = new ContactService();
        Contact contact = new Contact("1234567890", "Peter", "Griffin", "1234567890", "123 Anywhere st");
        service.addContact(contact);
    }

    @Test
    void testAddValidContact() {
        // Test adding a valid contact and its retrieval.
        // Arrange
        Contact lois = new Contact("0987654321", "Lois", "Griffin", "0987654321", "124 Anywhere st");

        // Act
        service.addContact(lois);
        Contact retrievedContact = service.getContactById("0987654321");

        // Assert
        assertEquals(lois, retrievedContact);
        assertEquals("Lois", retrievedContact.getfName());
        assertEquals("Griffin", retrievedContact.getlName());
        assertEquals("0987654321", retrievedContact.getPhoneNum());
        assertEquals("124 Anywhere st", retrievedContact.getAddress());
    }

    @Test
    void testDeleteExistingContact() {
        // Test deleting an existing contact.
        // Act
        boolean deletionSuccess = service.deleteContact("1234567890");

        // Assert
        assertEquals(true, deletionSuccess);
    }

    @Test
    void testUpdateExistingContact() {
        // Test updating the details of an existing contact.
        // Arrange
        String updatedFName = "Petey";
        String updatedLName = "Johnson";
        String updatedPhone = "1234567891";
        String updatedAddress = "125 Anywhere st";

        // Act
        service.updateContact("1234567890", updatedFName, updatedLName, updatedPhone, updatedAddress);
        Contact updatedContact = service.getContactById("1234567890");

        // Assert
        assertEquals(updatedFName, updatedContact.getfName());
        assertEquals(updatedLName, updatedContact.getlName());
        assertEquals(updatedPhone, updatedContact.getPhoneNum());
        assertEquals(updatedAddress, updatedContact.getAddress());
    }

    @Test
    void GetContact() {
        // Test retrieval of a contact by its ID.
        // Act
        Contact retrievedContact = service.getContactById("1234567890");

        // Assert
        assertEquals("Peter", retrievedContact.getfName());
        assertEquals("Griffin", retrievedContact.getlName());
        assertEquals("1234567890", retrievedContact.getPhoneNum());
        assertEquals("123 Anywhere st", retrievedContact.getAddress());
    }
}
