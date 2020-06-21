package com.fruitshop.api.fruitshopapi.bootstrap;

import com.fruitshop.api.fruitshopapi.domain.Category;
import com.fruitshop.api.fruitshopapi.domain.Customer;
import com.fruitshop.api.fruitshopapi.repository.CategoryRepository;
import com.fruitshop.api.fruitshopapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        saveCategories();
        saveCustomers();
    }

    private Date getDateByLocalDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private void saveCustomers() {

        Customer c1 = new Customer("Darshana","Welikala",
                getDateByLocalDate(LocalDate.of(1982,4,21)));
        customerRepository.save(c1);
        Customer c2 = new Customer("Hasaru","Welikala",
                getDateByLocalDate(LocalDate.of(2014,4,9)));
        customerRepository.save(c2);
        Customer c3 = new Customer("Piumine","Wijekuruppu",
                getDateByLocalDate(LocalDate.of(1982,6,15)));
        customerRepository.save(c3);
    }

    private void saveCategories() {
        Category fruit = new Category();
        fruit.setName("Fruit");
        Category dried = new Category();
        dried.setName("Dried");
        Category exotic = new Category();
        exotic.setName("Exotic");
        Category nuts = new Category();
        nuts.setName("Nuts");
        Category fresh = new Category();
        fresh.setName("Fresh");

        categoryRepository.save(fruit);
        categoryRepository.save(dried);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
        categoryRepository.save(fresh);
    }
}
