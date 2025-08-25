/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/
package appointmentTracker;

import java.util.Date;

public class Appointment {
    private final String id;
    private Date appointmentDate;
    private String description;

    // Class constructor
    public Appointment(String id, Date appointmentDate, String description) {
        if (id == null || id.length() > 10) 
        	throw new IllegalArgumentException("Invalid ID");
        
        if (appointmentDate == null || appointmentDate.before(new Date()))
        	throw new IllegalArgumentException("Invalid Date");
        
        if (description == null || description.length() > 50) 
        	throw new IllegalArgumentException("Invalid Description");

        this.id = id;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid Date");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }
}

