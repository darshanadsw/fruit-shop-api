package com.fruitshop.api.fruitshopapi.controllers;

import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDtoList;
import com.fruitshop.api.fruitshopapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDtoList> getAllCustomers(){
        return ResponseEntity.ok(new CustomerDtoList(customerService.getAllCustomers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(customerService.findCustomerById(id));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
