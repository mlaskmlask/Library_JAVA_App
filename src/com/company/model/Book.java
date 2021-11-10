package com.company.model;

public class Book {
    private String title;
    private String author;
    private int pieces;

    public Book(String title, String author, int pieces) {
        this.title = title;
        this.author = author;
        this.pieces = pieces;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
