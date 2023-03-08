package com.tyss.genericUtility.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * This class consists of java specific methods
 * @author Zero Touch
 *
 */
public class JavaUtility {
	
	SimpleDateFormat sdf;
	Calendar cal;
	/**
	 * This method will generate random number for every execution
	 * @param boundaryValue
	 * @return
	 */
	public int getRandomNumber(int boundaryValue)
	{
		return new Random().nextInt(boundaryValue);
	}
	
	/**
	 * This method will print the statement
	 * @param output
	 */
	public void consolPrint(Object output)
	{
		System.out.println(output);
	}
	
	/**
	 * This method is used to convert into integer
	 * @param s
	 * @return
	 */
	public int parseNumber(String s)
	{
		return Integer.parseInt(s);
	}
	/**
	 * this method will generate the current system date
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}

	/**
	 * This method will generate the current system in specific format
	 * @return
	 */
	public String getSystemDateInFormate()
	{
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInFormate = date+" "+month+" "+year+" "+time;
		return dateInFormate;
	}
	
	/**
	 * This method is used to convert month name into month number
	 * please specify the pattern as below specified
	 * MMMM ---> month full name(January,February, March...)
	 * MMM ---> month short name(Jan, Feb Mar...)
	 * @param monthName
	 * @param pattern
	 * @return
	 */                         //Jan               MMM
	public int getMonthNumber(String monthName, String pattern)
	{
		int monthNumber = DateTimeFormatter.ofPattern(pattern.toUpperCase())
		.withLocale(Locale.ENGLISH)
		.parse(monthName)
		.get(ChronoField.MONTH_OF_YEAR);
		return monthNumber;
	}
	
	/**
	 * This generic method will return current date
	 * @return
	 */
	public String getCurrentStringDate()
	{
		sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return sdf.format(new Date());
	}
	
	/**
	 * This generic method will return the date in particular pattern
	 * 
	 * @param d
	 * @param pattern
	 * @return
	 */
	public String getStringDate(String d, String pattern)
	{
		sdf = new SimpleDateFormat(pattern);
		cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String date = sdf.format(cal.getTime());
		return date;	
	}
	
	/**
	 * This generic method will add specific no of days to current date
	 * @param noOfDays
	 * @param pattern
	 * @return
	 */
	public String addDayToCurrentDate(int noOfDays)
	{
		sdf = new SimpleDateFormat("dd_MM_yyyy");
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noOfDays);
		String date = sdf.format(cal.getTime());
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * This generic method will subtract specific no of days to current date
	 * @param noOfDays
	 * @param pattern
	 * @return
	 */
	public String substractDayToCurrentDate(int noOfDays, String pattern)
	{
		sdf = new SimpleDateFormat(pattern);
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -noOfDays);
		String date = sdf.format(cal.getTime());
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * This generic method will add specific no of days to specified date
	 * @param dateString
	 * @param noOfDays
	 * @return
	 */
	public String addDayToDate(String dateString, int noOfDays)
	{
		String date = "";
		sdf = new SimpleDateFormat("MMM_dd_yyyy");
		cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(dateString));
			cal.add(Calendar.DAY_OF_MONTH, noOfDays);
			date = sdf.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * This generic method will substract specific no of days to specified date
	 * @param dateString
	 * @param noOfDays
	 * @return
	 */
	public String substractDayToDate(String dateString, int noOfDays)
	{
		String date = "";
		sdf = new SimpleDateFormat("dd_MMMM_yyyy");
		cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(dateString));
			cal.add(Calendar.DAY_OF_MONTH, -noOfDays);
			date = sdf.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * This method will split the string based on strategy
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s, String strategy)
	{
		return s.split(strategy);
	}
	
	/**
	 * This method will decode the particular string
	 * @param s
	 * @return
	 */
	public String decode(String s)
	{
		return new String(Base64.getDecoder().decode(s.getBytes()));
	}
	
	/**
	 * This method will encode the particular string
	 * @param s
	 * @return
	 */
	public String encode(String s)
	{
		return new String(Base64.getEncoder().encode(s.getBytes()));
	}
}
