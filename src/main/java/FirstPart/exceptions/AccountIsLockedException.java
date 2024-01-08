package FirstPart.exceptions;

import java.time.Duration;
import java.time.LocalDateTime;

public class AccountIsLockedException extends Throwable {

    public AccountIsLockedException(LocalDateTime lockedAt) {
        LocalDateTime unlockedAt = lockedAt.plusSeconds(10);
        LocalDateTime now = LocalDateTime.now();
        Duration lockedTimeLast = Duration.between(now, unlockedAt);
        System.out.println("Превышено количество попыток ввода пин-кода!");
        System.out.println("Аккаунт заблокирован на " + lockedTimeLast.getSeconds() + " сек.");
    }
}
