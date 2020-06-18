package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.DomainObject;
import com.fruitshop.api.fruitshopapi.domain.dto.DtoObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {OrderMapper.class})
public interface CompanyMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "street",target = "address.street")
    @Mapping(source = "city",target = "address.city")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "province", target = "address.province")
    DomainObject map(DtoObject source);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.street", target = "street"),
            @Mapping(source = "address.province", target = "province"),
            @Mapping(source = "address.postalCode", target = "postalCode"),
            @Mapping(source = "orders", target = "clientOrders")}
    )
    DtoObject domainToDto(DomainObject domainObject);



}
