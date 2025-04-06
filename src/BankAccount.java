/**
 * Description: Bank Account Management System Group Lab 4
 * This program implements a bank account with deposit, withdrawal,
 * and statement functionality using  Calendar method.
 * @author Michael Polk
 * @author Berk Enul
 * Date: April 01, 2025
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private StringBuilder transactions;
    private static int nextAccountNumber = 1000;
    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    /**
     * Default constructor - initializes account with zero balance
     */
    public BankAccount() {
        this.accountNumber = nextAccountNumber++;
        this.balance = 0.0;
        this.transactions = new StringBuilder();
        recordTransaction("Account created", 0.0);
    }

    /**
     * Overloaded constructor - initializes account with specified balance
     * @param initialBalance The initial amount to deposit
     */
    public BankAccount(double initialBalance) {
        this.accountNumber = nextAccountNumber++;
        this.balance = 0.0;
        this.transactions = new StringBuilder();
        recordTransaction("Account created", 0.0);
        if (initialBalance > 0) {
            deposit(initialBalance);
        }
    }
      /**
 * Records a transaction with a timestamp.
 * @param type The type of transaction (e.g., Deposit, Withdraw)
 * @param amount The amount involved in the transaction
 */
private void recordTransaction(String type, double amount) {
    Calendar calendar = Calendar.getInstance();
    String timestamp = dateFormat.format(calendar.getTime());
    transactions.append(type)
                .append(": $")
                .append(String.format("%.2f", amount))
                .append(" on ")
                .append(timestamp)
                .append("\n");
}

/**
 * Deposits a positive amount into the account.
 * @param amount The amount to deposit
 */
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        recordTransaction("Deposit", amount);
    } else {
        System.out.println("Deposit amount must be positive.");
    }
}

/**
 * Withdraws a specified amount if sufficient balance exists.
 * @param amount The amount to withdraw
 */
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        recordTransaction("Withdraw", amount);
    } else if (amount <= 0) {
        System.out.println("Withdraw amount must be positive.");
    } else {
        System.out.println("Insufficient balance.");
    }
}

/**
 * Returns the current account balance.
 * @return The current balance
 */
public double getBalance() {
    return balance;
}

/**
 * Returns the transaction history.
 * @return All recorded transactions
 */
public String getStatement() {
    return transactions.toString();
}
}


