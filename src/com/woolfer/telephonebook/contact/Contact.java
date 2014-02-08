package com.woolfer.telephonebook.contact;

public class Contact {
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private int id;
	
	public Contact(String FirstName, String LastName, String PhoneNumber, int id) {
		this.FirstName = FirstName;
		this.LastName =LastName;
		this.PhoneNumber = PhoneNumber;
		this.id = id;
	}
	
	Contact(String FirstName, String PhoneNumber, int id) {
		this.FirstName = FirstName;
		this.PhoneNumber = PhoneNumber;
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
