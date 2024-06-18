package com.example.bookshop.repository;

import com.example.bookshop.model.Order.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, UUID> {
    }