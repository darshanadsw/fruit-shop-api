package com.fruitshop.api.fruitshopapi.controllers;

import com.fruitshop.api.fruitshopapi.domain.dto.CategoryDto;
import com.fruitshop.api.fruitshopapi.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void getAllCategories() throws Exception{
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName("category1");
        categoryDto.setId(1);
        CategoryDto categoryDto1 = new CategoryDto();
        categoryDto1.setId(2);
        categoryDto1.setCategoryName("category2");

        given(categoryService.findAllCategories()).willReturn(List.of(categoryDto,categoryDto1));

        mvc.perform(get("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.categories",hasSize(2)))
                .andExpect(status().isOk());
    }

    @Test
    void findCategoryByName() throws Exception {

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(1);
        categoryDto.setCategoryName("Category");

        given(categoryService.findCategoryByName(anyString())).willReturn(categoryDto);

        mvc.perform(get("/api/v1/categories/fruit")
                    .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.id",is(1)))
                        .andExpect(jsonPath("$.categoryName",is("Category")))
                        .andExpect(status().isOk());
    }
}