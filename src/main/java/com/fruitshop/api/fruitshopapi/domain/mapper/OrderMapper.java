package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.Order;
import com.fruitshop.api.fruitshopapi.domain.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "name", target = "productName")
    OrderDto toDto(Order order);

}
