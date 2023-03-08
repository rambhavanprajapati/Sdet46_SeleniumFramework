package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggetion {
	public static void main(String[] args) {
		String[] a = {};
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("automation");
		List<String> dataList = new ArrayList<>();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));	
    	for(WebElement element:list)
		{
     		String allEle = element.getText();
     		//ArrayList al = new ArrayList();
     		dataList.add(allEle);
		}
     		//System.out.println(al);
     		for (int i = dataList.size()-1; i>0; i--) {
     			Object auto = a[i];
				System.out.println(auto);
				//break;
			}
     		//break;
	}

}
