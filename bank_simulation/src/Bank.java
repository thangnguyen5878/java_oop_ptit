public class Bank {
    public static void main(String[] args) {
        CustomerAccount account1 = new CustomerAccount(123456, 1000);
        CustomerAccount account2 = new CustomerAccount(789012, 1000);

        Transaction transaction1 = new Transaction(account1, account2, 300);
        Transaction transaction2 = new Transaction(account2, account1, 300);

        account1.displayBalance();
        account2.displayBalance();

        transaction1.start();
        transaction2.start();

        try {
            transaction1.join();
            transaction2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account1.displayBalance();
        account2.displayBalance();
    }
}
