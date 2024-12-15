import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс создает объект типа Library. Класс реализовывает логику хранения и выдачи объектов типа Book.
 */
public class Library {
    Map<Integer, Book> books = new HashMap<>();

    /**
     * Метод для добавления книги в коллекцию.
     *
     * @param book Принимает параметр типа Book.
     */
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public String toString() {
        return books.toString();
    }

    /**
     * Метод для получения книги по ID.
     *
     * @param id В качестве параметра принимает ID, для поиска книги.
     * @return Возвращает книгу по-заданному ID.
     */
    public Book getBook(Integer id) {
        if (!books.containsKey(id)) {
            throw new BookNotListException("Книга с id " + id + " не найдена");
        }
        return books.get(id);
    }

    /**
     * Метод для получения списка доступных/недоступных книг.
     *
     * @param isAvailable В качестве параметра принимает параметр доступны/недоступны.
     * @param comparator  В качестве параметра принимает компаратор для сортировки списка.
     * @return Возвращает список книг.
     */
    public List<Book> getBook(Boolean isAvailable, Comparator<Book> comparator) {
        if (isAvailable) {
            return books.values().stream()
                    .filter(b -> b.getAvailable())
                    .sorted(comparator)
                    .toList();
        }
        return books.values().stream()
                .filter(b -> !b.getAvailable())
                .toList();

    }

    /**
     * Метод для получения списка всех книг, которые есть в Library.
     *
     * @param comparator В качестве параметра принимает компаратор для сортировки.
     * @return Возвращает список книг библиотеки.
     */
    public List<Book> getBooksList(Comparator<Book> comparator) {
        return books.values().stream()
                .sorted(comparator)
                .toList();
    }

    /**
     * Метод для получения количества всех книг.
     *
     * @return Возвращает информацию о количестве всех книг.
     */
    public String getNumberBooks() {
        return "Всего в библиотеке " + books.size() + " книг";
    }

    /**
     * Метод для получения количества доступных и недоступных книг.
     *
     * @return Возвращает информацию о количестве доступных и недоступных книг.
     */
    public String getNumberAvailableNotAvailable() {
        int available = (int) books.values().stream()
                .filter(b -> b.getAvailable())
                .count();
        int notAvailable = books.size() - available;
        return "На данный момент для получения доступны " + available + " книг(и)\n" +
                "К получению сейчас недоступно " + notAvailable + " книг(и)";
    }

    /**
     * Метод для получения информации о всех авторах, чьи книги представлены в библиотеке. Содержит только уникальных авторов.
     *
     * @return Возвращает список уникальных авторов.
     */
    public List<String> getAuthors() {
        return books.values().stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    /**
     * Метод для сортировки в группу книг по их доступности/недоступности к получению.
     *
     * @return Возвращает книги собранные в группу по признаку доступности/недоступности.
     */
    public Map<Boolean, List<Book>> getAvailableGroup() {
        return books.values().stream()
                .collect(Collectors.partitioningBy(b -> b.getAvailable()));
    }

    /**
     * Метод для группирования книг по автору.
     *
     * @return Возвращает книги собранные в группу по автору.
     */
    public Map<String, List<Book>> getAuthorGroup() {
        return books.values().stream()
                .collect(Collectors.groupingBy(b -> b.getAuthor()));
    }
}
