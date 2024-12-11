import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(12, "The Player", "Dostoevsky", true);
        Book book2 = new Book(34, "Reviver", "Gogol", false);
        Book book3 = new Book(22, "War and Peace", "Tolstoy", true);
        Book book4 = new Book(48, "Anna Karenina", "Tolstoy", true);
        Book book5 = new Book(7, "Student", "Chekhov", false);


        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);


        System.out.println(library.getBooksList((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())));
        System.out.println();


        System.out.println(getBook(library, 1));
        System.out.println(getBook(library, 12));
        System.out.println(getBook(library, 22));
        System.out.println(getBook(library, 88));
        System.out.println();

        System.out.println(library.getBook(true, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor())));
        System.out.println(library.getBook(false, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor())));
        System.out.println();


        System.out.println(library.getNumberBooks());
        System.out.println(library.getNumberAvailableNotAvailable());
        System.out.println();


        System.out.println(library.getAuthors());

    }

    public static Book getBook(Library library, Integer id) {
        try {
            return library.getBook(id);
        } catch (BookNotListException e) {
            return new Book(-1, "Книга не найдена", "Неизвестно", false);
        }
    }
}