package com.cafe.swhackathonserver.experience.domain.experience_category;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.experience.domain.Experience;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExperienceCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "experienceCategory")
    private List<Experience> experiences = new ArrayList<>();

}