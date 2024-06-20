package com.example.bookshop.mapper;

import com.example.bookshop.model.Book.Author;
import com.example.bookshop.model.Book.Book;
import com.example.bookshop.model.Book.BookCreateRequest;
import com.example.bookshop.model.Book.BookResponse;
import com.example.bookshop.model.Order.BookOrder;
import com.example.bookshop.model.Order.BookOrderCreateRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "views", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book toBookEntity(BookCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "views", ignore = true)
    @Mapping(target = "author", ignore = true)
    void updateEntity(BookCreateRequest book,@MappingTarget Book old);

    @Mapping(target = "author", source = "author")
    BookResponse toResponse(Book book);

    default String map(Author author) {
        return author != null ? author.getName() + " " + author.getSurname() : null;
    }

    BookOrder toOrderEntity(BookOrderCreateRequest request);
}
