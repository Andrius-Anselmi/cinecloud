package com.cinecloud.controller;

import com.cinecloud.entity.Category;
import com.cinecloud.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinecloud/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        Optional<Category> OptionalCategory = categoryService.getById(id);
        if(OptionalCategory.isPresent()){
            return OptionalCategory.get();
        }
        return null;
    }

    @GetMapping()
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> optionalCategory = categoryService.getById(id);
        if(optionalCategory.isPresent()){
            category.setId(id);
            Category updateCategory = categoryService.update(category);

            return updateCategory;
        }
        return null;
    }


}
