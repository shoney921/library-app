package com.group.libraryapp.repository.book;

import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepository implements BookRepository {

    public void saveBook() {
        System.out.println("Memory repository");
    }

}
