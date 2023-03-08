package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataInDatabase {

	public static void main(String[] args){

		Connection connection = null;
		try {

			//step 1:- create the instance for Driver--> register driver to jdbc
			Driver dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);

			//step 2:- get connection --> dburl, un, pwd 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");

			//step 3:- create statement
			Statement statement = connection.createStatement();

			//step 4:- execute query
			int result = statement.executeUpdate("insert into employee values(1002, 'Krishna', 9880, 1234569980, 'shimla');");

			//step 5:- check data added or not
			if(result==1)
			{
				System.out.println("data added successfully");
			}

		}
		catch (Exception e) {
			// TODO: handle exception
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
