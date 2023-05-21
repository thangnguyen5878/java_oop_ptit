import java.util.Scanner;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        while (true) {
            System.out.println("Handy Expense");
            System.out.println("-------------------------------");
            System.out.println("1. Add an expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Save");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                // 1. Add an expense
                case 1 -> expenseManager.addExpense();
                // 2. View all expenses
                case 2 -> expenseManager.viewExpenses();
                // 3. Delete an expense
                case 3 -> expenseManager.deleteExpense();
                // 4. Save
                case 4 -> {
                    expenseManager.writeExpenses();
                    System.out.println("Saved!");
                    scanner.nextLine();
                }
                // 5. Exit
                case 5 -> exit(0);
            }
        }
    }
}