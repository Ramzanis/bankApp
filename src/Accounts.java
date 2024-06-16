import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Accounts {

	static Connection con = Db_conf.getConnection();
	static String sql = "";
	
	public static boolean createAccount(int id, String firstName, String lastName, String password) {
		
		
		try {
		
			if (id == 0 || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
				
				System.out.println("Enter credentials");
				
				return false;
				//
			}
			//Prepare SQL statement before executing 
			sql = "INSERT INTO customer (c_id, c_firstname, c_lastname, password) VALUES (?, ?, ?, ?)";
			
			//Set the value for each column
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
	        ps.setString(2, firstName);
	        ps.setString(3, lastName);
	        ps.setString(4, password);
		
	        ps.executeUpdate();
	        return true;
	        
		} catch (Exception e ) {
			
			e.printStackTrace();
			return false;
		}
		
			
	}
	
	//login 
	public static boolean loginAccount(int id, String password) {
		
		
		try {
		
			if (id == 0 || password.isEmpty()) {
				
				System.out.println("Enter credentials");
				
				return false;
				
			}
			
			//Prepare SQL statement before executing
			sql = "SELECT * FROM customer WHERE c_id = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
		    ps.setInt(1, id);
		    ps.setString(2, password);
		    
		    ResultSet rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	String fullName = rs.getString("c_firstname") + " " + rs.getString("c_lastname");
		    	Bank_dashboard.showDashboard(id, fullName);
		    	return true;
		    	
		    	
		    } else {
		    	
		    	System.out.println("Wrong id or password");
		    	return false;
		    }
		     
	        
		} catch (SQLException e ) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
}
