package com.example.bookshop.mapper;

import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.model.Book.BookResponse;
import com.example.bookshop.model.Order.BookOrder;
import com.example.bookshop.model.Order.BookOrderCreateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T08:34:34+0200",
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
    public Book updateEntity(BookCreateRequest book) {
        if ( book == null ) {
            return null;
        }

        Book book1 = new Book();

        book1.setName( book.getName() );
        book1.setGenre( book.getGenre() );
        book1.setPrice( book.getPrice() );
        book1.setPages( book.getPages() );
        book1.setAvailable( book.getAvailable() );

        return book1;
    }

    @Override
    public BookResponse toResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setAuthor( map( book.getAuthor() ) );
        bookResponse.setName( book.getName() );
        bookResponse.setGenre( book.getGenre() );
        bookResponse.setPrice( book.getPrice() );
        bookResponse.setPages( book.getPages() );
        bookResponse.setViews( book.getViews() );
        bookResponse.setAvailable( book.getAvailable() );

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
