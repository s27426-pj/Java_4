package zj1.example.zad1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zj1.example.zad1.model.CarClass;

@Repository
public interface ClassRepository extends JpaRepository<CarClass, String> {
    String findClassByName(String  Name);
    String findAllByName(String Name);
}