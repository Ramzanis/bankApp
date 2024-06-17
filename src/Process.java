import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Process {
 
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static int id;
	static String firstName, lastName, password, sql;
	static Connection con = Db_conf.getConnection();

	public static void createAccount() { //Processing create account from main
		
		try {
			
			System.out.println("Enter your personal number");
			id = Integer.parseInt(br.readLine());
			
			System.out.println("Enter your firstname");
			firstName = br.readLine();
			
			System.out.println("Enter your lastname");
			lastName = br.readLine();
			
			System.out.println("Enter your passsword");
			password = br.readLine();
			
			
			if (Accounts.createAccount(id, firstName, lastName, password)){
                System.out.println(
                    "New account for " + firstName + " " + lastName + " created successfully!\n");
            } else {
                System.out.println(
                    "Account Creation Failed!\n");
            }
         
		} catch (Exception e) {
            	
            	e.printStackTrace();
        }	
	}
	
	public static void loginAccount() { //Processing login from main
		
		try {
			
			System.out.println("Enter your personal number");
			id = Integer.parseInt(br.readLine());
						
			System.out.println("Enter your passsword");
			password = br.readLine();
			
			
			if (Accounts.loginAccount(id, password)){
				
					
            } else {
                System.out.println(
                    "Failed!\n");
            }
         
		} catch (Exception e) {
            	
            	e.printStackTrace();
        }					
	}
	
	
	public static void depositCash(int id) {
		
		double amount = 0;					
		
		while(true) {
		try {
			System.out.println("Current balance: " + getCurrentBalance(id));
			System.out.println("Amount to deposit:");
			amount = Double.parseDouble(br.readLine());
			
			if(amount <= 0 ) {
				
				System.out.println("Amount has to be greater than 0");
				continue;
					
			}
			
			con.setAutoCommit(false); //Start transaction
		   
			double currentBalance = getCurrentBalance(id);
			if(currentBalance == -1) {
				
				System.out.println("Account not found");
				return;
				
			}
			
			double newBalance = currentBalance + amount;
			if(updateBalance(id, newBalance)) {
				
				System.out.println("New balance is: " + newBalance);
				con.commit();
				
			} else {
				
				System.out.println("An error occurred, try again");
				con.rollback();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
                con.rollback(); // Rollback transaction on error
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }	finally {
            try {
                con.setAutoCommit(true); // Reset auto-commit to true
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }		
	}	
	
}
		
private static double getCurrentBalance(int id){
		
		sql = "SELECT balance FROM customer WHERE c_id = ?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			try(ResultSet rs = ps.executeQuery()){
				
				if(rs.next()) {	
					return rs.getDouble("balance");	
				}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}		
		return -1;	
}
			

	private static boolean updateBalance(int id, double balance){
		
		sql = "UPDATE customer SET balance = ? WHERE c_id = ?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setDouble(1, balance);
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();
			
			return rows > 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
				
		}
		

		return false;
		
	}
	
	
	
	
	
	
	
}
