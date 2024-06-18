package com.example.bookshop.model.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Entity
@Data
@Getter@Setter
public class Book {

    @Id
    @UuidGenerator
    private UUID Id;

    private String name;
    private String genre;
    private double price;
    private int pages;
    private int available;
    private int views;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}

