package com.cafe.swhackathonserver.cafe.application;

import java.util.List;
import java.util.stream.Collectors;

import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryDto;
import com.cafe.swhackathonserver.category.domain.Category;
import com.cafe.swhackathonserver.category.application.CategoryRepository;
import com.cafe.swhackathonserver.exception.category.CategoryNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Long create(CategoryCreateDto categoryCreateDto) {
        Category savedCategory = categoryRepository.save(new Category(categoryCreateDto));
        return savedCategory.getId();
    }

    public Long delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(category);
        return id;
    }

    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                         .map(CategoryDto::from)
                         .collect(Collectors.toList());
    }
}
