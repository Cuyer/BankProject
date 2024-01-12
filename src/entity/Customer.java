package entity;

import controller.BankOperations;

public class Customer extends Person {

    private String accountNumber;
    private double balance;
    private Loan loan;

    public Customer(String name, String address, String accountNumber) {
        super(name, address);
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance > 0 && this.balance >= amount) {
            this.balance -= amount;
        } else {
         System.out.println("Not sufficient balance");
        }
    }

    public void transfer(double amount, Customer destination) {
        this.balance -= amount;
        destination.deposit(amount);
    }

    public double checkBalance() {
        return balance;
    }

    public void applyLoan(double amount, double rate, int days) {
        this.loan = new Loan(amount, rate, days);
        this.balance += amount;
    }

    public void getLoanInfo() {
        loan.getLoanInfo();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }
}
