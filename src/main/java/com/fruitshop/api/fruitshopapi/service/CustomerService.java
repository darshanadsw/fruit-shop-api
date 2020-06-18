package com.fruitshop.api.fruitshopapi.service;

import com.fruitshop.api.fruitshopapi.domain.Customer;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import com.fruitshop.api.fruitshopapi.domain.mapper.CustomerMapper;
import com.fruitshop.api.fruitshopapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerDto> getAllCustomers(){
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto findCustomerById(Integer id){
        return customerRepository.findCustomerById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new RuntimeException("No Customer found"));
    }

    public CustomerDto saveCustomer(CustomerDto customerDto){
        Customer customer = customerMapper.toDomain(customerDto);
        customerRepository.save(customer);
        customerDto.setId(customer.getId());
        return customerDto;
    }

    public CustomerDto updateCustomer(Integer id,CustomerDto customerDto){
        Customer customer = customerRepository
            .findById(id).orElseThrow(()->new RuntimeException("Not found"));

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customerRepository.save(customer);

        return customerMapper.toDto(customer);

    }

    public CustomerDto patchCustomer(Integer id,CustomerDto customerDto){
        customerRepository.findById(id)
            .map(c -> {
            if(customerDto.getFirstName()!=null){
                c.setFirstName(customerDto.getFirstName());
            }
            if(customerDto.getLastName() != null){
                c.setLastName(customerDto.getLastName());
            }
                customerRepository.save(c);
                return customerMapper.toDto(c);
        }).orElseThrow(RuntimeException::new);
        return null;
    }
}
