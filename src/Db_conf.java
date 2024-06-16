import java.sql.*;

public class Db_conf {
	
	//Config of local database containing the tables for the application
	static Connection con; 
	
	public static Connection getConnection() {
		
		try {
			
			String mySQLDriver = "com.mysql.cj.jdbc.Driver";
			
			String url = "jdbc:mysql://localhost:3306/bank_database";
			String user = "root";
			String pass = "root";
			Class.forName(mySQLDriver);
			con = DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			System.out.println("Connection failed " + e.getMessage());
				
		}
		return con;
		
	}
}
