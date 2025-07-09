package com.cinecloud.service;

import com.cinecloud.entity.Category;
import com.cinecloud.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    public Category update(Category category, Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            Category save = optionalCategory.get();
            save.setId(category.getId());
            save.setName(category.getName());
            return categoryRepository.save(save);
        }

        return null;
    }
}
