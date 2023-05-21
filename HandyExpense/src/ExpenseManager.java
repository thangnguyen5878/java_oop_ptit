import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    private List<Expense> expenses;
    private Scanner scanner = new Scanner(System.in);
    private String FILE_PATH = "src/Expense.txt";

    public ExpenseManager() {
        this.expenses = new ArrayList();
        readExpenses();
    }

    public List getExpenses() {
        return expenses;
    }

    public void addExpense() {
        scanner.nextLine();
        System.out.println("New expense");
        System.out.println("Date (dd-MMM-yyyy): ");
        String date = scanner.nextLine();

        System.out.println("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Content: ");
        String content = scanner.nextLine();

        Expense newExpense = new Expense(date, amount, content);
        expenses.add(newExpense);
        System.out.println("Expense added!");
        scanner.nextLine();
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No Expenses!");
            System.out.println();
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

    public void deleteExpense() {
        System.out.println("Enter espense ID to delete: ");
        int expenseId = scanner.nextInt();

        boolean found = false;
        Iterator<Expense> i = expenses.iterator();
        while (i.hasNext()) {
            Expense expense = i.next();
            if(expense.getId() == expenseId) {
                i.remove();
                found = true;
                System.out.println("Expense Deleted!");
                break;
            }
        }
        if(!found)
            System.out.println("No expense found");
        System.out.println();
        scanner.nextLine();
    }

    public void readExpenses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String date = fields[0].trim();
                double amount = Double.parseDouble(fields[1].trim());
                String content = fields[2].trim();

                Expense expense = new Expense(date, amount, content);
                expenses.add(expense);

                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeExpenses() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            StringBuilder data = new StringBuilder();
            for (Expense expense : expenses) {
                String line = expense.getDate() + ", " + expense.getAmount() + ", " + expense.getContent() + "\n";
                data.append(line);
            }
            writer.write(data.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
