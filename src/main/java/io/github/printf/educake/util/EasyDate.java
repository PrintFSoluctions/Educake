package io.github.printf.educake.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class EasyDate {

	static int day, month, year;

	public static Date toDate(int day, int month, int year) {
		GregorianCalendar fullDate = new GregorianCalendar(year, month, day);
		return new Date(fullDate.getTimeInMillis());
	}

	public static Date rearrangeDate(String date) {
		String[] splitedDate = date.split("/");

		day   = Integer.parseInt(splitedDate[0]);
		month = Integer.parseInt(splitedDate[1]);
		year  = Integer.parseInt(splitedDate[2]);

		System.out.println(""+day+"/"+month+"/"+year);

		Date rearrangedDate = toDate(day,month,year);

		return rearrangedDate;
	}

	public static String toString(Date date){
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		dateFormatter.setLenient(false);

		return dateFormatter.format(date);
	}
}
