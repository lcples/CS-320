/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService newServiceWithValid() {
        ContactService svc = new ContactService();
        svc.newContact("999", "Logan", "Samples", "0123456789", "123 Palm Street, Rossville");
        return svc;
    }

    @Test
    void duplicates() {
        ContactService svc = newServiceWithValid();
        assertThrows(IllegalArgumentException.class, () ->
                svc.newContact("999", "Logan", "Samples", "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void deleting() {
        ContactService svc = newServiceWithValid();
        svc.deleteContact("999");
        assertDoesNotThrow(() -> svc.newContact("999", "Logan", "Samples", "0123456789", "123 Palm Street, Rossville"));
    }

    @Test
    void delete_nonexistent() {
        ContactService svc = new ContactService();
        assertDoesNotThrow(() -> svc.deleteContact("999999"));
    }

    @Test
    void updateFirstName() {
        ContactService svc = newServiceWithValid();
        assertDoesNotThrow(() -> svc.updateFirstName("999", "Jane"));
    }

    @Test
    void updateLastName() {
        ContactService svc = newServiceWithValid();
        assertDoesNotThrow(() -> svc.updateLastName("999", "Doe"));
    }

    @Test
    void updateAddress() {
        ContactService svc = newServiceWithValid();
        assertDoesNotThrow(() -> svc.updateAddress("999", "456 Oak Ave, Shelbyville"));
    }

    @Test
    void updatePhone() {
        ContactService svc = newServiceWithValid();
        assertDoesNotThrow(() -> svc.updatePhoneNumber("999", "1112223333"));
    }

    @Test
    void updatePhone_invalid() {
        ContactService svc = newServiceWithValid();
        assertThrows(IllegalArgumentException.class, () -> svc.updatePhoneNumber("999", "0123"));
        assertThrows(IllegalArgumentException.class, () -> svc.updatePhoneNumber("999", "012345678910111213"));
        assertThrows(IllegalArgumentException.class, () -> svc.updatePhoneNumber("999", "012345678x"));
    }

    @Test
    void updateAddress_invalid() {
        ContactService svc = newServiceWithValid();
        String longAddr = "12345 Palm Street, Rossvilleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        assertThrows(IllegalArgumentException.class, () -> svc.updateAddress("999", longAddr));
    }

    @Test
    void updateNames_invalid() {
        ContactService svc = newServiceWithValid();
        assertThrows(IllegalArgumentException.class, () -> svc.updateFirstName("999", "Logannnnnnnnnnnnnnnnnnnnnnnn"));
        assertThrows(IllegalArgumentException.class, () -> svc.updateLastName("999", "Samplessssssssssssssssssssssssssss"));
    }

    @Test
    void update_nonexistent() {
        ContactService svc = new ContactService();
        assertDoesNotThrow(() -> svc.updateFirstName("NA", "Z"));
        assertDoesNotThrow(() -> svc.updateLastName("NA", "Z"));
        assertDoesNotThrow(() -> svc.updatePhoneNumber("NA", "1112223333"));
        assertDoesNotThrow(() -> svc.updateAddress("NA", "456 Oak Ave"));
    }
}

