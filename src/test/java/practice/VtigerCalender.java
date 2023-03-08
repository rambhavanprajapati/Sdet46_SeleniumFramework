package practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerCalender {
	
	public static void main(String[] args) {
		String reqMonth = "March";
		String reqYear = "2023";
		String reqDate = "10";
		int reqMonthNum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		int reqYearNum = Integer.parseInt(reqYear);
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Open Calendar...']")).click();
		WebElement ele = driver.findElement(By.xpath("//td[@class='calHdr']/a/b"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		String curMonthYear = ele.getText();
		System.out.println(curMonthYear);
		String curMonth = curMonthYear.split(" ")[0];
		String curYear = curMonthYear.split(" ")[1];
		int curMonthNum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curMonth).get(ChronoField.MONTH_OF_YEAR);
		
		
		
	}

}
