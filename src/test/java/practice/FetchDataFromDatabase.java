package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	public static void main(String[] args) throws SQLException {
		//step 1:- create the instance for Driver--> register driver to jdbc
		Driver dbDriver = new Driver(); 
		DriverManager.registerDriver(dbDriver);
		
		//step 2:- get connection --> dburl, un, pwd 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
		
		//step 3:- create statement
		Statement statement = connection.createStatement();
		
		//step 4:- execute query
		ResultSet result = statement.executeQuery("select * from employee");
		
		//step 5:- iterate the data and verify of fetch
		while(result.next())
		{
			String empName = result.getString("emp_name");
			int empId = result.getInt("emp_id");
			System.out.println(empId+"   "+empName);
			//System.out.println(empId);
		}
		
		//step 6:- close the connection
		connection.close();
	}

}
