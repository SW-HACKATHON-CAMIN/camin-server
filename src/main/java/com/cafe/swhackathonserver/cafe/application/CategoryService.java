package com.cafe.swhackathonserver.cafe.application;

import com.cafe.swhackathonserver.cafe.application.dto.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.domain.category.Category;
import com.cafe.swhackathonserver.cafe.domain.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Long createCategory(CategoryCreateDto categoryCreateDto){
        Category savedCategory = categoryRepository.save(new Category(categoryCreateDto));
        return savedCategory.getId();
    }
}
