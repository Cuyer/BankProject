package entity;

public class Loan {
    private double amount;
    private double interestRate;
    private int daysToRepay;

    public Loan(double amount, double interestRate, int daysToRepay) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.daysToRepay = daysToRepay;
    }

    public void getLoanInfo() {
        System.out.println("Amount: " + amount + " Interest rate: " + interestRate + " daysToRepay: " + daysToRepay);
    }
}
