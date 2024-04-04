package com.example.zaj0.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
// RestControler powtarzalne, strony
@Entity
@Data
public class Car {

    @Id
    @UuidGenerator
    private UUID Id;

    private String name;
    private int yearOfProduction;
    private String history;
}
