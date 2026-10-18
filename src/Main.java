
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create bank and sample accounts
        Bank bank = new Bank();

        bank.addAccount(new SavingsAccount("1001", "1234", 5000));
        bank.addAccount(new SavingsAccount("1002", "5678", 8000));

        // Step 1: Find account
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = bank.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            sc.close();
            return;
        }

        // Step 2: Authenticate PIN
        int attempts = 0;
        boolean authenticated = false;

        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            String enteredPin = sc.nextLine();

            if (account.validatePin(enteredPin)) {
                authenticated = true;
                System.out.println("Login successful!");
                break;
            }

            attempts++;
            System.out.println(
                    "Incorrect PIN. Attempts left: " + (3 - attempts)
            );
        }

        if (!authenticated) {
            System.out.println("Too many attempts. Access denied.");
            sc.close();
            return;
        }

        // Step 3: ATM menu
        int choice = 0;

        do {
            System.out.println("\n===== ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(
                            "Your balance is: " + account.getBalance()
                    );
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    try {
                        double amount =
                                Double.parseDouble(sc.nextLine());
                        account.deposit(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    try {
                        double amount =
                                Double.parseDouble(sc.nextLine());
                        account.withdraw(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid amount!");
                    }
                    break;

                case 4:
                    System.out.println("===== Transaction History =====");
                    for (String transaction : account.getTransactions()) {
                        System.out.println(transaction);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
