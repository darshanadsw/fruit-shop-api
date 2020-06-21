package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.Customer;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "customerUrl",expression = "java(\"/api/v1/customers/\" + source.getId())")
    @Mapping(target = "birthDate", expression = "java(getDateString(source.getBDate()))")
    CustomerDto toDto(Customer source);

    Customer toDomain(CustomerDto source);

    default String getDateString(Date date){
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDate localDate = LocalDateTime.from(instant.atZone(ZoneId.systemDefault())).toLocalDate();
        return localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
