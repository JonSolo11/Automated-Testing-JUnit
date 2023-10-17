package appointments;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	// Map to store appointments with their IDs as keys.
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	// Adds a new appointment to the map.
	public void addAppointment(Appointment appointment) {
		if(appointments.containsKey(appointment.getAppointmentID())) {
			throw new IllegalArgumentException("Appointment with this ID already exists");
		}
		appointments.put(appointment.getAppointmentID(), appointment);
	}
	
	// Deletes an appointment from the map using its ID.
	public boolean deleteAppointment(String appointmentID) {
		if(!appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Appointment with this ID doesn't exist");
		}
		appointments.remove(appointmentID);
		return true;
	}
	
	// Updates the date and description of an existing appointment.
	public void updateAppointment(String appointmentID, Date newDate, String newDescription) {
		Appointment appointment = appointments.get(appointmentID);
		if(appointment == null) {
			throw new IllegalArgumentException("Appointment with this ID doesn't exist");
		}
		appointment.setAppointmentDate(newDate);
		appointment.setDescription(newDescription);
	}
	
	// Retrieves an appointment using its ID.
	public Appointment getAppointmentByID(String ID) {
		if(!appointments.containsKey(ID)) {
			throw new IllegalArgumentException("Appointment with this ID not found");
		}
		return appointments.get(ID);
	}
}
