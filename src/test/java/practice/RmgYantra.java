package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantra {
	
	public static void main(String[] args) {
		String actProjectName = "cascade"+new Random().nextInt(1000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(actProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("Ram");
		WebElement dropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		List<WebElement> allProjectName = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for (WebElement projectName : allProjectName) {
			String expProjectName = projectName.getText();
			if(expProjectName.equals(actProjectName))
			{
				System.out.println("project created successfully-->  "+expProjectName);
				break;
			}
		}
		Connection connection = null;
		try {

			//step 1:- create the instance for Driver--> register driver to jdbc
			Driver dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);

			//step 2:- get connection --> dburl, un, pwd 
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			//step 3:- create statement
			Statement statement = connection.createStatement();

			//step 4:- execute query
			ResultSet result = statement.executeQuery("select * from project");

			//step 5:- check data added or not
			while(result.next())
			{
				String projectName = result.getString("project_name");
				if(projectName.equals(actProjectName))
				{
					System.out.println("data present in database-->  "+projectName);
					break;
				}
			}   
		}
		catch (Exception e) {
			
		}
		finally {
			//step 6:- close the connection
			try {
				connection.close();
			} catch (SQLException e) {

			}
			System.out.println("database closed");

		}
	}

}
