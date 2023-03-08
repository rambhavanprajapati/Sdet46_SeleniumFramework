package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtility.configuration.BaseClassPractice;

public class VtigerTest extends BaseClassPractice{
	
	@Test
	public void vtigerTest()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("http://localhost:8888/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Test2 ---> class2");
		Assert.fail();
	}

}
