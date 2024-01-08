package FirstPart;

import FirstPart.exceptions.AccountIsLockedException;
import FirstPart.exceptions.WrongPinException;

public class Start {
    public static void main(String[] args) {

        TerminalImpl terminal = new TerminalImpl(); // Инициализация терминала

        String pin = "";
        boolean isPinCorrect = false;

        while (!isPinCorrect) {
            pin = terminal.getPin(); // Получаем ПИН из консоли
            try {
                isPinCorrect = terminal.isCorrectPin(pin); // Проверяем, правильно ли введён ПИН от аккаунта
            } catch (WrongPinException e) {
                e.getMessage();
            } catch (AccountIsLockedException e) {
                e.getMessage();
            }
        }

        terminal.menu();
    }
}
