package zj1.example.zad1.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Builder
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String email;
    private String role;
    @Id
    private Long id;
}
