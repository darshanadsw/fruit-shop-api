package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.Customer;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "customerUrl",expression = "java(\"/api/v1/customers/\" + source.getId())")
    CustomerDto toDto(Customer source);

    Customer toDomain(CustomerDto source);
}
