package com.cafe.swhackathonserver.menu.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuCreateRequest {
    private Long cafeId;
    private String name;
    private int price;
    private boolean ownerPick;
    private String menuImage;
}
