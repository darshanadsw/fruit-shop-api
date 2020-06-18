package com.fruitshop.api.fruitshopapi.service;

import com.fruitshop.api.fruitshopapi.domain.Category;
import com.fruitshop.api.fruitshopapi.domain.dto.CategoryDto;
import com.fruitshop.api.fruitshopapi.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findAllCategories() {
        List<CategoryDto> result = categoryService.findAllCategories();
        assertNotNull(result);
        assertEquals(5,result.size());
    }

    @Test
    void findCategoryByName() {
        Category category = new Category();
        category.setName("Test category");
        categoryRepository.save(category);

        CategoryDto result = categoryService.findCategoryByName("Test category");

        assertNotNull(result);
        assertEquals("Test category",result.getCategoryName());
    }
}