package com.ismadrade.libraryapi.api.exception;

import com.ismadrade.libraryapi.api.model.entity.Book;

public class BusinessException extends RuntimeException {
    public BusinessException(String s) {
        super(s);
    }
}
