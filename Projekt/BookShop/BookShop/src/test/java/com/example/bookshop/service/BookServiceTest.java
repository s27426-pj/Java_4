package com.example.bookshop.service;

import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.repository.BookOrderRepository;
import com.example.bookshop.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookMapper mapper;
    @InjectMocks
    private BookService bookService;

    @Test
    void addBook() {
        BookCreateRequest request = new BookCreateRequest();
        Book book = new Book();
        when(mapper.toBookEntity(request)).thenReturn(book);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book result = bookService.addBook(request);

        assertNotNull(result);
        verify(bookRepository, times(1)).save(book);
    }

}