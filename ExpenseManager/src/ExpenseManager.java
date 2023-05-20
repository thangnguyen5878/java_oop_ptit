import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    static ArrayList<Expense> expenses = new ArrayList<Expense>();
    static int lastExpenseId = 0;
    private static final String CSV_FILE_PATH = "./src/data.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
    private static final String CSV_HEADER = "ID,Date,Amount,Content";
    Scanner scanner = new Scanner(System.in);

    public ExpenseManager() {
        readExpenses();
        System.out.println("Expense Manager (Java)");
        System.out.println("------------------------\n");
        displayHome();
    }

    public void displayHome() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addExpense(scanner);
                case 2 -> displayExpenses();
                case 3 -> deleteExpense(scanner);
                case 4 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void returnHome() {
        System.out.print("Press Enter to  return to Homepage");
        scanner.nextLine();
        displayHome();
    }

    public static void addExpense(Scanner scanner) {
        System.out.println("Enter the date of the expense (dd-MMM-yyyy), or type 'quit' to stop:");
        String dateString = scanner.next();

        while (!dateString.equalsIgnoreCase("quit")) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Date date = formatter.parse(dateString);

                System.out.println("Enter the amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Enter a description:");
                String content = scanner.nextLine();

                lastExpenseId++;
                Expense expense = new Expense(lastExpenseId, date, amount, content);
                expenses.add(expense);

                System.out.println("Expense added.");
            } catch (Exception e) {
                System.out.println("Invalid date format, please try again (dd-MMM-yyyy), or type 'quit' to stop:");
            }

            System.out.println("Enter the date of the expense (dd-MMM-yyyy), or type 'quit' to stop:");
            dateString = scanner.next();
        }
    }

    public static void displayExpenses() {
        if (expenses.size() == 0) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("All expenses:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public static void deleteExpense(Scanner scanner) {
        if (expenses.size() == 0) {
            System.out.println("No expenses to delete.");
        } else {
            System.out.println("Enter the ID of the expense to delete:");
            int id = scanner.nextInt();

            boolean found = false;
            for (Expense expense : expenses) {
                if (expense.getId() == id) {
                    expenses.remove(expense);
                    found = true;
                    System.out.println("Expense deleted.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Expense not found.");
            }
        }
    }


    private static void writeExpense(Expense expense) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(CSV_FILE_PATH, true);

            File file = new File(CSV_FILE_PATH);
            if (!file.exists()) {
                fileWriter.append(CSV_HEADER);
                fileWriter.append("\n");
            }

            fileWriter.append(Integer.toString(expense.getId()));
            fileWriter.append(",");
            fileWriter.append(DATE_FORMAT.format(expense.getDate()));
            fileWriter.append(",");
            fileWriter.append(Double.toString(expense.getAmount()));
            fileWriter.append(",");
            fileWriter.append(expense.getContent());
            fileWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Expense> readExpenses() {
        List<Expense> expenses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line = br.readLine(); // skip header row
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int id = Integer.parseInt(values[0]);
                Date date = new SimpleDateFormat("dd-MMM-yyyy").parse(values[1]);
                double amount = Double.parseDouble(values[2]);
                String content = values[3];

                Expense expense = new Expense(id, date, amount, content);
                expenses.add(expense);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return expenses;
    }
}

