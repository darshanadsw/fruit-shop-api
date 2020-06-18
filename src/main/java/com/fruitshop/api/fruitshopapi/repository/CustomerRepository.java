package com.fruitshop.api.fruitshopapi.repository;

import com.fruitshop.api.fruitshopapi.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    List<Customer> findAll();
    Optional<Customer> findCustomerById(Integer id);
}
