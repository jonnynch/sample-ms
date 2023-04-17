package com.example.demo.controller;

import com.example.demo.api.DemoApi;
import com.example.demo.model.Book;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DemoApiController implements DemoApi {
    @Autowired
    private DemoService service;

    @Override
    public ResponseEntity<String> upsertBook(Book book) {
        return ResponseEntity.ok(service.upsertBook(book).getId());
    }

    @Override
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(service.getBooks());
    }

    @Override
    public ResponseEntity<Book> getBook(String id) {
        return ResponseEntity.ok(service.getBook(id));
    }

    @Override
    public ResponseEntity<Void> deleteBooks(String id) {
        service.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
