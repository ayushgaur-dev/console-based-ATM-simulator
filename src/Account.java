import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private String pin;
    protected double balance;
    private List<String> transactions = new ArrayList<>();


    public Account(String accountNumber, String pin, double balance){
        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid deposit amount");
            return;
        }
        balance = balance + amount;
        transactions.add("Deposited: Rs. " + amount);

        System.out.println("Deposit of " + amount + " is successful!");
    }

    public abstract void withdraw(double amount);

    public List<String> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    protected void recordTransaction(String transaction) {
        transactions.add(transaction);
    }


}
