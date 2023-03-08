package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com/");
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		WebElement wb = driver.findElement(By.xpath("//h2[@class='b2p-section--title featured-athletes--4 title-xl']"));
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeAsyncScript("arguments[0].scrollIntoView(true)",wb);
//		Thread.sleep(4000);
		String gold = driver.findElement(By.xpath("//span[text()='Mikaela SHIFFRIN']/ancestor::li//span[@class='result-medal result-medal--gold']")).getText();
		System.out.println(gold);
		driver.quit();
		
	}

}
