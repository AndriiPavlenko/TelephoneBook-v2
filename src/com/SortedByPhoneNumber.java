package com;

import java.util.Comparator;

public class SortedByPhoneNumber implements Comparator<Contact> {

	@Override
	public int compare(Contact ob1, Contact ob2) {
		String phoneNumber1 = ob1.getPhoneNumber();
		String phoneNumber2 = ob2.getPhoneNumber();
		
		return phoneNumber1.compareTo(phoneNumber2);
	}

}
