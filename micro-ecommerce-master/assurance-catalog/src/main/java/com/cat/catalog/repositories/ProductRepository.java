package com.cat.catalog.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cat.catalog.models.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
