package org.example.bookorder.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.example.bookorder.model.BookToOrderDetails;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrdersMapper {

    @Mapping(target = "id", expression = "java(extractId(responses))")
    @Mapping(target = "name", expression = "java(extractName(responses))")
    @Mapping(target = "views", expression = "java(extractViews(responses))")
    BookToOrderDetails toDetails(Response responses);

    default UUID extractId(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = response.body().toString();
            Map<String, Object> responseBody = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            return UUID.fromString((String) responseBody.get("id"));
        } catch (IOException e) {
            e.printStackTrace();
            return UUID.randomUUID();
        }
    }
    default String extractName(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = response.body().toString();
            Map<String, Object> responseBody = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            // Assuming name is a String
            return (String) responseBody.get("name");  // Adjust as per your response structure
        } catch (IOException e) {
            e.printStackTrace();
            return "Default Book Name";  // Handle or throw exception based on your application logic
        }
    }
    default int extractViews(Response response) {
        // Example: Extracting views from response body as JSON
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = response.body().toString();
            Map<String, Object> responseBody = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
            // Assuming views is an integer
            return (int) responseBody.get("views");  // Adjust as per your response structure
        } catch (IOException e) {
            e.printStackTrace();
            return 0;  // Handle or throw exception based on your application logic
        }
    }



}