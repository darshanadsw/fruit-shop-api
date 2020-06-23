package com.fruitshop.api.fruitshopapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fruitshop.api.fruitshopapi.validators.DateValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer id;

    @ApiModelProperty(name = "firstName", required = true, value = "First name of the customer")
    @NotNull
    @Size(max = 10,message = "First name should be less than 10 characters")
    private String firstName;

    @NotNull
    @ApiModelProperty(name = "lastName", required = true, value = "Last name of the customer")
    @Size(max = 10,message = "Last name should not be grater than 10 character")
    private String lastName;

    @ApiModelProperty(value = "Birth date of the customer", required = false)
    @DateValidator(pattern = "yyyyMMdd", message = "Invalid birth date")
    private String birthDate;

    @JsonProperty("customer_url")
    private String customerUrl;
}
