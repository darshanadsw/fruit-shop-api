package com.fruitshop.api.fruitshopapi.controllers;

import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDtoList;
import com.fruitshop.api.fruitshopapi.service.CustomerService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(value = "Customer API", tags = {"customers"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation(value = "List all customers",notes = "List all customers", tags = {"customers"})
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful fetch of all customers"),
            @ApiResponse(code = 500, message = "Backend server error")})
    @GetMapping
    public ResponseEntity<CustomerDtoList> getAllCustomers(){
        return ResponseEntity.ok(new CustomerDtoList(customerService.getAllCustomers()));
    }

    @ApiOperation(value = "Show a customer by his id" , tags = {"customers"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful fetch of customer by id"),
            @ApiResponse(code = 500, message = "Backend server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(customerService.findCustomerById(id));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(customerService.saveCustomer(customerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Integer id,@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateCustomer(id,customerDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto> patchCustomer(@PathVariable Integer id,@RequestBody CustomerDto customerDto){
        try{
            return ResponseEntity.ok(customerService.patchCustomer(id,customerDto));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}
