package secureATMSystem;
import java.util.Scanner;

public class SecureATMSystemLlego {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean exitFlag = false, success = false;
		int attempts = 1;
		float userBal = 0;
		
		do {
			while (success == false) { 
				final String corrPin = "Llego1234";
				System.out.print("Enter a pin: ");
				String pin = sc.nextLine();
				
				if (!pin.equals(corrPin)) {
					attempts++;
					
					if (attempts > 3) {
						System.out.println("\n\nAccount Locked.");
						sc.close();
						System.exit(1);
					}
					
					System.out.print("Wrong pin! Please try again.\n");
				} else {
					success = true;
					break;
				}
			}
			
			System.out.println("\n\n===== ATM MENU =====");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdrawal");
			System.out.println("4. Exit");
			System.out.print("> ");
			int transactionChoice = sc.nextInt();
			
			switch (transactionChoice) {
			case 1:
				System.out.println("\n===== CHECK BALANCE =====");
				System.out.printf("Balance: %.2f", userBal);
				break;
			case 2:
				System.out.println("\n===== DEPOSIT =====");
				System.out.print("Enter amount to deposit: ");
				float depositAmo = sc.nextFloat();
				
				userBal += depositAmo;
				break;
			case 3:
				System.out.println("\n===== WITHDRAWAL =====");
				System.out.print("Enter amount to withdraw: ");
				float withdrawAmo = sc.nextFloat(), tempBal = userBal;
				
				if (withdrawAmo <= 2000) {
					if ((tempBal -= withdrawAmo) < 0) {
						System.out.println("Invalid withdrawal amount!");
					} else {
						userBal -= withdrawAmo;
					}
				} else {
					System.out.println("Withdrawal amount exceeds 2,000.00 pesos.");
				}
				break;
			case 4:
				exitFlag = true;
				break;
			default:
				System.out.println("Option is not included.");
			}
		
		} while (!exitFlag);
		
		sc.close();
		System.out.println("\n\nProgram ended.");
		
		
	}

}
