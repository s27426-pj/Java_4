package org.example.bookorder.model;

import lombok.Data;

import java.util.UUID;

@Data
public class BookToOrderDetails {
    private UUID id;
    private String name;
    private int views;
}
