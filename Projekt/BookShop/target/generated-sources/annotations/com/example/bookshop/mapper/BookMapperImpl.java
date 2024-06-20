package com.example.bookshop.mapper;

import com.example.bookshop.model.Book.Author;
import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.model.Book.BookResponse;
import com.example.bookshop.model.Order.BookOrder;
import com.example.bookshop.model.Order.BookOrderCreateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T12:03:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toBookEntity(BookCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Book book = new Book();

        book.setName( request.getName() );
        book.setGenre( request.getGenre() );
        book.setPrice( request.getPrice() );
        book.setPages( request.getPages() );
        book.setAvailable( request.getAvailable() );

        return book;
    }

    @Override
    public void updateEntity(BookCreateRequest book, Book old) {
        if ( book == null ) {
            return;
        }

        old.setName( book.getName() );
        old.setGenre( book.getGenre() );
        old.setPrice( book.getPrice() );
        old.setPages( book.getPages() );
        old.setAvailable( book.getAvailable() );
    }

    @Override
    public BookResponse toResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        Author author = null;
        String name = null;
        String genre = null;
        double price = 0.0d;
        int pages = 0;
        int views = 0;
        int available = 0;

        author = book.getAuthor();
        name = book.getName();
        genre = book.getGenre();
        price = book.getPrice();
        pages = book.getPages();
        views = book.getViews();
        available = book.getAvailable();

        BookResponse bookResponse = new BookResponse( name, genre, price, pages, views, available, author );

        return bookResponse;
    }

    @Override
    public BookOrder toOrderEntity(BookOrderCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        BookOrder bookOrder = new BookOrder();

        bookOrder.setId( request.getId() );
        bookOrder.setOrdering_user( request.getOrdering_user() );
        bookOrder.setBook( request.getBook() );
        bookOrder.setQuantity( request.getQuantity() );

        return bookOrder;
    }
}
