package com.example.projectbibleapp;

public class Model_books {
    String books;
    int color;

    public Model_books(String books, int color) {
        this.books = books;
        this.color = color;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getBooks() {
        return books;
    }

    public int getColor() {
        return color;
    }
}
