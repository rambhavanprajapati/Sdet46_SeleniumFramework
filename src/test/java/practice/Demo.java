package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tyss.genericUtility.constants.IConstantsUtility;
import com.tyss.genericUtility.enums.PropertyKey;
import com.tyss.genericUtility.externalFileUtility.ExcelFileUtility;
import com.tyss.genericUtility.externalFileUtility.PropertyFileUtility;
import com.tyss.genericUtility.misc.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static String m(String date, int days) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
	public static void main(String[] args) throws ParseException {

		
	}
}
