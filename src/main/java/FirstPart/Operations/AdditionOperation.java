package FirstPart.Operations;

import FirstPart.TerminalServer;

public class AdditionOperation implements Operation {
    private double balance;
    private double amount;

    public AdditionOperation(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    @Override
    public double perform() {
        System.out.println("Внесение денег на баланс: " + amount);
        return balance + amount;
    }
}
