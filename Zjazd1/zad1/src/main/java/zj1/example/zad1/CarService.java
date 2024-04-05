package zj1.example.zad1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car addCar(CarCreateRequest carCreateRequest) {
        Car car = new Car();
        car.setName(carCreateRequest.getName());
        car.setYearOfProduction(carCreateRequest.getYearOfProduction());
        return carRepository.save(car);
    }

    public Car updateCar(Long id, CarCreateRequest carCreateRequest) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity doesn't exist"));
        car.setName(carCreateRequest.getName());
        car.setYearOfProduction(carCreateRequest.getYearOfProduction());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        } else {
            throw new RuntimeException("Car with id " + id + " doesn`t exist");
        }
    }
}

