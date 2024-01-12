package controller;

import Exceptions.CustomerNotFoundException;
import entity.Customer;

public interface BankOperations {
    void deposit(Customer customer, double amount);
    void withdraw(Customer customer, double amount);
    void transfer(Customer customer, double amount, Customer destination);
    double checkBalance(Customer customer) throws CustomerNotFoundException;
    void applyLoan(Customer customer, double amount, double rate, int days);
}
