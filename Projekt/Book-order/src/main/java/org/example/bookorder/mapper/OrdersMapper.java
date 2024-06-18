//package org.example.bookorder.mapper;
//
//import org.mapstruct.*;
//import pl.bookstore.bookorder.model.BookToOrder;
//import pl.bookstore.model.BookToOrderDetails;
//import pl.bookstore.model.BookToOrderRequest;
//import pl.bookstore.model.BookToOrderRequest;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
//public interface OrdersMapper {
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "quantity", ignore = true)
//    BookToOrder toEntity(BookToOrderRequest bookToOrderRequest);
//
//    BookToOrderDetails toDetails(BookToOrder bookToOrder);
//}