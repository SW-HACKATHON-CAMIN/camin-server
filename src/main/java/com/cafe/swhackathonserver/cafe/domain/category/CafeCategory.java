package com.cafe.swhackathonserver.cafe.domain.category;

import javax.persistence.*;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CafeCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
