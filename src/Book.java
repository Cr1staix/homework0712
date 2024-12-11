import java.util.Objects;

/**
 * Класс создает объект типа Book, содержит методы для управления его состоянием.
 */
public class Book {
    private final Integer id;
    private String title;
    private String author;
    private Boolean isAvailable;

    public Book(Integer id, String title, String author, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isAvailable, book.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isAvailable);
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + isAvailable
                + "\n";
    }
}
