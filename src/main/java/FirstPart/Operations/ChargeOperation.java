package FirstPart.Operations;

public class ChargeOperation implements Operation{
    private double balance;
    private double amount;

    public ChargeOperation(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    @Override
    public double perform() {
        if (this.balance - amount < 0) {
            System.out.println("Недостаточно средств на счёте! Баланс: " + this.balance);
            return balance;
        }
        System.out.println("Снятие денег с баланса: " + amount);
        return balance - amount;
    }
}
