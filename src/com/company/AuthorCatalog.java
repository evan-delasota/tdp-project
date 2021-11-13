package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorCatalog {
    private List<Book> list;
    private Book oldestBook;
    private String genre;
    private String author;

    public AuthorCatalog(String name, String genre) {
        this.author = author;
        this.genre = genre;
        list = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (isOldestBook(book)) {
            oldestBook = book;
        }
        list.add(book);
    }

    public boolean isOldestBook(Book book) {
        if (list.isEmpty()) {
            return true;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        try {
            Date currentBookInCatalog = sdf.parse(oldestBook.getDate());
            Date newlyAddedBook = sdf.parse(book.getDate());
            if (newlyAddedBook.before(currentBookInCatalog)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public Book getOldestBook() {
        return oldestBook;
    }

    public int getCollectionSize() {
        return list.size();
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }
}
