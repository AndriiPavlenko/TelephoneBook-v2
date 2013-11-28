package com;

import java.util.Comparator;

public class SortedByFirstName implements Comparator<Contact>{

	@Override
	public int compare(Contact ob1, Contact ob2) {
		String firstName1 = ob1.getFirstName().toLowerCase();
		String firstName2 = ob2.getFirstName().toLowerCase();
		
		return firstName1.compareTo(firstName2);
	}

}
