package controller;

import exceptions.CustomerNotFoundException;
import entity.Customer;
import repository.BankDatabase;

import java.util.List;

public class BankController {
    private final BankDatabase bankDatabase = BankDatabase.getInstance();

    public BankController() {}

    public void openAccount(Customer customer) {
        bankDatabase.addCustomer(customer);
    }

    public void deposit(Customer customer, double amount) {
        bankDatabase.deposit(customer, amount);
    }


    public void withdraw(Customer customer, double amount) {
        bankDatabase.withdraw(customer, amount);
    }


    public void transfer(Customer customer, double amount, Customer destination) {
        bankDatabase.transfer(customer, amount, destination);
    }


    public double checkBalance(Customer customer) {
        try {
            return bankDatabase.checkBalance(customer);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }


    public void applyLoan(Customer customer, double amount, double rate, int days) {
        bankDatabase.applyLoan(customer, amount, rate, days);
    }


    public void closeAccount(Customer customer) {
        bankDatabase.removeCustomer(customer);
    }

    public List<Customer> getAccounts() {
        return bankDatabase.getAccounts();
    }
}
