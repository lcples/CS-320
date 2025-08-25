/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final List<Contact> Contacts = new ArrayList<>();

    // Adds a new contact and gives an error if it already exists
    public void newContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        for (Contact x : Contacts) {
            if (x.getContactID().equals(contactID)) {
                throw new IllegalArgumentException("ID already exists.");
            }
        }
        
        Contacts.add(new Contact(contactID, firstName, lastName, phoneNumber, address));
    }

    // Deletes a contact
    public void deleteContact(String contactID) {
        for (int i = 0; i < Contacts.size(); i++) {
        		if(Contacts.get(i).getContactID().equals(contactID)) {
        			Contacts.remove(i);
        		}
        }
    }

    
    // Bellow functions allow you to update the attributes of a contactID
    public void updateFirstName(String contactID, String newFirstName) {
        for (Contact x : Contacts) {
            	if(x.getContactID().equals(contactID)) {
            		x.setFirstName(newFirstName);
            	}
        }
    }

    public void updateLastName(String contactID, String newLastName) {
        for (Contact x : Contacts) {
            if(x.getContactID().equals(contactID)) {
            	x.setLastName(newLastName);
            }
         }   
    }

    public void updatePhoneNumber(String contactID, String newPhoneNumber) {
        for (Contact x : Contacts) {
            if(x.getContactID().equals(contactID)) {
            	x.setPhoneNumber(newPhoneNumber);
            }
        }
    }

    public void updateAddress(String contactID, String newAddress) {
        for (Contact x : Contacts) 
           if(x.getContactID().equals(contactID)) {
        	   x.setAddress(newAddress);
           }
        }
        
}
