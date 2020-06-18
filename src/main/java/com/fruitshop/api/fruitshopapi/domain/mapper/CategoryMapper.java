package com.fruitshop.api.fruitshopapi.domain.mapper;

import com.fruitshop.api.fruitshopapi.domain.Category;
import com.fruitshop.api.fruitshopapi.domain.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {

    @Mapping(source = "name", target = "categoryName")
    CategoryDto categoryToCategoryDto(Category category);

}
