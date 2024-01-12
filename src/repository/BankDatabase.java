package repository;

import exceptions.CustomerNotFoundException;
import controller.BankOperations;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankDatabase implements BankOperations {
    private static BankDatabase instance;
    private List<Customer> customers;

    private BankDatabase() {
        this.customers = new ArrayList<>();
    }

    public static BankDatabase getInstance() {
        if (instance == null) {
            instance = new BankDatabase();
        }
        return instance;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void deposit(Customer customer, double amount) {
        boolean foundMatch = false;
        for (Customer customerToDeposit : customers) {
            if (customerToDeposit.equals(customer)) {
                customerToDeposit.deposit(amount);
                foundMatch = true;
            }
        }
        if (!foundMatch) {
            System.out.println("Didn't find customer to deposit");
        }
    }

    @Override
    public void withdraw(Customer customer, double amount) {
        boolean foundMatch = false;
        for (Customer customerToWithdraw : customers) {
            if (customerToWithdraw.equals(customer)) {
                customerToWithdraw.withdraw(amount);
                foundMatch = true;
            }
        }
        if (!foundMatch) {
            System.out.println("Didn't find customer to withdraw money from");
        }
    }

    @Override
    public void transfer(Customer customer, double amount, Customer destination) {
        boolean foundMatchingCustomer = false;
        boolean foundMatchingDestination = false;
        Customer customerTransferFrom = null;

        for (Customer customerTransfer : customers) {
            if (customerTransfer.equals(customer)) {
                foundMatchingCustomer = true;
                customerTransferFrom = customerTransfer;
            }
            if (customerTransfer.equals(destination)) {
                foundMatchingDestination = true;
            }
        }

        if (foundMatchingCustomer && foundMatchingDestination) {
            customerTransferFrom.transfer(amount, destination);
        }

        if (!foundMatchingCustomer) {
            System.out.println("Didn't find customer to transfer from");
        } else if (!foundMatchingDestination) {
            System.out.println("Didn't find customer to transfer to");
        }

    }

    @Override
    public double checkBalance(Customer customer) throws CustomerNotFoundException {
        for (Customer customerToCheckBalance : customers) {
            if (customerToCheckBalance.equals(customer)) {
                return customerToCheckBalance.checkBalance();
            }
        }
        throw new CustomerNotFoundException("Customer not found");
    }

    @Override
    public void applyLoan(Customer customer, double amount, double rate, int days) {
        boolean foundMatch = false;
        for (Customer customerToApplyLoan : customers) {
            if (customerToApplyLoan.equals(customer)) {
                customerToApplyLoan.applyLoan(amount, rate, days);
                foundMatch = true;
            }
        }
    }

    public List<Customer> getAccounts() {
        return customers;
    }
}
