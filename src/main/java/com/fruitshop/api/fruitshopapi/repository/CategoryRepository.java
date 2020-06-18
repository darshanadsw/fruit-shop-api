package com.fruitshop.api.fruitshopapi.repository;

import com.fruitshop.api.fruitshopapi.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {

    Category findCategoryByName(String name);

    List<Category> findAll();

}
