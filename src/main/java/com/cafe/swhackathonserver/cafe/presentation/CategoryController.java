package com.cafe.swhackathonserver.cafe.presentation;

import com.cafe.swhackathonserver.cafe.application.CategoryService;
import com.cafe.swhackathonserver.cafe.application.dto.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CategoryCreateRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
