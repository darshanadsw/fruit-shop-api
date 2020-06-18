package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.Address;
import com.fruitshop.api.fruitshopapi.domain.DomainObject;
import com.fruitshop.api.fruitshopapi.domain.Order;
import com.fruitshop.api.fruitshopapi.domain.dto.DtoObject;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CompanyMapperTest {

    @Autowired
    private CompanyMapper companyMapper;

    @Test
    void map() {

        DtoObject dto = new DtoObject();
        dto.setId("1");
        dto.setCity("City");
        dto.setPostalCode("postal code");
        dto.setProvince("province");
        dto.setStreet("street");

        DomainObject domainObject = companyMapper.map(dto);

        assertNotNull(domainObject);
        assertEquals("1",domainObject.getId());
        assertEquals("street",domainObject.getAddress().getStreet());
        assertEquals("province",domainObject.getAddress().getProvince());

    }

    @Test
    void domainToDto() {
        DomainObject domain = new DomainObject();
        domain.setId("1");
        Address address = new Address();
        address.setCity("city");
        address.setPostalCode("postal code");
        address.setProvince("province");
        address.setStreet("street");
        domain.setAddress(address);
        Order o1 = new Order();
        o1.setId("1");
        o1.setName("Product 1");
        Order o2 = new Order();
        o2.setId("2");
        o2.setName("Product 2");
        domain.setOrders(List.of(o1,o2));

        DtoObject dto = companyMapper.domainToDto(domain);

        assertEquals("city",dto.getCity());
        assertEquals(2,dto.getClientOrders().size());
    }


}