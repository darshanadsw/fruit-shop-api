package com.fruitshop.api.fruitshopapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruitshop.api.fruitshopapi.domain.dto.CustomerDto;
import com.fruitshop.api.fruitshopapi.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllCustomers() throws Exception {
        CustomerDto c1 = new CustomerDto();
        c1.setFirstName("fName1");
        c1.setLastName("lName1");
        c1.setId(1);
        CustomerDto c2 = new CustomerDto();
        c2.setFirstName("fName2");
        c2.setLastName("lName2");
        c2.setId(1);
        given(customerService.getAllCustomers()).willReturn(List.of(c1,c2));

        mvc.perform(get("/api/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers",hasSize(2)));
    }

    @Test
    void findCustomerById() throws Exception {
        CustomerDto c1 = new CustomerDto();
        c1.setFirstName("fName1");
        c1.setLastName("lName1");
        c1.setId(1);
        given(customerService.findCustomerById(anyInt())).willReturn(c1);

        mvc.perform(get("/api/v1/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",is("fName1")));

    }

    @Test
    void saveCustomer() throws Exception {
        CustomerDto c1 = new CustomerDto();
        c1.setFirstName("fName1");
        c1.setLastName("lName1");
        c1.setId(1);
        given(customerService.saveCustomer(ArgumentMatchers.any())).willReturn(c1);

        mvc.perform(post("/api/v1/customers")
            .content(objectMapper.writeValueAsString(c1))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.firstName",is("Darshana")))
            .andExpect(jsonPath("$.lastName",is("Welikala")))
            .andExpect(status().isCreated());
    }

    @Test
    void deleteCustomer() throws Exception {
        willDoNothing().given(customerService).deleteCustomer(anyInt());

        mvc.perform(delete("/api/v1/customers/2"))
            .andExpect(status().isOk());
    }
}
