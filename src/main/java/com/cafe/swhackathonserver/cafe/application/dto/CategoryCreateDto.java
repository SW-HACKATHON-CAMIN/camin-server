package com.cafe.swhackathonserver.cafe.application.dto;

import com.cafe.swhackathonserver.cafe.presentation.dto.request.CategoryCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDto {
    private String name;
    private int type;

    public static CategoryCreateDto from(CategoryCreateRequest request){
        return new CategoryCreateDto(request.getName(), request.getType());
    }
}
