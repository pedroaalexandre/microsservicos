package com.pedro.api.product.product_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedro.api.product.product_api.converter.DTOConverter;
import com.pedro.api.product.product_api.models.Category;
import com.pedro.api.product.product_api.repositories.CategoryRepository;
import com.pedro.dto.CategoryDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAll() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                        .map(DTOConverter::convert)
                        .collect(Collectors.toList());
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(Category.convertToEntity(categoryDTO));
        return DTOConverter.convert(category);
    }

    public CategoryDTO edit(String id, CategoryDTO categoryDTO) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        if(categoryDTO.getNome() != null && !category.getNome().equals(categoryDTO.getNome())) {
            category.setNome(categoryDTO.getNome());
        }
        category = categoryRepository.save(category);
        return DTOConverter.convert(category);
    }

    public CategoryDTO delete(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
        categoryRepository.delete(category);
        return DTOConverter.convert(category);
    }

    public Page<CategoryDTO> getAllPage(Pageable page) {
        Page<Category> categories = categoryRepository.findAll(page);
        return categories.map(DTOConverter::convert);
    }

}
