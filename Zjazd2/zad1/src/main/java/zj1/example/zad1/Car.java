package zj1.example.zad1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import zj1.example.zad1.CarResponse;

import java.util.UUID;
@Entity
@Data
@Getter@Setter
public class Car {

    @Id
    @UuidGenerator
    private UUID Id;
    private String name;
    private int yearOfProduction;
    private String history;

    public CarResponse toCarResponse() {
        CarResponse response = new CarResponse();
        response.setName(this.name);
        response.setYearOfProduction(this.yearOfProduction);
        response.setHistory(this.history);
        return response;
    }
}

