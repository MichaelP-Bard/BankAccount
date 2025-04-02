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


