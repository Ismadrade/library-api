package com.ismadrade.libraryapi.model.repository;

import com.ismadrade.libraryapi.api.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
