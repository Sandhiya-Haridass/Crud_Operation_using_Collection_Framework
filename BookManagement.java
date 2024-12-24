package collectionframework;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Book class to represent a book entity
class Book {
    private int id;
    private String name;
    private String author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Name=" + name + ", Author=" + author + "]";
    }
}

public class BookManagement {
    private static ArrayList<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Book Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Search Book by Name");
            System.out.println("6. Sort Books by Name");
            System.out.println("7. Sort Books by ID");
            System.out.println("8. Exit");
            System.out.print("Enter the Operations: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook(sc);
                    break;
                case 4:
                    deleteBook(sc);
                    break;
                case 5:
                    Serachbook(sc);
                    break;
                case 6:
                    sortBooksByName();
                    break;
                case 7:
                    sortBooksById();
                    break;
                case 8:
                    System.out.println(" Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        sc.close();
    }

    // Method to add a new book
    private static void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        bookList.add(new Book(id, name, author));
        System.out.println("Book added successfully!");
    }

    // Method to view all books
    private static void viewBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    // Method to update an existing book
    private static void updateBook(Scanner sc) {
        System.out.print("Enter Book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (Book book : bookList) {
            if (book.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new author: ");
                String newAuthor = sc.nextLine();

                book.setName(newName);
                book.setAuthor(newAuthor);
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Method to delete a book
    private static void deleteBook(Scanner sc) {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        for (Book book : bookList) {
            if (book.getId() == id) {
                bookList.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    // Method to search a book by name
    private static void searchBook(Scanner sc) {
    	boolean found = false;
        System.out.print("Enter the name of the book to search: ");
        String name = sc.nextLine();
        
        for (Book book : bookList) {
            if (book.getName().contains(name)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with the given name!");
        }
    }

    // Method to sort books by name
    private static void sortBooksByName() {
        Collections.sort(bookList, Comparator.comparing(Book::getName));
        System.out.println("Books sorted by name:");
        viewBooks();
    }

    // Method to sort books by ID
    private static void sortBooksById() {
        Collections.sort(bookList, Comparator.comparingInt(Book::getId));
        System.out.println("Books sorted by ID:");
        viewBooks();
    }
}

