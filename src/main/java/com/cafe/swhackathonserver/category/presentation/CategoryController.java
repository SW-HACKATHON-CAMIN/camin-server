package com.cafe.swhackathonserver.cafe.presentation;

import java.util.List;
import java.util.stream.Collectors;

import com.cafe.swhackathonserver.cafe.application.CategoryService;
import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CategoryCreateRequest;
import com.cafe.swhackathonserver.cafe.presentation.dto.response.CategoryResponse;

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
        Long id = categoryService.create(CategoryCreateDto.from(request));
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long categoryId){
        Long id = categoryService.delete(categoryId);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<CategoryDto> categoryDtos = categoryService.findAll();
        List<CategoryResponse> response = categoryDtos.stream()
                                                      .map(CategoryResponse::from)
                                                      .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
