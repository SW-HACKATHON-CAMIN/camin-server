package com.cafe.swhackathonserver.cafe.presentation.dto.response;

import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    private int type;

    public static CategoryResponse from(CategoryDto categoryDto){
        return new CategoryResponse(categoryDto.getId(), categoryDto.getName(), categoryDto.getType());
    }
}
