package com.ismadrade.libraryapi.service.impl;

import com.ismadrade.libraryapi.api.model.entity.Book;
import com.ismadrade.libraryapi.model.repository.BookRepository;
import com.ismadrade.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
