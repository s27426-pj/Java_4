package com.example.bookshop.controller;

import com.example.bookshop.feign.model.BooksToOrder;
import com.example.bookshop.login.model.AdminPermission;
import com.example.bookshop.login.model.UserPermission;
import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.model.Book.BookResponse;
import com.example.bookshop.model.Order.BookOrder;
import com.example.bookshop.model.Order.BookOrderCreateRequest;
import com.example.bookshop.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookshop")
public class BookServiceRestController {
    private final BookService bookService;

    public BookServiceRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @UserPermission
    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable UUID id) {
        return bookService.getBookById(id);
    }

    @UserPermission
    @GetMapping("/search")
    public List<BookResponse> getFilteredBooks(String surname){
        return bookService.filteredBooks(surname);
    }

    @AdminPermission
    @PostMapping
    public Book addBook(@RequestBody BookCreateRequest bookCreateRequest) {
        return bookService.addBook(bookCreateRequest);
    }

    @AdminPermission
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody BookCreateRequest bookCreateRequest) {
        return bookService.updateBook(id, bookCreateRequest);
    }

    @AdminPermission
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
    }


    @AdminPermission
    @PostMapping("/order")
    public BookOrder addOrder(@RequestBody BookOrderCreateRequest bookOrder) {
        return bookService.orderBook(bookOrder);
    }

    @GetMapping("/books_to_order")
    public List<BooksToOrder> getBooksToOrder() {
        return bookService.getBooksToOrder();
    }
}
