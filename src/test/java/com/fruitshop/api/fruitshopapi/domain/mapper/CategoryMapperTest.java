package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.Category;
import com.fruitshop.api.fruitshopapi.domain.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void categoryToCategoryDto() {
        Category category = new Category();
        category.setName("Fruit");
        category.setId(1);

        CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(category);

        assertEquals(1,categoryDto.getId());
        assertEquals("Fruit",categoryDto.getCategoryName());
    }
}