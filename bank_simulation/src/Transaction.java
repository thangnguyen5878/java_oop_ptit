public class Transaction extends Thread {
    private CustomerAccount account1;
    private CustomerAccount account2;
    private double amount;

    public Transaction(CustomerAccount account1, CustomerAccount account2, double amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (account1) {
            synchronized (account2) {
                if (account1.getBalance() >= amount) {
                    account1.setBalance(account1.getBalance() - amount);
                    account2.setBalance(account2.getBalance() + amount);
                }
            }
        }
    }
}