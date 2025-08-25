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

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        assertTrue(service.addAppointment("1", new Date(System.currentTimeMillis() + 2000), "desc"));
    }

    @Test
    public void testAddAppointmentDuplicateID() {
        AppointmentService service = new AppointmentService();
        assertTrue(service.addAppointment("1", new Date(System.currentTimeMillis() + 2000), "desc"));
        assertFalse(service.addAppointment("1", new Date(System.currentTimeMillis() + 3000), "another"));
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("1", new Date(System.currentTimeMillis() + 2000), "desc");
        assertTrue(service.deleteAppointment("1"));
        assertFalse(service.deleteAppointment("1"));
    }

    @Test
    public void testUpdateAppointment_UpdateDateandTime() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("1", new Date(System.currentTimeMillis() + 2000), "desc");
        Date newDate = new Date(System.currentTimeMillis() + 10000);
        assertTrue(service.updateAppointment("1", newDate, "updated"));
        assertTrue(service.updateAppointment("1", null, null));
    }

    @Test
    public void testUpdateAppointment_MissingId() {
        AppointmentService service = new AppointmentService();
        assertFalse(service.updateAppointment("MISSING", new Date(System.currentTimeMillis() + 2000), "desc"));
    }

    @Test
    public void testUpdateAppointment_InvalidDate() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("1", new Date(System.currentTimeMillis() + 2000), "desc");
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAppointment("1", new Date(System.currentTimeMillis() - 1000), null));
    }

    @Test
    public void testUpdateAppointment_invalidDescription() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("1", new Date(System.currentTimeMillis() + 2000), "desc");
        String longDesc = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAppointment("1", null, longDesc));
    }
}

