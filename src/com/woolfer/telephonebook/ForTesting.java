package com.woolfer.telephonebook;

import java.awt.List;

import com.woolfer.telephonebook.contact.Contact;

public class ForTesting {
	public static void main(String[] args) {
		ListPhoneBook lp = new ListPhoneBook();
		java.util.List<Contact> ls = lp.getListOfPhoneBook();

		if(ls == null) {
			System.out.println("NULL");
		} else {
		System.out.println("withOUT sort");
		for(Contact i : ls) {
			System.out.println(i.getFirstName());
		}
		lp.setSortByName(true);
		System.out.println("SORT");
		for(Contact i : ls) {
			System.out.println(i.getFirstName());
		}
		System.out.println("SORT 2");
		lp.setSortByName(true);
		for(Contact i : ls) {
			System.out.println(i.getFirstName());
		}
	}
	}
	}
