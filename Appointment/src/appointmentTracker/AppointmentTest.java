/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package appointmentTracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AppointmentTest {
	
    @Test
    public void testCreateAppointment() {
        Date future = new Date(System.currentTimeMillis() + 3600000); 
        Appointment appt = new Appointment("999", future, "testing appointment");
        assertEquals("999", appt.getId());
        assertEquals(future, appt.getAppointmentDate());
        assertEquals("testing appointment", appt.getDescription());
    }

    @Test
    public void testSetters_updateDateAndDescription() {
        Appointment appt = new Appointment("A1", new Date(System.currentTimeMillis() + 3600000), "desc");
        Date newFuture = new Date(System.currentTimeMillis() + 7200000); 
        appt.setAppointmentDate(newFuture);
        appt.setDescription("Updated");
        assertEquals(newFuture, appt.getAppointmentDate());
        assertEquals("Updated", appt.getDescription());
    }

    @Test
    public void testNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment(null, new Date(System.currentTimeMillis() + 1000), "desc"));
    }

    @Test
    public void testNullDate() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("99", null, "desc"));
    }

    @Test
    public void testNullDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("99", new Date(System.currentTimeMillis() + 1000), null));
    }

    @Test
    public void testIdTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("toolongid123", new Date(System.currentTimeMillis() + 1000), "desc"));
    }

    @Test
    public void testDescriptionTooLong() {
        String longDesc = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("99", new Date(System.currentTimeMillis() + 1000), longDesc));
    }

    @Test
    public void testAppointmentPastDate() {
        Date past = new Date(System.currentTimeMillis() - 1000);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("ID1", past, "desc"));
    }

    @Test
    public void testAppointmentDateNotBeforeNow_setter() {
        Appointment appt = new Appointment("ID1", new Date(System.currentTimeMillis() + 3600000), "desc");
        Date past = new Date(System.currentTimeMillis() - 1000);
        assertThrows(IllegalArgumentException.class, () -> appt.setAppointmentDate(past));
    }

    @Test
    public void testSetAppointmentDateNull() {
        Appointment appt = new Appointment("99", new Date(System.currentTimeMillis() + 3600000), "desc");
        assertThrows(IllegalArgumentException.class, () -> appt.setAppointmentDate(null));
    }

    @Test
    public void testSetDescriptionNull() {
        Appointment appt = new Appointment("99", new Date(System.currentTimeMillis() + 3600000), "desc");
        assertThrows(IllegalArgumentException.class, () -> appt.setDescription(null));
    }


}
