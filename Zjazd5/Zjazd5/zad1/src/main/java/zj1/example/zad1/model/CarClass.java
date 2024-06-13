package zj1.example.zad1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarClass {
    String name;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
