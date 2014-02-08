package com.woolfer.telephonebook.contact;

import java.util.Comparator;


public class SortedByLastName implements Comparator<Contact>{

	@Override
	public int compare(Contact ob1, Contact ob2) {
		String lastName1 = ob1.getLastName().toLowerCase();
		String lastName2 = ob2.getLastName().toLowerCase();
		
		return lastName1.compareTo(lastName2);
	}

}
