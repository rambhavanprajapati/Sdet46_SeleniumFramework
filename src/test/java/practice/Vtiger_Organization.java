package practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Organization {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		String orgName = "Amdocs235";
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
		for(WebElement element : list)
		{
			String actOrg = element.getText();
			if(orgName.equals(actOrg))
			{
				System.out.println("Organation present in the list ---------->TC pass");
				break;
			}
		}
		driver.quit(); 
	}

}
