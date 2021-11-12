package com.company.database;

import com.company.model.Book;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBook {
    private List<Book> books = new ArrayList<>();

    private static final RepositoryBook repositoryBook = new RepositoryBook();

    private RepositoryBook() {
        books.add(new Book("Mistrz i Małgorzata", "Michaił Bułhakow", 10));
        books.add(new Book("Buszujący w Zbożu", "Jerome Salinger", 5));
        books.add(new Book("Rok 1984", "George Orwell", 7));
        books.add(new Book("Duma i Uprzedzenie", "Jane Austen", 10));
    }

    public static RepositoryBook getInstance() {
        return repositoryBook;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean borrowBook(String bookTitle, int pieces) {
        for (Book currentBook : this.books) {
            if (currentBook.getTitle().equals(bookTitle)) {
                if (currentBook.getPieces() >= pieces) {
                    currentBook.setPieces(currentBook.getPieces() - pieces);
                    return true;
                }
            }
        }
        return false;
    }

    public Book findBook(String title) {
        for (Book currentBook : this.books) {
            if (currentBook.getTitle().equals(title)) {
                return currentBook;
            }
        }
        return null;
    }

    public void addBookToDB(Book book) {
        this.books.add(book);
    }


}
