package zj1.example.zad1;

import org.mapstruct.*;

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


    CarCreateRequest toResponseBasic(Car car);
}
