/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/
package Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

	// Method that creates a new class I can use to perform tests
    private Contact newValidContact() {
        return new Contact(
                "999",         
                "Logan",           
                "Samples",            
                "0123456789",     
                "123 Palm Street, Rossville" 
        );
    }

    @Test
    void testValidConstructor() {
        Contact c = newValidContact();
        assertEquals("999", c.getContactID());
        assertEquals("Logan", c.getFirstName());
        assertEquals("Samples", c.getLastName());
        assertEquals("0123456789", c.getPhoneNumber());
        assertEquals("123 Palm Street, Rossville", c.address());
    }

   

    @Test
    void testNullId() {
        assertThrows(IllegalArgumentException.class, () ->
          new Contact(null, "Logan", "Samples", "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
           new Contact("999", null, "Samples", "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () ->
           new Contact("999", "Logan", null, "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () ->
           new Contact("999", "Logan", "Samples", null, "123 Palm Street, Rossville")
        );
    }

    @Test
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("999", "Logan", "Samples", "0123456789", null)
        );
    }

   

    @Test
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("9999999999999", "Logan", "Samples", "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
        	new Contact("999", "Logannnnnnnnnnnnnnnnnnnnnnnn", "Samples", "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
        	new Contact("999", "Logan", "Samplessssssssssssssssssssssssssss", "0123456789", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testAddressTooLong() {
        String longAddr = "12345 Palm Street, Rossvilleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"; 
        assertThrows(IllegalArgumentException.class, () ->
        	new Contact("999", "Logan", "Samples", "0123456789", longAddr)
        );
    }


    @Test
    // Phone number must be exactly 10 characters to meet requirements
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
        	new Contact("999", "Logan", "Samples", "0123", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
        	new Contact("999", "Logan", "Samples", "012345678910111213", "123 Palm Street, Rossville")
        );
    }

    @Test
    void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () ->
        	new Contact("999", "Logan", "Samples", "012345678x", "123 Palm Street, Rossville")
        );
    }


    @Test
    void testSetFirstNameValid() {
        Contact c = newValidContact();
        c.setFirstName("Jane");
        assertEquals("Jane", c.getFirstName());
    }

    @Test
    void testSetLastNameValid() {
        Contact c = newValidContact();
        c.setLastName("Doe");
        assertEquals("Doe", c.getLastName());
    }

    @Test
    void testSetAddressValid() {
        Contact c = newValidContact();
        c.setAddress("456 Oak Ave, Shelbyville");
        assertEquals("456 Oak Ave, Shelbyville", c.address());
    }

    @Test
    void testSetPhoneValid() {
        Contact c = newValidContact();
        c.setPhoneNumber("1112223333");
        assertEquals("1112223333", c.getPhoneNumber());
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact c = newValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("Logannnnnnnnnnnnn"));
    }

    @Test
    void testSetLastNameTooLong() {
        Contact c = newValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("Samplessssssssssss"));
    }

    @Test
    void testSetAddressTooLong() {
        Contact c = newValidContact();
        String longAddr = "99999999999999999999999999999999999999999999999999999999999999999999999999";
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(longAddr));
    }

    @Test
    void testSetPhoneNotTenDigits() {
        Contact c = newValidContact();
        assertThrows(IllegalArgumentException.class, () -> c.setPhoneNumber("123456789"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhoneNumber("12345678910"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhoneNumber("12345648x"));
    }
}