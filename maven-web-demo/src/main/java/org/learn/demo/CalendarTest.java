package org.learn.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		Date d = date.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dd = format.format(d);
		String timeZone = date.getTimeZone().getID();
		System.out.println(Double.MAX_VALUE  +" " + Double.MIN_VALUE);
	}

}
