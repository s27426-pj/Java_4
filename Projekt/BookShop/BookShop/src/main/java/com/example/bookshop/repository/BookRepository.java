package com.example.bookshop.repository;

import com.example.bookshop.model.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findBooksByAuthor_SurnameContains(String surname);
}