package com.company.GUI;

import com.company.database.RepositoryBook;
import com.company.database.RepositoryUser;
import com.company.model.Book;
import com.company.model.User;

import java.util.List;
import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Wypożycz książkę");
        System.out.println("3. Zarejestruj się");
        System.out.println("4. Zaloguj się");
        System.out.println("5. Dodaj książkę (ADMIN)");
        System.out.println("6. Wyjście");

        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                showAllBooks();
                showMenu();
                break;
            case "2":
                borrowBook();
                showMenu();
                break;
            case "3":
                register();
                showMenu();
                break;
            case "4":
                break;
            case "5":
                addBook();
                showMenu();
                break;
            case "6":
                System.exit(0);
            default:
                System.out.println("Podano niewłaściwe dane.");
                GUI.showMenu();
        }
    }

    private static void showAllBooks() {
        RepositoryBook repositoryBook = RepositoryBook.getInstance();
        List<Book> bookList = repositoryBook.getBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    private static void borrowBook() {
        System.out.println("Podaj tytuł książki:");
        String userInputTitle = scanner.nextLine();
        System.out.println("Podaj ilość sztuk:");
        int userInputPieces = Integer.parseInt(scanner.nextLine());
        RepositoryBook repositoryBook = RepositoryBook.getInstance();
        boolean result = repositoryBook.borrowBook(userInputTitle, userInputPieces);
        if (result) {
            System.out.println("Wypożyczono");
        } else {
            System.out.println("Wypożyczenie nieudane.");
        }
    }

    private static void addBook() {
        System.out.println("Podaj tytuł:");
        String bookTitle = scanner.nextLine();
        RepositoryBook repositoryBook = RepositoryBook.getInstance();
        Book bookFromDB = repositoryBook.findBook(bookTitle);
        if (bookFromDB != null) {
            System.out.println("Podaj ilość");
            try {
                int piecesToAdd = Integer.parseInt(scanner.nextLine());
                bookFromDB.setPieces(bookFromDB.getPieces() + piecesToAdd);
                System.out.println("Zwiększono ilość sztuk!");
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawne dane!");
                addBook();
            }
        } else {
            System.out.println("Podaj autora:");
            String authorInput = scanner.nextLine();
            System.out.println("Podaj ilość sztuk:");
            try {
                int piecesInput = Integer.parseInt(scanner.nextLine());
                Book book = new Book(bookTitle, authorInput, piecesInput);
                repositoryBook.addBookToDB(book);
                System.out.println("Książka dodana!");
            } catch (NumberFormatException e) {
                System.out.println("Podaj prawidłową ilość sztuk");
                addBook();
            }
        }
    }

    private static void register() {
        System.out.println("Podaj login");
        RepositoryUser repositoryUser = RepositoryUser.getInstance();
        String password = null;
        String name = null;
        String surname = null;
        String login = null;
        User.Role role = null;
        try {
            login = scanner.nextLine();
            User userFromDB = repositoryUser.findUser(login);
            if (userFromDB != null) {
                System.out.println("Login istnieje już w bazie. Zaloguj się! ");
            } else {
                System.out.println("Podaj hasło:");
                password = scanner.nextLine();
                System.out.println("Podaj imię: ");
                name = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                surname = scanner.nextLine();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wszystkie pola powinny być uzupełnione. ");
        }
        System.out.println("Podaj rolę (ADMIN/USER):");
        try {
            role = User.Role.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Podaj rolę w formacie ADMIN lub USER");
        }
        User newUser = new User(name, surname, role, login, password);
        repositoryUser.addUser(newUser);
        System.out.println("Dodano nowego użytkownika!");
    }
}
