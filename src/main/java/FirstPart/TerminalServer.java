package FirstPart;

import FirstPart.exceptions.AccountIsLockedException;
import FirstPart.exceptions.WrongPinException;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalServer implements Terminal{
    private final String pin = "0000";
    private double balance = 34610.0;
    private byte attemptsCount = 3;
    LocalDateTime lockedAt;

    public TerminalServer () {

    }

    public boolean isCorrectPin(String pin) throws AccountIsLockedException, WrongPinException {
        --attemptsCount; // Сразу списываем одну попытку ввода ПИНа
        if (attemptsCount < 1) { // Проверка, что все попытки использованы
            if (lockedAt == null) { // Если первая блокировка
                lockedAt = LocalDateTime.now(); // то задаём время блокировки
                throw new AccountIsLockedException(lockedAt); // и бросаем исключение
            } else if (LocalDateTime.now().isBefore(lockedAt.plusSeconds(10))) { // Если время блокировки уже было, то просто бросаем исключение
                throw new AccountIsLockedException(lockedAt);
            } else { // Если время блокировки прошло, то обнуляем счетчик попыток
                attemptsCount = 2;
            }
        }
        if (pin.equals(this.pin)) {
            System.out.println("Пин-код верный!");
            return true;
        } else {
            throw new WrongPinException(attemptsCount);
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void menu() {
        System.out.print("\nВыберите операцию:\n1. Внести сумму\n2. Снять деньги\n3. Проверить баланс\n");
        Scanner scanner = new Scanner(System.in);
        double amount;
        switch (scanner.nextInt()) {
            case 1:
                System.out.print("\nВведите сумму для внесения: ");
                amount = validateAmount();
                changeBalance(amount, "plus");
                menu();
            case 2:
                System.out.print("\nВведите сумму для снятия: ");
                amount = validateAmount();
                changeBalance(amount, "minus");
                menu();
            case 3:
                System.out.print("\nБаланс счёта: " + getBalance());
                menu();
        }
    }

    public void changeBalance(double amount, String operation) {
        if (operation.equals("minus")){
            this.balance -= amount;
            System.out.println("Снятие денег с баланса: " + amount);
        } else {
            this.balance += amount;
            System.out.println("Внесение денег на баланс: " + amount);
        }
    }

    private double validateAmount() {
        Scanner scanner = new Scanner(System.in);
        double amount;
        try {
            amount = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Вводите только цифры!");
            amount = validateAmount();
        }
        if (amount%100 != 0) {
            System.out.println("Введите сумму, кратную 100");
            amount = validateAmount();
        }
        return amount;
    }
}
