package FirstPart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PinValidator {

    public String getPin() { // Метод возвращает 4-значный PIN
        String pin = "";
        while (pin.length() < 4) {
            int value = getValueFromConsole(pin.length() + 1);
            pin += value;
            System.out.println("Введённый пин-код: " + pin);
        }
       return pin;
    }

    public int getValueFromConsole(int index) { // Метод возвращает значение для ПИНа из консоли, обрабатывая кейсы со символами и цифрами вне диапазона 0 и 9
        System.out.print("Введите пин-код (" + index + "-ая цифра): ");
        Scanner scanner = new Scanner(System.in);
        int enterValue;
        try {
            enterValue = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вводите только цифры!");
            enterValue = getValueFromConsole(index);
        }
        if (enterValue <= 9 && enterValue >= 0) {
            return enterValue;
        } else {
            System.out.println("Введите 1 символ!");
            enterValue = getValueFromConsole(index);
        }
        return enterValue;
    }
}
