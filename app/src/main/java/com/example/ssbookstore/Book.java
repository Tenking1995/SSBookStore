package com.example.ssbookstore;

public class Book {
    String name, author, description, date;

    public Book() {
        name="";
        author="";
        description="";
        date="";
    }

    public Book(String name, String author, String description, String date) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
