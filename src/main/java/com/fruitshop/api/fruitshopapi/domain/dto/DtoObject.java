package com.fruitshop.api.fruitshopapi.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class DtoObject {
    private String id;
    private String street;
    private String city;
    private String postalCode;
    private String province;
    private List<OrderDto> clientOrders;
}
