package com.fruitshop.api.fruitshopapi.domain;

import lombok.Data;

import java.util.List;

@Data
public class DomainObject {
    private String id;
    private Address address;

    private List<Order> orders;
}
