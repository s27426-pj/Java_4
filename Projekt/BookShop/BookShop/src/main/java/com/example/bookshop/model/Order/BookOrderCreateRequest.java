package com.example.bookshop.model.Order;

import com.example.bookshop.login.model.User;
import com.example.bookshop.model.Book.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter@Setter
public class BookOrderCreateRequest {
    private UUID Id;
    private User ordering_user;
    private Book book;
    int quantity;
}
