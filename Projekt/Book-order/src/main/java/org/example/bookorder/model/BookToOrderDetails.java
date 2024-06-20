package org.example.bookorder.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter@Setter
public class BookToOrderDetails {
    private UUID id;
    private String name;
    private int views;
}
