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
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                // 1. Add an expense
                case 1 -> {
                    // id, date, amount, content
                    scanner.nextLine();
                    System.out.println("New expense");
                    System.out.println("Date (dd-MMM-yyyy): ");
                    String date = scanner.nextLine();

                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Content: ");
                    String content = scanner.nextLine();

                    expenseManager.addExpense(date, amount, content);
                    scanner.nextLine();
                }
                // 2. View all expenses
                case 2 -> expenseManager.viewExpenses();
                // 3. Delete an expense
                case 3 -> {
                    System.out.println("Enter espense ID to delete: ");
                    int expenseId = scanner.nextInt();
                    expenseManager.deleteExpense(expenseId);
                    System.out.println();
                    scanner.nextLine();
                }
                // 4. Quit program
                case 4 -> exit(0);
            }
        }
    }
}