package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1 {
	
	@Test(dataProvider = "city")
	public void test(String a)
	{
		System.out.println(a);
	}
	
	@DataProvider(name = "city")
	public String[] data()
	{
		String[] arr = new String[4];
		arr[0] = "Bangalore";
		arr[1] = "Delhi";
		arr[2] = "Shimla";
		arr[3] = "Chennai";
		
		return arr;
	}

}
