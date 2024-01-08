package FirstPart;

import FirstPart.exceptions.AccountIsLockedException;
import FirstPart.exceptions.WrongPinException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    public String getPin() {
       return this.pinValidator.getPin();
    }

    public boolean isCorrectPin(String pin) throws WrongPinException, AccountIsLockedException {
        return this.server.isCorrectPin(pin);
    }

    public void menu() {
        this.server.menu();
    }

    public double getBalance() {
        return this.server.getBalance();
    }
}
