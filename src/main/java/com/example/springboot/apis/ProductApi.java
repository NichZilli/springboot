package com.example.springboot.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;

import java.util.List;
import java.util.UUID;

@Tag(name = "Products", description = "Endpoints related to Products entity in the API")
public interface ProductApi {

    @Operation(summary = "Fetch all Products",
               method = "GET",
               description = "Fetches all **Product** entities and their data from data source.")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<ProductModel>> getAllProducts();

    @Operation(
            summary = "Create a Product",
            method = "POST",
            description = "Create a **Product** and add to the *list* of products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "422", description = "unprocessable entity")
    })
    ResponseEntity<ProductModel> saveProduct(@RequestBody ProductRecordDto productRecord);

    @Operation(summary = "Get a Product",
               method = "GET",
               description = "Get a **Product** with your **ID** from data source, and return it.")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation"),
      @ApiResponse(responseCode = "404", description = "not found")
    })
    ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id);

    @Operation(summary = "Update a Product",
               method = "PUT",
               description = "Update a **Product** passing the **ID** from data source on *path*, and with the required fields.")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation"),
      @ApiResponse(responseCode = "404", description = "not found"),
      @ApiResponse(responseCode = "422", description = "unprocessable entity")
    })
    ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody ProductRecordDto productRecordDto);

    @Operation(summary = "Delete a Product",
               method = "DELETE",
               description = "Delete a **Product** passing the **ID** from data source on *path*, removing from database.")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "successful operation"),
      @ApiResponse(responseCode = "404", description = "not found")
    })
    ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id);
}
