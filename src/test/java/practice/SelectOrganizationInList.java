package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOrganizationInList {
	
	public static void main(String[] args) {
		String orgName = "Infosys517";
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		String colName = "Organization Name";
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td/a"));
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			String actHeader = list.get(i).getText();
			if(colName.equals(actHeader))
			{
				count = i+2;
				break;
			}
		}
		String strPages = driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']/following::span[@name]")).getText();
		int pages = Integer.parseInt(strPages.split(" ")[1]);
		
		boolean flag = false;
		for (int i = 0; i < pages; i++) {
			List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td["+count+"]"));
			for(WebElement element:listOrg)
			{
				String actOrg = element.getText();
				System.out.println(actOrg);
				if(actOrg.equals(orgName))
				{
					driver.findElement(By.xpath("//a[text()='"+orgName+"']/../preceding-sibling::td/input")).click();
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
			else{
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("status"))));
			}
		}
	}
}
