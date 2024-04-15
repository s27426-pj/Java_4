package zj1.example.zad1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarServiceRestController {
    private final CarService carService;

    public CarServiceRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/basic")
    public List<Map<String, Object>> getAllCarsBasicInfo() {
        List<Car> cars = carService.getAllCars();
        return cars.stream()
                .map(car -> {
                    Map<String, Object> basicInfo = new HashMap<>();
                    basicInfo.put("Name", car.getName());
                    basicInfo.put("Year", car.getYearOfProduction());
                    return basicInfo;
                })
                .collect(Collectors.toList());
    }


    @GetMapping("/full")
    public List<CarResponse> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return cars.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CarResponse addCar(@RequestBody CarCreateRequest carCreateRequest) {
        Car car = carService.addCar(carCreateRequest);
        return mapToResponse(car);
    }
    @PutMapping("/{id}")
    public CarResponse updateCar(@PathVariable Long id, @RequestBody CarCreateRequest carCreateRequest) {
        Car car = carService.updateCar(id, carCreateRequest);
        return mapToResponse(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
    private CarResponse mapToResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setName(car.getName());
        response.setHistory(car.getHistory());
        response.setYearOfProduction(car.getYearOfProduction());
        response.setLastViews(0);
        return response;
    }
}
