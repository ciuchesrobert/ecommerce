package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.entities.ProductCategory;
import com.example.ecommerceapp.services.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/category")
    public ProductCategory save(@RequestBody ProductCategory productCategory){
        return productCategoryService.saveCategory(productCategory);
    }

    @GetMapping("/category")
    public List<ProductCategory> findAllCategories(){
        return productCategoryService.findAllCategories();
    }

    @GetMapping("/category/{id}")
    public ProductCategory findByIdCategory(@PathVariable("id") long id){
        return productCategoryService.findById(id);
    }

    @PutMapping("/category/{id}")
    public ProductCategory updateCategory(@PathVariable("id") long id, @RequestBody ProductCategory productCategory) {
        Optional<ProductCategory> categoryFromDatabase = Optional.ofNullable(productCategoryService.findById(id));
        if (categoryFromDatabase.isPresent()) {
            categoryFromDatabase.get().setCategoryName(productCategory.getCategoryName());
            final ProductCategory updatedCategory = productCategoryService.saveCategory(categoryFromDatabase.get());
            return updatedCategory;
        }
        return productCategoryService.update(productCategory);
    }

    @DeleteMapping("/category/{id}")
    public void deleteProductCategory(@PathVariable("id") long id){
        productCategoryService.deleteById(id);
    }


}
