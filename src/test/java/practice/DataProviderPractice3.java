package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPractice3 {
	
	
	@Test(dataProvider = "data")
	public void test(String a)
	{
		System.out.println(a);
	}

	@DataProvider
	public Iterator<String> data()
	{
		List<String> list = new ArrayList<>();
		list.add("Bangalore");
		list.add("Delhi");
		list.add("Kashmir");
		list.add("Kanyakumari");
		
		return list.iterator();
	}
}
