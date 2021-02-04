package com.crm;

import java.util.Date;

public class DateSample {
public static void main(String[] args) {
		
		Date dateobj = new Date();
		String currentDate = dateobj.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		
		String date = arr[2];
		int month = dateobj.getMonth();
		String year = arr[5];
		

		
		
	}
}
