package com.example.demo.service.jpa;

import com.example.demo.service.jpa.model.BookEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@ConditionalOnBean(DataSource.class)
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
