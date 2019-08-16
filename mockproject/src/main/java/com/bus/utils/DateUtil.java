package com.bus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static String StringDate(String date)
	{
		try {
			SimpleDateFormat formatToDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatToString = new SimpleDateFormat("dd-MM-yyyy");
			date = formatToString.format(formatToDate.parse(date));
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
}
