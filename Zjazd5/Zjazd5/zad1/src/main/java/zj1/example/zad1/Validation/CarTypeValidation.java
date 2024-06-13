package zj1.example.zad1.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import zj1.example.zad1.repository.ClassRepository;

public class CarTypeValidation implements ConstraintValidator<ValidateCarClass, String> {
    private final ClassRepository classRepository;

    public CarTypeValidation(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public boolean isValid(String carClass, ConstraintValidatorContext constraintValidatorContext) {
        String CarClasses = classRepository.findAllByName(carClass);
        return CarClasses.contains(carClass);
    }
}