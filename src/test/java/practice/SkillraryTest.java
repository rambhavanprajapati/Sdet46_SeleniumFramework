package practice;

import org.testng.annotations.Test;

import com.tyss.genericUtility.configuration.BaseClassPractice;

public class SkillraryTest extends BaseClassPractice{
	
	@Test
	public void skillraryTest()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.skillrary.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Test3 ---> class3");
	}

}
