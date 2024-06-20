package com.example.bookshop.service;

import com.example.bookshop.error.BookNotFoundException;
import com.example.bookshop.login.model.User;
import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.model.Book.Author;
import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.model.Book.BookResponse;
import com.example.bookshop.model.Order.BookOrder;
import com.example.bookshop.model.Order.BookOrderCreateRequest;
import com.example.bookshop.repository.BookOrderRepository;
import com.example.bookshop.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;
    @Mock
    private BookOrderRepository orderRepository;
    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBookSuccess() {
        UUID bookId = UUID.randomUUID();
        BookCreateRequest request = new BookCreateRequest("The Hobbit", "Fantasy", 29.99, 400, 10);
        Book mappedEntity = new Book(bookId, "The Hobbit", "Fantasy", 29.99, 400, 0, 0, null);

        when(bookMapper.toBookEntity(request)).thenReturn(mappedEntity);
        when(bookRepository.save(mappedEntity)).thenReturn(mappedEntity);

        Book addedBook = bookService.addBook(request);

        assertNotNull(addedBook);
        assertEquals(bookId, addedBook.getId());
        assertEquals("The Hobbit", addedBook.getName());
        assertEquals("Fantasy", addedBook.getGenre());
        assertEquals(29.99, addedBook.getPrice());
        assertEquals(400, addedBook.getPages());
        assertEquals(0, addedBook.getAvailable());
        assertEquals(0, addedBook.getViews());
        assertNull(addedBook.getAuthor());

        verify(bookMapper, times(1)).toBookEntity(request);
        verify(bookRepository, times(1)).save(mappedEntity);
    }
    @Test
    public void testGetBookByIdSuccess() {
        UUID bookId = UUID.randomUUID();
        Book book = new Book(bookId, "The Hobbit", "Fantasy", 29.99, 400, 0, 0, null);
        BookResponse expectedResponse = new BookResponse( "The Hobbit", "Fantasy", 29.99, 400,100,0,new Author(1,"A1","A1"));

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(bookMapper.toResponse(book)).thenReturn(expectedResponse);


        BookResponse actualResponse = bookService.getBookById(bookId);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getName(), actualResponse.getName());
        assertEquals(expectedResponse.getGenre(), actualResponse.getGenre());
        assertEquals(expectedResponse.getPrice(), actualResponse.getPrice());
        assertEquals(expectedResponse.getPages(), actualResponse.getPages());

        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    public void testGetBookByIdNotFound() {
        UUID invalidId = UUID.randomUUID();

        when(bookRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookById(invalidId);
        });

        verify(bookRepository, times(1)).findById(invalidId);
    }

    @Test
    public void testFilteredBooks() {
        String authorSurname = "Tolkien";
        Author author1 = new Author(1,"J.R.R.", "Tolkien");
        Author author2 = new Author(2,"Terry", "Pratchett");

        Book book1 = new Book(null, "The Hobbit", "Fantasy", 29.99, 400, 0, 0, author1);
        Book book2 = new Book(null, "Discworld", "Fantasy", 19.99, 300, 0, 0, author2);

        List<Book> books = Arrays.asList(book1, book2);


        when(bookRepository.findBooksByAuthor_SurnameContains(authorSurname)).thenReturn(books);
        when(bookMapper.toResponse(book1)).thenReturn(new BookResponse("The Hobbit", "Fantasy", 29.99, 400,20,120,author1));
        when(bookMapper.toResponse(book2)).thenReturn(new BookResponse( "Discworld", "Fantasy", 19.99, 300, 0, 0, author2));

        List<BookResponse> filteredBooks = bookService.filteredBooks(authorSurname);

        verify(bookRepository, times(1)).findBooksByAuthor_SurnameContains(authorSurname);
    }

    @Test
    public void testUpdateBookSuccess() {
        UUID bookId = UUID.randomUUID();
        BookCreateRequest request = new BookCreateRequest("Updated Book", "Fiction", 19.99, 300, 10);
        Book existingBook = new Book(bookId, "Original Book", "Fantasy", 29.99, 400, 5, 0, null);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        bookService.updateBook(bookId, request);

        verify(bookRepository, times(1)).findById(bookId);
        verify(bookMapper, times(1)).updateEntity(request, existingBook);
        verify(bookRepository, times(1)).save(existingBook);
    }

    @Test
    public void testUpdateBookNotFound() {
        UUID invalidId = UUID.randomUUID();
        BookCreateRequest request = new BookCreateRequest("The Hobbit", "Fantasy", 29.99, 400, 10);

        when(bookRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> {
            bookService.updateBook(invalidId, request);
        });

        verify(bookRepository, times(1)).findById(invalidId);
    }

    @Test
    public void testDeleteBookSuccess() {
        UUID bookId = UUID.randomUUID();

        when(bookRepository.existsById(bookId)).thenReturn(true);

        assertDoesNotThrow(() -> bookService.deleteBook(bookId));

        verify(bookRepository, times(1)).existsById(bookId);
        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    public void testDeleteBookNotFound() {
        UUID invalidId = UUID.randomUUID();

        when(bookRepository.existsById(invalidId)).thenReturn(false);

        assertThrows(BookNotFoundException.class, () -> {
            bookService.deleteBook(invalidId);
        });

        verify(bookRepository, times(1)).existsById(invalidId);
    }

    @Test
    public void testOrderBook() {
        UUID bookId = UUID.randomUUID();
        BookOrderCreateRequest request = new BookOrderCreateRequest();
        request.setId(bookId);
        request.setQuantity(1);
        request.setOrdering_user(new User());
        Book book = new Book(bookId, "The Hobbit", "Fantasy", 29.99, 400, 5, 0, null);
        BookOrder orderEntity = new BookOrder(request.getId(), request.getOrdering_user(),book, request.getQuantity());


        when(bookMapper.toOrderEntity(request)).thenReturn(orderEntity);
        when(bookRepository.save(book)).thenReturn(book);
        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        BookOrder savedOrder = bookService.orderBook(request);

        assertNotNull(savedOrder);
        assertEquals(orderEntity, savedOrder);

        verify(orderRepository, times(1)).save(orderEntity);
        assertEquals(4, book.getAvailable());
    }

}