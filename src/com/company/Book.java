package com.company;

public class Book {
    private String title;
    private String date;
    private String author;
    private int length;

    public Book() {}
    public Book(String title, String date, String author, int length) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.length = length;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
