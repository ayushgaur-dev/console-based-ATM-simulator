
public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber, String pin, double balance) {
        super(accountNumber, pin, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (balance - amount < MINIMUM_BALANCE) {
            System.out.println(
                    "Withdrawal denied! Minimum balance of Rs. 1000 must remain."
            );
            return;
        }

        balance -= amount;
        recordTransaction("Withdrawn: Rs. " + amount);
        System.out.println("Withdrawal successful!");
        System.out.println("Please collect your cash.");
    }
}
