package zj1.example.zad1;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper mapper;
    public CarService(CarRepository carRepository, CarMapper mapper) {
        this.carRepository = carRepository;
        this.mapper = mapper;
    }

    public List<CarResponse> getAllCars() {
        return carRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public List<CarCreateRequest> getAllCarsBasic(){
        return carRepository.findAll().stream().map(mapper::toResponseBasic).collect(Collectors.toList());
    }
    public Car addCar(CarCreateRequest carCreateRequest) {

        Car entity = mapper.toEntity(carCreateRequest);

        return carRepository.save(entity);
    }

    public Car updateCar(Long id, CarCreateRequest carCreateRequest) {

        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity don't exist"));

        Car entity = mapper.updateEntity(carCreateRequest);

        Car saved = carRepository.save(entity);

        return saved;
    }

    public void deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        } else {
            throw new RuntimeException("Car with id " + id + " don`t exist");
        }
    }
}

