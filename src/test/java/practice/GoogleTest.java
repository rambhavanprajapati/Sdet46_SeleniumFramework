package practice;

import org.testng.annotations.Test;

import com.tyss.genericUtility.configuration.BaseClassPractice;

public class GoogleTest extends BaseClassPractice{

	@Test
	public void googleTest()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Test1 ---> class1");
		
	}
}
