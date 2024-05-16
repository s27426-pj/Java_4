package zj1.example.zad1.mapper;

import org.mapstruct.*;
import zj1.example.zad1.model.Car;
import zj1.example.zad1.model.CarCreateRequest;
import zj1.example.zad1.model.CarResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "history", ignore = true)
    Car toEntity(CarCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "history", ignore = true)
    Car updateEntity(CarCreateRequest car);

    @Mapping(target = "lastViews", ignore = true)
    CarResponse toResponse(Car car);

    @Mapping(target = "lastViews", ignore = true)
    @Mapping(target = "history", ignore = true)
    CarResponse toResponseBasic(Car car);
}
