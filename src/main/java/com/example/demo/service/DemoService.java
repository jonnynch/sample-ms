package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.service.dao.DemoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Observed(name = "DemoService")
@Service
@Slf4j
public class DemoService {
    @Autowired
    private DemoDao dao;

    public Book upsertBook(Book book) {
        log.info("upsertBook: {}", book);
        dao.put(book);
        return book;
    }

    public void deleteBook(String id) {
        log.info("deleteBook: {}", id);
        dao.remove(id);
    }

    public List<Book> getBooks() {
        log.info("getBooks");
        return dao.getBooks();
    }

    public Book getBook(String id) {
        log.info("getBook: {}", id);
        return dao.get(id);
    }
}
