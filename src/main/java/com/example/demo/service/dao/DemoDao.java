package com.example.demo.service.dao;

import com.example.demo.model.Book;

import java.util.List;

public interface DemoDao {

    void put(Book book);

    void remove(String id);

    List<Book> getBooks();

    Book get(String id);
}
