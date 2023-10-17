package contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // In-memory storage for contacts using a HashMap with contact ID as the key.
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a contact.
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact with this ID already exists");
        }
        contacts.put(contact.getId(), contact);
    }
    
    // Retrieve a contact by its ID.
    public Contact getContactById(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with this ID not found");
        }
        return contacts.get(contactID);
    }

    // Update the details of a contact identified by its ID.
    public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setfName(newFirstName);
        contact.setlName(newLastName);
        contact.setPhoneNum(newPhone);
        contact.setAddress(newAddress);
    }

    // Delete a contact by its ID.
    public Boolean deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with this ID not found");
        }
        contacts.remove(contactID);
        return true;
    }
}
