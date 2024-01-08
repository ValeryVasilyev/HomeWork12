package FirstPart;

public interface Terminal {
    default double getBalance() {
        return 0.0;
    }
    default double changeBalance() {
        return 0;
    }
}
