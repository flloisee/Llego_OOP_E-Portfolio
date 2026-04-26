package hi; // remove package or replace the name with the appropriate package name
import java.util.*;

public class ExpenseTrackerLlego {
	// using the Scanner class
	private static Scanner sc = new Scanner(System.in);

	static void programTitle() {
		// Program Title
		System.out.println("----- Expenses Tracker by Llego -----");
	}
	
	public static double totalExpenses(double food, double transportation, double houseBills, double others) {
		return food + transportation + houseBills + others; // return the sum of the expenses
	}
	
	static double computeBudget(double totalExpenses, double budget) {
		// Enhancement 2: Computation for the remaining budget
		double remainingBudget = budget - totalExpenses;
		return remainingBudget;
	}
	
	static String budgetCheck(double remainingBudget) {
		if (remainingBudget < 0) {
			return "Total expenses exceeds the budget!";
		}
		
		return "Expenses are within your budget.";
	}
	
	static void budgetStatus(double remainingBudget, double totalExpenses) {
		System.out.println();
		System.out.printf("Total expenses: %.2f\n", totalExpenses);
		System.out.printf("Remaining budget: %.2f\n", remainingBudget);
		System.out.println("\nBudget status:");
		
		// budget status by intervals
		if (remainingBudget < 500) {
			System.out.println("Budget is low!");
		} else if (remainingBudget <= 2000) {
			System.out.println("Budget is sufficient.");
		} else if (remainingBudget > 2000) {
			System.out.println("Budget is abundant!");
		}
	}
	
	public static void main(String[] args) {
		programTitle();
		// Enhancement 1: User inputs 
		System.out.print("Enter your current budget: ");
		double budget = sc.nextDouble();
		System.out.print("Enter your food expenses: ");
		double food = sc.nextDouble();
		System.out.print("Enter your transporation expenses: ");
		double transportation = sc.nextDouble();
		System.out.print("Enter your house bill expenses: "); // Enhancement 3: Add another expense category
		double houseBills = sc.nextDouble();
		System.out.print("Enter other expenses: ");
		double others = sc.nextDouble();
		sc.nextLine(); // clear input buffer like in C
		
		double total = totalExpenses(food, transportation, houseBills, others); // compute the total 
		budget = computeBudget(total, budget); // compute the new budget from the total expenses
		
		// print budget status
		System.out.println("\nBudget status: " + budgetCheck(budget));
		budgetStatus(budget, total);
		
	}

}
