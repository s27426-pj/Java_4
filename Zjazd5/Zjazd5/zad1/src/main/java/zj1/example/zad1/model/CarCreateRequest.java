package zj1.example.zad1.model;

import lombok.Getter;
import lombok.Setter;
import zj1.example.zad1.Validation.ValidateCarClass;

@Getter@Setter
public class CarCreateRequest {
    private String name;
    private int yearOfProduction;
}