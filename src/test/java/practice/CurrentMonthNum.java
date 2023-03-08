package practice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class CurrentMonthNum {
	
	public static void main(String[] args) {
		String curMonth = "Mar";
		int curMonthNum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curMonth).get(ChronoField.MONTH_OF_YEAR);
		System.out.println(curMonthNum);
	}

}
