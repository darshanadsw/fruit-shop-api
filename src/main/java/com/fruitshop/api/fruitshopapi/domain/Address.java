package com.fruitshop.api.fruitshopapi.domain;

import lombok.Data;

@Data
public class Address {
    private String street;
    private Integer streetNumber;
    private String city;
    private String postalCode;
    private String province;
}
