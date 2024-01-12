package entity;

import controller.BankController;

public class BankStaff extends Person {
    private String employeeId;
    private final BankController bankController = new BankController();

    public BankStaff(String name, String address, String employeeId) {
        super(name, address);
        this.employeeId = employeeId;
    }

    public void openAccount(Customer customer) {
        bankController.openAccount(customer);
    }

    public void closeAccount(Customer customer) {
        bankController.closeAccount(customer);
    }
    public void deposit(double amount, Customer customer) {
        bankController.deposit(customer, amount);
    }

    public void withdraw(double amount, Customer customer) {
        bankController.withdraw(customer, amount);
    }

    public void transfer(double amount, Customer destination, Customer customer) {
        bankController.withdraw(customer, amount);
    }

    public double checkBalance(Customer customer) {
        return bankController.checkBalance(customer);
    }

    public void applyLoan(double amount, double rate, int days, Customer customer) {
        bankController.applyLoan(customer, amount, rate, days);
    }

}
