package org.example.bookorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Orders {

    @Id
    @UuidGenerator
    private UUID Id;

    UUID book_id;

    int quantity;
}
