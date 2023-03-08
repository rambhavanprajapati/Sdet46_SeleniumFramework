package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 {
	
	@Test(dataProvider = "d")
	public void test(String a, int b, String c)
	{
		System.out.println(a+" "+b+" "+c);
	}
	
	@DataProvider(name = "d")
	public Object[][] data()
	{
		Object[][] arr = new Object[4][3];
		arr[0][0] = "Bangalore";
		arr[0][1] = 560017;
		arr[0][2] = "qwer";
		
		arr[1][0] = "Delhi";
		arr[1][1] = 110047;
		arr[1][2] = "poiu";
		
		arr[2][0] = "Manali";
		arr[2][1] = 950263;
		arr[2][2] = "zxcv";
		
		arr[3][0] = "Chennai";
		arr[3][1] = 591256;
		arr[3][2] = "asdf";
		
		return arr;
	}

}
