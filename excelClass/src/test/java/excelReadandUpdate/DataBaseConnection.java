package excelReadandUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	public static void readDataBase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String host="jdbc:mysql://localhost:3306/EmployeeDetails";
		String userName="root";
		String passWord="root";
			
		Connection connection = DriverManager.getConnection(host,userName,passWord);
		
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery("select * from EmployeeInfo right join EmployeeSkill on EmployeeInfo.id=EmployeeSkill.id;");
		
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			String name = executeQuery.getString(2);
			String age = executeQuery.getString(3);
			String location = executeQuery.getString(4);
			System.out.println("id "+id+" Name "+name+" Age "+age+" location "+location);
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		readDataBase();
	}
	
}
