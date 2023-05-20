import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    private List<Expense> expenses;
    private Scanner scanner = new Scanner(System.in);

    public ExpenseManager() {
        this.expenses = new ArrayList();
        Expense expense1 = new Expense("3-Mar-2022", 150.22, "cafe");
        expenses.add(expense1);
    }

    public List getExpenses() {
        return expenses;
    }

    public void addExpense(String date, double amount, String content) {
        Expense newExpense = new Expense(date, amount, content);
        expenses.add(newExpense);
        System.out.println("Expense added!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No Expenses!");
            scanner.nextLine();
            return;
        }
        System.out.println("ID\tDate\t  \tAmount\tContent");
        int totalAmount = 0;
        for (Expense expense : expenses) {
            System.out.printf("%d\t%s\t%.0f\t\t%s\n", expense.getId(), expense.getDate(), expense.getAmount(), expense.getContent());
            totalAmount += expense.getAmount();
        }
        System.out.println("\nTotal Amount: " + totalAmount);
        scanner.nextLine();
    }

    public void deleteExpense(int expenseId) {
        boolean found = false;
        for (Expense expense: expenses) {
            if (expense.getId() == expenseId) {
                expenses.remove(expense);
                found = true;
                System.out.println("Expense deleted!");
            }
        }
        if(!found)
            System.out.println("No expense found");
    }
}
