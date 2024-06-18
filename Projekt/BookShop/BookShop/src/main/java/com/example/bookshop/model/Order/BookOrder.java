package com.example.bookshop.model.Order;

import com.example.bookshop.login.model.User;
import com.example.bookshop.model.Book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookOrder {

    @Id
    @UuidGenerator
    private UUID Id;
    @ManyToOne
    @JoinColumn(name = "User_login_id")
    private User ordering_user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    int quantity;

}
