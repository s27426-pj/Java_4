# CarApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCar**](CarApi.md#addCar) | **POST** /car | Add a new car to the store
[**deleteCar**](CarApi.md#deleteCar) | **DELETE** /car/{name} | Deletes a car
[**getAllCarsBasicInfo**](CarApi.md#getAllCarsBasicInfo) | **GET** /carsBasic | Find all cars basic information
[**getAllCarsFullInfo**](CarApi.md#getAllCarsFullInfo) | **GET** /carsFull | Find all cars full information
[**updateCar**](CarApi.md#updateCar) | **PUT** /car/{name} | Update an existing car

<a name="addCar"></a>
# **addCar**
> addCar(body)

Add a new car to the store

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarApi;


CarApi apiInstance = new CarApi();
CarCreateRequest body = new CarCreateRequest(); // CarCreateRequest | 
try {
    apiInstance.addCar(body);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#addCar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CarCreateRequest**](CarCreateRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteCar"></a>
# **deleteCar**
> deleteCar(name)

Deletes a car

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarApi;


CarApi apiInstance = new CarApi();
String name = "name_example"; // String | 
try {
    apiInstance.deleteCar(name);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#deleteCar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllCarsBasicInfo"></a>
# **getAllCarsBasicInfo**
> List&lt;CarsBasic&gt; getAllCarsBasicInfo()

Find all cars basic information

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarApi;


CarApi apiInstance = new CarApi();
try {
    List<CarsBasic> result = apiInstance.getAllCarsBasicInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#getAllCarsBasicInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CarsBasic&gt;**](CarsBasic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllCarsFullInfo"></a>
# **getAllCarsFullInfo**
> List&lt;CarsFull&gt; getAllCarsFullInfo()

Find all cars full information

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarApi;


CarApi apiInstance = new CarApi();
try {
    List<CarsFull> result = apiInstance.getAllCarsFullInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#getAllCarsFullInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CarsFull&gt;**](CarsFull.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCar"></a>
# **updateCar**
> updateCar(body, name)

Update an existing car

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarApi;


CarApi apiInstance = new CarApi();
CarUpdateRequest body = new CarUpdateRequest(); // CarUpdateRequest | 
String name = "name_example"; // String | 
try {
    apiInstance.updateCar(body, name);
} catch (ApiException e) {
    System.err.println("Exception when calling CarApi#updateCar");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CarUpdateRequest**](CarUpdateRequest.md)|  |
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

