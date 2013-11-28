package com;

import java.util.Collections;
import java.util.List;

public class ListPhoneBook {
	private List<Contact> listPhoneBook = null;
	public static boolean sortByName;
	public static boolean sortByLastName;
	public static boolean sortByPhoneNumber;

	public ListPhoneBook() {
		listPhoneBook = ChangeDB.getPhoneBook();
//		sortByName = false;
//		sortByLastName = false;
//		sortByPhoneNumber = false;
	}

	public List<Contact> getListOfPhoneBook() {
		return listPhoneBook;
	}

	public void setSortByName(boolean sort) {
			if (!sortByName) {
				Collections.sort(listPhoneBook, new SortedByFirstName());
				sortByName = true;
			} else {
				Collections.sort(listPhoneBook, Collections.reverseOrder(new SortedByFirstName()));
				sortByName = false;
			}
		
	}
	
	public String getIsSortByName() {
		if(sortByName){ return "true";} else{
		return "false";}
	}

	public void setSortByLastName(boolean sort) {
		if (!sortByLastName) {
			Collections.sort(listPhoneBook, new SortedByLastName());
			sortByLastName = true;
		} else {
			Collections.sort(listPhoneBook,
					Collections.reverseOrder(new SortedByLastName()));
			sortByLastName = false;
		}
	}

	public void setSortByPhoneNumber(boolean sort) {
		if (!sortByPhoneNumber) {
			Collections.sort(listPhoneBook, new SortedByPhoneNumber());
			sortByPhoneNumber = true;
		} else {
			Collections.sort(listPhoneBook,
					Collections.reverseOrder(new SortedByPhoneNumber()));
			sortByPhoneNumber = false;
		}
	}

}
