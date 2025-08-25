/********************
 * CS-320           *
 * Project 1        *
 * 08/10/2025       *
 * Logan Samples    *
 ********************/

package Contact;

public class Contact {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private final String contactID;
	
	
	/* All variables in this class must not be null and must meet character length
	 * requirements.
	 * */
	private boolean valid_ID(String contactID) {
		if (contactID == null || contactID.length() > 10) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	private boolean valid_firstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	private boolean valid_lastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	private boolean valid_phone(String phoneNumber) {
	    if (phoneNumber != null && phoneNumber.length() == 10 && phoneNumber.chars().allMatch(Character::isDigit)) {
	    	return true;
	    }
	    
	    else {
	    	return false;
	    }
	}

	
	private boolean valid_address(String address) {
		if (address == null || address.length() > 30) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	
	// This function validates inputs before assigning them
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		
		if(!valid_ID(contactID)) {
			throw new IllegalArgumentException("Invalid contact ID.");
		}
		
		if(!valid_firstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		
		if(!valid_lastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		
		if(!valid_phone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		
		if(!valid_address(address)) {
			throw new IllegalArgumentException("Invalid address.");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// Bellow are the getter and setter methods
	
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String address() {
		return address;
	}
	

	
	public void setFirstName(String firstName) {
		if(!valid_firstName(firstName)) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(!valid_lastName(lastName)) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if(!valid_phone(phoneNumber)) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(String address) {
		if(!valid_address(address)) {
			throw new IllegalArgumentException("Invalid address.");
		}
		
		this.address = address;
	}
}
