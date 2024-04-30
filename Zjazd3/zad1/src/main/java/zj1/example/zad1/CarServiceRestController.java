package zj1.example.zad1;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarServiceRestController {
    private final CarService carService;

    public CarServiceRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/basic")
    public List<CarCreateRequest> getAllCarsBasicInfo() {
        List<CarCreateRequest> cars = carService.getAllCarsBasic();
        return cars;
    }


    @GetMapping("/full")
    public List<CarResponse> getAllCars() {
        List<CarResponse> cars = carService.getAllCars();
        return cars;
    }

    @PostMapping
    public Car addCar(@RequestBody CarCreateRequest carCreateRequest) {
        Car car = carService.addCar(carCreateRequest);
        return car;
    }
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable UUID id, @RequestBody CarCreateRequest carCreateRequest) {
        Car car = carService.updateCar(id, carCreateRequest);
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
    }
}
