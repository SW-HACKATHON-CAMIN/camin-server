package com.cafe.swhackathonserver.cafe.domain.category;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "category")
    private List<CafeCategory> cafeCategories = new ArrayList<>();
}
