package com.fruitshop.api.fruitshopapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;
    private String firstName;
    private String lastName;
    @JsonProperty("customer_url")
    private String customerUrl;
}
