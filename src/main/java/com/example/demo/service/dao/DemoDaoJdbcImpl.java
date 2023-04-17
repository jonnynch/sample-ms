package com.example.demo.service.dao;

import com.example.demo.model.Book;
import com.example.demo.service.jpa.BookRepository;
import com.example.demo.service.jpa.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class DemoDaoJdbcImpl implements DemoDao {
    @Autowired
    private BookRepository repository;

    @Override
    public void put(Book book) {
        BookEntity bookEntity = book.getId() == null ? toEntity(book) : repository.findById(book.getId()).orElse(toEntity(book));
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        repository.save(bookEntity);
    }

    @Override
    public void remove(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Book> getBooks() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(this::toModel).toList();
    }

    @Override
    public Book get(String id) {
        return repository.findById(id).map(this::toModel).orElse(null);
    }

    private BookEntity toEntity(Book book) {
        return BookEntity.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    private Book toModel(BookEntity e) {
        Book book = new Book();
        book.setId(e.getId());
        book.setTitle(e.getTitle());
        book.setAuthor(e.getAuthor());
        return book;
    }
}
