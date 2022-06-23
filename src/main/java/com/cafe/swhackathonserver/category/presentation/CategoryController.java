package com.cafe.swhackathonserver.category.presentation;

import com.cafe.swhackathonserver.cafe.application.CategoryService;
import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CategoryCreateRequest;
import com.cafe.swhackathonserver.cafe.presentation.dto.response.CategoryResponse;
import com.cafe.swhackathonserver.doc.ApiDoc;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @ApiOperation(value = ApiDoc.CREATE_CATEGORY)
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CategoryCreateRequest request) {
        Long id = categoryService.create(CategoryCreateDto.from(request));
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = ApiDoc.DELETE_CATEGORY)
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Long> delete(@PathVariable Long categoryId) {
        Long id = categoryService.delete(categoryId);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = ApiDoc.FIND_ALL_CATEGORY)
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryDto> categoryDtos = categoryService.findAll();
        List<CategoryResponse> response = categoryDtos.stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
