import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bank_dashboard {

	public static void showDashboard(int id, String fullName) {
		int option = 0;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		
		while(true) {
				
		System.out.println("Welcome to Bank of Chechnya\r" + fullName);
		
		System.out.println("Your options");
		System.out.println("1. Deposit");	
		System.out.println("2. Withdraw");
		System.out.println("3. Send cash");
		System.out.println("4. Logout");
		
			try {
				
				option = Integer.parseInt(br.readLine());
				
				
				switch(option) {
				
				
				case 1: 
					Process.depositCash(id);
					break;
				
				case 2: 
					
					break; 
					
				case 3: 
					
					break; 
				
				case 4: 
					
					break;
				
				default: 
					System.out.println("Invalid option, try again");
					break;
				
					}
				
				} catch (Exception e) {
			
			}	
		}
	}	
}
