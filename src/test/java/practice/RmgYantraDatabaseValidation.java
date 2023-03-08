package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraDatabaseValidation {

	public static void main(String[] args) {
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
				if(projectName.equals("cascade"))
				{
					System.out.println("data present in database");
					break;
				}
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
