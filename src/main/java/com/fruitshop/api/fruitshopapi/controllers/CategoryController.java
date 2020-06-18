package com.fruitshop.api.fruitshopapi.controllers;

import com.fruitshop.api.fruitshopapi.domain.dto.CategoryDto;
import com.fruitshop.api.fruitshopapi.domain.dto.CategoryListDto;
import com.fruitshop.api.fruitshopapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoryListDto> getAllCategories(){
        return ResponseEntity.ok(new CategoryListDto(categoryService.findAllCategories()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDto> findCategoryByName(@PathVariable String name){
        return ResponseEntity.ok(categoryService.findCategoryByName(name));
    }

}
