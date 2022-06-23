package com.cafe.swhackathonserver.cafe.domain.section;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CafeSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalCount;

    private int count;

    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;

    public CafeSection(Cafe cafe, Section section, int totalCount) {
        this.cafe = cafe;
        this.section = section;
        this.totalCount = totalCount;
    }

    public void updateStatus(int status){
        this.status = status;
    }
}
