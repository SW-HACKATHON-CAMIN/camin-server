package com.cafe.swhackathonserver.cafe.application.dto.category;

import com.cafe.swhackathonserver.cafe.domain.category.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private int type;

    public static CategoryDto from(Category category){
        return new CategoryDto(category.getId(), category.getName(), category.getType());
    }
}
