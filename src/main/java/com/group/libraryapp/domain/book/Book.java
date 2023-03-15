package com.group.libraryapp.domain.book;

public class Book {

    String name;
    Integer count;

    public String getName() {
        return name;
    }
    public Integer getCount() {
        return count;
    }
    public Book(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}
