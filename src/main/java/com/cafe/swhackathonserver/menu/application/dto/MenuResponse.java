package com.cafe.swhackathonserver.menu.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {
    private Long id;

    private String name;

    private int price;

    private boolean ownerPick;

    private long pickedCnt;

    private String menuImage;
}
