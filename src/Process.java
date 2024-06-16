import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Process {
 
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static int id;
	static String firstName, lastName, password;

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
                System.out.println(
                    "Login Successful\n");
            } else {
                System.out.println(
                    "Failed!\n");
            }
         
		} catch (Exception e) {
            	
            	e.printStackTrace();
        }					
	}
	
}
