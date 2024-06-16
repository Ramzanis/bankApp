import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) {
		int input;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		//hello
		System.out.println("Welcome! Please enter username and password");
		
		while(true) {
			
			System.out.println("1. Creating new account");
			System.out.println("2. Login ");
				
		try {
			input = Integer.parseInt(br.readLine());
			
			
		switch (input) {
		
	
		case 1: 
				//Creating new acc
				Process.createAccount();
				break;
                    
		 case 2:
             
				//Login
	            Process.loginAccount();
				break;

         default:
             System.out.println("Invalid option. Please choose again.");
		 }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
	
	}
	
}
