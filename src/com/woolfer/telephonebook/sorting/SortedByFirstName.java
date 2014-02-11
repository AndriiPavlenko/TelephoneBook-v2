package com.woolfer.telephonebook.sorting;

import java.util.Comparator;

import com.woolfer.telephonebook.contact.Contact;

public class SortedByFirstName implements Comparator<Contact>{

	@Override
	public int compare(Contact ob1, Contact ob2) {
		String firstName1 = ob1.getFirstName().toLowerCase();
		String firstName2 = ob2.getFirstName().toLowerCase();
		
		return firstName1.compareTo(firstName2);
	}
}
