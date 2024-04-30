package zj1.example.zad1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    default Car foundOrThrowException(UUID id){
        findById(id).orElseThrow(CarNotFoundException);
    }
}