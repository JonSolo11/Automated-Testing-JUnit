package contacts;

public class Contact {
    
    private final String id;
    private String fName;
    private String lName;
    private String phoneNum;
    private String address;

    public Contact(String id, String fName, String lName, String phoneNum, String address) {
        validateId(id);
        setfName(fName);
        setlName(lName);
        setPhoneNum(phoneNum);
        setAddress(address);

        this.id = id;
    }

    // Getters and Setters

    public String getId() {
		return id;
	}

    public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
        validateFirstName(fName);
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
        validateLastName(lName);
		this.lName = lName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
        validatePhoneNumber(phoneNum);
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
        validateAddress(address);
		this.address = address;
	}
	
	// Validation Methods

	private void validateId(String id) {
        if (id == null || id.length() > 10 || id.isEmpty()) {
            throw new IllegalArgumentException("Contact ID must be 1 to 10 characters.");
        }
    }

    private void validateFirstName(String fName) {
        if (fName == null || fName.length() > 10 || fName.isEmpty()) {
            throw new IllegalArgumentException("First Name must be 1 to 10 characters.");
        }
    }

    private void validateLastName(String lName) {
        if (lName == null || lName.length() > 10 || lName.isEmpty()) {
            throw new IllegalArgumentException("Last Name must be 1 to 10 characters.");
        }
    }

    private void validatePhoneNumber(String number) {
        if (number == null || number.length() != 10) {
            throw new IllegalArgumentException("Phone Number must be exactly 10 digits.");
        }
        
        //Check to ensure all chars are digits
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Phone Number must contain only digits.");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30 || address.isEmpty()) {
            throw new IllegalArgumentException("Address must be 1 to 30 characters.");
        }
    }
}
