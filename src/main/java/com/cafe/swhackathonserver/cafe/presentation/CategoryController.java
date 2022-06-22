package com.cafe.swhackathonserver.cafe.presentation;

import com.cafe.swhackathonserver.cafe.application.CategoryService;
import com.cafe.swhackathonserver.cafe.application.dto.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CategoryCreateRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Long> createCategory(@RequestBody CategoryCreateRequest request){
        Long id = categoryService.createCategory(CategoryCreateDto.from(request));
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long categoryId){
        Long id = categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(id);
    }
}
