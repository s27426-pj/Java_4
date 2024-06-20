package com.example.bookshop.service;

import com.example.bookshop.error.BookNotFoundException;
import com.example.bookshop.feign.model.BooksToOrder;
import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.model.Book.BookResponse;
import com.example.bookshop.model.Order.BookOrder;
import com.example.bookshop.model.Order.BookOrderCreateRequest;
import com.example.bookshop.repository.BookOrderRepository;
import com.example.bookshop.repository.BookRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService{
    private final BookRepository bookRepository;
    private final BookOrderRepository orderRepository;
    private final BookMapper mapper;

    public BookService(BookRepository bookRepository, BookOrderRepository orderRepository, BookMapper mapper) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public BookResponse getBookById(UUID id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setViews(book.getViews() + 1);
                    bookRepository.save(book);
                    return mapper.toResponse(book);
                })
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " don`t exist"));
    }

    public List<BookResponse> filteredBooks(String surname){
        return bookRepository.findBooksByAuthor_SurnameContains(surname).stream().
                map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @NotNull
    public Book addBook(BookCreateRequest bookCreateRequest) {
        Book entity = mapper.toBookEntity(bookCreateRequest);
        return bookRepository.save(entity);
    }

    @NotNull
    public Book updateBook(UUID id, BookCreateRequest bookCreateRequest) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " doesn't exist"));
        mapper.updateEntity(bookCreateRequest, existingBook);
        return bookRepository.save(existingBook);
    }
    @NotNull
    public void deleteBook(UUID id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException("Book with id " + id + " don`t exist");
        }
    }

    @NotNull
    public BookOrder orderBook(BookOrderCreateRequest bookOrderCreateRequest){
        BookOrder entity = mapper.toOrderEntity(bookOrderCreateRequest);
        Book book = entity.getBook();
        book.setAvailable(book.getAvailable() - 1);
        bookRepository.save(book);
        return orderRepository.save(entity);
    }

    public List<BooksToOrder> getBooksToOrder() {
    return bookRepository.findAll().stream()
            .filter(book -> book.getViews() >= 10)
            .map(book -> {
                int quantity = book.getViews() / 10;
                return new BooksToOrder(book.getId(), book.getName(), quantity);
            })
            .collect(Collectors.toList());
}
}
