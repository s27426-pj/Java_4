package com.example.bookshop.login.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Builder
@Setter
@Entity
@Table(name = "User_login")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String email;
    private String role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
