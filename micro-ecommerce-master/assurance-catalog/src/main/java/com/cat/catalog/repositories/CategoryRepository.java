package com.cat.catalog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cat.catalog.models.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
