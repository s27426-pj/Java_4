package zj1.example.zad1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;
@Entity
@Data
public class Car {

    @Id
    @UuidGenerator
    private UUID Id;
    private String name;
    private int yearOfProduction;
    private String history;

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getHistory() {
        return history;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return Id;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        Id = id;
    }
}

