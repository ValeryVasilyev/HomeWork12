package FirstPart.exceptions;

public class WrongPinException extends Throwable {
    public WrongPinException(byte attemptsCount){
        System.out.println("Пин-код НЕ верный!");
        System.out.println("Количество оставшихся попыток: " + attemptsCount);
    }
}
