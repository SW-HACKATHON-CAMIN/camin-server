package com.cafe.swhackathonserver.cafe.domain.section;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "section")
    private List<CafeSection> cafeSections = new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }
}
