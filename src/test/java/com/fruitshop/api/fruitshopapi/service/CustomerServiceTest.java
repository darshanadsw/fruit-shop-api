package com.fruitshop.api.fruitshopapi.service;

import com.fruitshop.api.fruitshopapi.domain.Customer;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import com.fruitshop.api.fruitshopapi.domain.mapper.CustomerMapper;
import com.fruitshop.api.fruitshopapi.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@EnableAutoConfiguration
@SpringBootTest(classes = {CustomerService.class,CustomerMapper.class})
@ComponentScan(basePackages = "com.fruitshop.api.fruitshopapi")
@EntityScan(basePackages = "com.fruitshop.api.fruitshopapi.domain")
@EnableJpaRepositories(basePackages = "com.fruitshop.api.fruitshopapi.repository")
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void getAllCustomers() {

        Customer c1 = new Customer("Darshana","Welikala",Date.from(LocalDate.of(1982,4,21).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Customer c2 = new Customer("Hasaru","Welikala",Date.from(LocalDate.of(2014,4,9).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        customerRepository.save(c1);
        customerRepository.save(c2);

        List<CustomerDto> result = customerService.getAllCustomers();

        assertNotNull(result);
        assertEquals(5,result.size());
    }

    @Test
    void findCustomerById() {
        Customer c1 = new Customer("Darshana","Welikala",Date.from(LocalDate.of(1982,4,21).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Customer c2 = new Customer("Hasaru","Welikala",Date.from(LocalDate.of(2014,4,9).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        customerRepository.save(c1);
        customerRepository.save(c2);

        CustomerDto result = customerService.findCustomerById(c1.getId());

        assertNotNull(result);
        assertEquals("Darshana",result.getFirstName());

    }

    @Test
    void findCustomer_when_not_found() {
        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,() -> {
            customerService.findCustomerById(100);
        });
        assertNotNull(ex);
        assertEquals("No Customer found",ex.getMessage());
    }

    @Test
    void saveCustomer() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Darshana");
        customerDto.setLastName("Welikala");
        CustomerDto result = customerService.saveCustomer(customerDto);
        assertNotNull(result.getId());
    }
}
