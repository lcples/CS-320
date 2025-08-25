/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package appointmentTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class AppointmentService {
	
    private List<Appointment> appointments = new ArrayList<>();

    public boolean addAppointment(String id, Date date, String description) {
        if (findById(id) != null)
        	return false;
        
        appointments.add(new Appointment(id, date, description));
        return true;
    }

    public boolean deleteAppointment(String id) {
        Appointment app = findById(id);
        
        if (app == null)
        	return false;
        
        appointments.remove(app);
        return true;
    }

    public boolean updateAppointment(String id, Date newDate, String newDescription) {
        Appointment app = findById(id);
        
        if (app == null)
        	return false;

        if (newDate != null)
        	app.setAppointmentDate(newDate);
        
        if (newDescription != null)
        	app.setDescription(newDescription);

        return true;
    }

    private Appointment findById(String id) {
        for (Appointment app : appointments) {
            if (app.getId().equals(id))
            	return app;
        }
        return null;
    }
}

