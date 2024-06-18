package com.example.bookshop.service;

import com.example.bookshop.error.BookNotFoundException;
import com.example.bookshop.error.ForbiddenException;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookOrderRepository orderRepository;
    private final BookMapper mapper;

    public BookService(BookRepository bookRepository, BookOrderRepository orderRepository, BookMapper mapper) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
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
        return bookRepository.findBooksByAuthor_SurnameContains(surname).stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @NotNull
    public Book addBook(BookCreateRequest bookCreateRequest) {
        checkAdminPermissions();

        Book entity = mapper.toBookEntity(bookCreateRequest);

        return bookRepository.save(entity);
    }

    @NotNull
    public Book updateBook(UUID id, BookCreateRequest bookCreateRequest) {
        checkAdminPermissions();

        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " don`t exist"));

        Book entity = mapper.updateEntity(bookCreateRequest);

        Book saved = bookRepository.save(entity);

        return saved;
    }
    @NotNull
    public void deleteBook(UUID id) {
        checkAdminPermissions();
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

    private void checkAdminPermissions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            throw new ForbiddenException("Access denied. Admin permission required.");
        }
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
