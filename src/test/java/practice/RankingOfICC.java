package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RankingOfICC {
	
	public static void main(String[] args) {
		String formate = "T20I Team Rankings";
		String countryName = "New Zealand";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/homepage");
		WebElement element = driver.findElement(By.xpath("//button[normalize-space(text())='Rankings']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[@href='/rankings/mens/overview']")).click();
		//driver.findElement(By.xpath("//a[text()='View Full Table' and @href='/rankings/mens/team-rankings/odi']")).click();
		String rank = driver.findElement(By.xpath("//h4[text()='"+formate+"']/ancestor::div[@class='rankings-block__container rankings-block__container--teams']//div[text()='"+countryName+"']/following-sibling::div | //h4[text()='"+formate+"']/ancestor::div[@class='rankings-block__container rankings-block__container--teams']//td[contains(.,'"+countryName+"')]/following-sibling::td")).getText();
		System.out.println(countryName+" --> "+rank);
		driver.quit();
		
	}

}
