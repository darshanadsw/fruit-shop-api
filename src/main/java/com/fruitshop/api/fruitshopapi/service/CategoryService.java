package com.fruitshop.api.fruitshopapi.service;

import com.fruitshop.api.fruitshopapi.domain.dto.CategoryDto;
import com.fruitshop.api.fruitshopapi.domain.mapper.CategoryMapper;
import com.fruitshop.api.fruitshopapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;


    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> findAllCategories(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());

    }

    public CategoryDto findCategoryByName(String name){
        return categoryMapper.categoryToCategoryDto(categoryRepository.findCategoryByName(name));
    }

}
