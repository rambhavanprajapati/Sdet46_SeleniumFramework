package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingPriceOfLaptopFromFlipkart {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("laptop",Keys.ENTER);
		
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1'][not(number(translate(text(),'₹,',''))<50000 and number(translate(text(),'₹,',''))>30000)]/ancestor::div[@class='col col-5-12 nlI3QM']/preceding-sibling::div/div[@class='_4rR01T']"));
		for (WebElement product : productName) {
			String p_name = product.getText();
			String price = driver.findElement(By.xpath("//div[text()='"+p_name+"']/ancestor::div[@class='_3pLy-c row']//div[@class='_30jeq3 _1_WHN1']")).getText();
			System.out.println(p_name+"------------>"+price);
			
		}
	}
}
