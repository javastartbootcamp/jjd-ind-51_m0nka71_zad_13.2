public class IncorrectNumberException extends RuntimeException {

    public IncorrectNumberException() {
        super("Pierwsza liczba musi być dodatnia!");
    }
}
