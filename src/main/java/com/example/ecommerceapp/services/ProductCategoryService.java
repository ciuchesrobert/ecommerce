package com.example.ecommerceapp.services;

import com.example.ecommerceapp.entities.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAllCategories();
    ProductCategory saveCategory(ProductCategory productCategory);
    ProductCategory findById(long id);
    ProductCategory update(long id, ProductCategory productCategory);
    void delete(long id);
}
