# Java ATM Simulator

A console-based ATM simulator built using Java to practice Object-Oriented Programming (OOP), input validation, and basic banking operations.

## Features

- **Account authentication:** Verify account number and PIN.
- **PIN security:** Allow up to three login attempts.
- **Balance inquiry:** Check the current account balance.
- **Deposit:** Deposit money with amount validation.
- **Withdrawal:** Withdraw money while maintaining a minimum balance.
- **Transaction history:** Track deposits and withdrawals during the current session.
- **Multiple accounts:** Manage and search accounts using a `Bank` class.
- **Input validation:** Handle invalid menu choices and non-numeric amounts.

## OOP Concepts Used

- **Encapsulation:** Keep account data private and expose controlled methods.
- **Abstraction:** Define common account behavior using an abstract `Account` class.
- **Inheritance:** Extend `Account` through `SavingsAccount`.
- **Polymorphism:** Override the withdrawal method in `SavingsAccount`.
- **Collections:** Use `ArrayList` to store transaction history and accounts.

## Tech Stack

- Java
- Java Collections Framework
- File I/O: planned stretch goal

## How to Run

1. Install the JDK.
2. Clone this repository.
3. Open the project folder in your terminal.
4. Compile the Java files:

   ```bash
   javac Main.java Account.java SavingsAccount.java Bank.java
   ```

5. Run the application:

   ```bash
   java Main
   ```

## Sample Accounts

| Account Number | Demo PIN | Initial Balance |
|---|---|---:|
| 1001 | 1234 | ₹5,000 |
| 1002 | 5678 | ₹8,000 |

These are demonstration credentials for local testing only.

## Current Limitations

- Account balances reset when the program restarts.
- Transaction history is stored in memory and does not survive restarts.
- The application is a learning project, not a real banking system.

## Future Improvements

- Persist transaction history using file handling.
- Save and restore account balances.
- Add automated unit tests using JUnit.

## Author

Built as a Java OOP learning project.
