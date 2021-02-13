package com.ismadrade.libraryapi.service;

import com.ismadrade.libraryapi.api.model.entity.Book;
import com.ismadrade.libraryapi.model.repository.BookRepository;
import com.ismadrade.libraryapi.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {
    BookService service;
    @MockBean
    BookRepository repository;

    @BeforeEach
    public void setup(){
        this.service = new BookServiceImpl(repository);
    }

    @Test
    @DisplayName("Deve Salvar um livro")
    public void deveSalvarUmLivro(){
        //cenário
        Book book = Book.builder().author("Fulano").title("As Aventuras").isbn("123").build();
        Mockito.when(repository.save(book)).thenReturn(Book.builder().id(11).author("Fulano").title("As Aventuras").isbn("123").build());
        //execução
        Book savedBook = service.save(book);
        //verificação
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo("123");
        assertThat(savedBook.getTitle()).isEqualTo("As Aventuras");
        assertThat(savedBook.getAuthor()).isEqualTo("Fulano");
    }
}
