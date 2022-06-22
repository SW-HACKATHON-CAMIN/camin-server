package com.cafe.swhackathonserver.menu.application.dto;

import com.cafe.swhackathonserver.menu.presentation.dto.request.MenuCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateDto {
    private String name;
    private int price;
    private boolean ownerPick;
    private String menuImage;

    public static MenuCreateDto from(MenuCreateRequest request) {
        return new MenuCreateDto(request.getName(), request.getPrice(), request.isOwnerPick(), request.getMenuImage());
    }
}
