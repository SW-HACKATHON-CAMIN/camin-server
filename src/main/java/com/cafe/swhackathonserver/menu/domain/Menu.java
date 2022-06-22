package com.cafe.swhackathonserver.menu.domain;

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
public class Menu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    private String name;

    private String price;

    private boolean ownerPick;

    private Long pickedCnt;

    //ToDo menu image 넣을건지 고려
//    private MenuImage menuImage

}
