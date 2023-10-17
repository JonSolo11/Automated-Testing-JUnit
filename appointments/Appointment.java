package appointments;

import java.util.Date;

public class Appointment {
    
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        validateID(appointmentID); //Validation method created for consistency. No setter since ID is final. 
        
        this.appointmentID = appointmentID;
        this.setAppointmentDate(appointmentDate);
        this.setDescription(description);
    }

    // Getters and Setters

    public String getAppointmentID() {
		return appointmentID;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
        validateDate(appointmentDate);
		this.appointmentDate = appointmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
        validateDescription(description);
		this.description = description;
	}
	
	//Validation Methods
	private void validateID(String id) {
        if (id == null || id.length() > 10 || id.isEmpty()) {
            throw new IllegalArgumentException("Appointment ID must be 1 to 10 characters.");
        }
    }

    private void validateDate(Date date) {
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date cannot be null or in the past.");
        }
    }

    private void validateDescription(String desc) {
        if (desc == null || desc.length() > 50 || desc.isEmpty()) {
            throw new IllegalArgumentException("Description must be 1 to 50 characters.");
        }
    }
}
