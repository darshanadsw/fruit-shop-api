package com.fruitshop.api.fruitshopapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private Date bDate;

    public Customer(String firstName, String lastName,Date bDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDate = bDate;
    }
}
