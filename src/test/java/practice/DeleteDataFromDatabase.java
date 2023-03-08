package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteDataFromDatabase {
	
	public static void main(String[] args) throws SQLException {
		//step 1:- create the instance for Driver--> register driver to jdbc
				Driver dbDriver = new Driver();
				DriverManager.registerDriver(dbDriver);
				
				//step 2:- get connection --> dburl, un, pwd 
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
				
				//step 3:- create statement
				Statement statement = connection.createStatement();
				
				//step 4:- execute query
				int result = statement.executeUpdate("delete from employee where emp_name='Krishna';");
				
				//step 5:- check data added or not
				if(result==1)
				{
					System.out.println("data deleted successfully");
				}
				
				//step 6:- close the connection
				connection.close();
	}

}
