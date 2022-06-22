package com.cafe.swhackathonserver.cafe.domain.section;

import javax.persistence.*;

import com.cafe.swhackathonserver.cafe.domain.Cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CafeSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;

    public CafeSection(Cafe cafe, Section section, int count) {
        this.cafe = cafe;
        this.section = section;
        this.count = count;
    }
}