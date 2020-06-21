package com.fruitshop.api.fruitshopapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer id;

    @NotNull
    @Size(max = 10,message = "First name should be less than 10 characters")
    private String firstName;

    @NotNull
    @Size(max = 10,message = "Last name should not be grater than 10 character")
    private String lastName;


    private String birthDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date test;


    @JsonProperty("customer_url")
    private String customerUrl;
}
