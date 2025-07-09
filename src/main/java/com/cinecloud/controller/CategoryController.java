package com.cinecloud.controller;

import com.cinecloud.controller.Request.CategoryRequest;
import com.cinecloud.controller.Response.CategoryResponse;
import com.cinecloud.entity.Category;
import com.cinecloud.mapper.CategoryMapper;
import com.cinecloud.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinecloud/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(CategoryMapper.toCategoryResponse(categoryService.save(CategoryMapper.toCategory(request))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id){
        Optional<Category> OptionalCategory = categoryService.getById(id);
        return OptionalCategory.map(Category -> ResponseEntity.ok
                (CategoryMapper.toCategoryResponse(Category))).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAll() {
        List<CategoryResponse> categoryResponses = categoryService.getAll().stream()
                .map(CategoryMapper::toCategoryResponse).toList();
        return ResponseEntity.ok(categoryResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody Category category){
        Optional<Category> optionalCategory = categoryService.getById(id);
        if(optionalCategory.isPresent()){
            category.setId(id);
            categoryService.update(category,id);
            return ResponseEntity.ok(CategoryMapper.toCategoryResponse(optionalCategory.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }


}
