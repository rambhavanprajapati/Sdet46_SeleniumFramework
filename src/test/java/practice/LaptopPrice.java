package practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaptopPrice {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavaScriptUtility jsUtil = new JavaScriptUtility(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("laptop",Keys.ENTER);
		List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for(WebElement price:allprice)
		{
			jsUtil.highlight(price);
			String p = price.getText().substring(1).replaceAll(",", "");
			int n = Integer.parseInt(p);
			if(n>=30000 && n<=50000)
			{
				System.out.println(n);
			}
		}
	}
}
