package studentPaymentSystem;
import java.util.Scanner;

public class StudentPaymentSystemLlego {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String studName, studID;
		float balance = 0; 
		int transactionCount = 0;
		boolean exitFlag = false, hasDiscount = false;
		
		System.out.print("Enter student name: ");
		studName = sc.nextLine();
		System.out.print("Enter student ID: ");
		studID = sc.nextLine();
		System.out.print("Enter the total tuition fee: ");
		balance = sc.nextFloat();
		
		do {
			System.out.println("\n===== PAYMENT MENU =====");
			System.out.println("1. Pay Tuition");
			System.out.println("2. Check Balance");
			System.out.println("3. Apply Discount");
			System.out.println("4. Exit");
			System.out.print("> ");
			
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("\n===== PAY TUITION =====");
				System.out.print("Enter payment amount: ");
				float payment = sc.nextFloat();
				if (payment <= 0) {
					System.out.println("Payment must be a positive or nonzero value!");
				} else {
					if (payment > balance) {
						System.out.println("Invalid payment!");
					} else {
						balance -= payment;
						transactionCount++;
					}
				}
				break;
				
			case 2:
				System.out.println("\n===== CHECK BALANCE =====");
				if (balance > 0) {
					System.out.printf("Remaining balance: %.2f\n", balance);
				} else {
					System.out.println("No remaining balance.");
				}
				
				transactionCount++;
				break;
				
			case 3:
				if (hasDiscount) {
					System.out.println("Multiple discounts is prohitbited!");
					break;
				}
				
				System.out.println("\n===== DISCOUNT =====");
				System.out.println("Enter status: ");
				System.out.println("1. Regular Student: ");
				System.out.println("2. Scholar: ");
				System.out.print("(Enter 1 or 2): ");
				
				int status = sc.nextInt();
				switch (status) {
				case 1:
					System.out.println("No discount applied.");
					break;
					
				case 2:
					if ((balance -= balance * 0.2) > 0) {
						System.out.println("20% discount applied to tuition fee.");
					}
					break;
				}
					
				hasDiscount = true;
				transactionCount++;
				break;
				
			case 4:
				System.out.println("\n===== DETAILS =====");
				System.out.println("Student name: " + studName);
				System.out.println("Total transactions: " + transactionCount);
				System.out.printf("Final balance: %.2f\n", balance);
				
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
