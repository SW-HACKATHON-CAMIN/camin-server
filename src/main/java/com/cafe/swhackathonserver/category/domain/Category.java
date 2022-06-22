package com.cafe.swhackathonserver.category.domain;

import java.util.ArrayList;
import java.util.List;

import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryCreateDto;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 0 방문인원, 1 목적, 2 카테고리, 3 경험
    private int type;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CafeCategory> cafeCategories = new ArrayList<>();

    public Category(CategoryCreateDto categoryCreateDto){
        this.name = categoryCreateDto.getName();
        this.type = categoryCreateDto.getType();
    }

    public void addCafeCategory(CafeCategory cafeCategory){
        this.cafeCategories.add(cafeCategory);
    }
}
