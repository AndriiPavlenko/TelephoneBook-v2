package com.woolfer.telephonebook.sorting;

import java.util.Comparator;

import com.woolfer.telephonebook.contact.Contact;

public class SortedByPhoneNumber implements Comparator<Contact> {

	@Override
	public int compare(Contact ob1, Contact ob2) {
		String phoneNumber1 = ob1.getPhoneNumber();
		String phoneNumber2 = ob2.getPhoneNumber();
		
		return phoneNumber1.compareTo(phoneNumber2);
	}
}
