/**
 * Класс для создания исключения, в случаях когда книга не найдена.
 */
public class BookNotListException extends RuntimeException {
    public BookNotListException(String message) {
        super(message);
    }
}
