package com.cafe.swhackathonserver.cafe.application.dto.menu;

import com.cafe.swhackathonserver.menu.domain.Menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuInfoDto {
    private Long id;
    private String name;
    private int price;
    private String menuImage;

    public MenuInfoDto(Menu menu){
        this.id = menu.getId();
        this.name = menu.getName();
        this.price = menu.getPrice();;
        this.menuImage = menu.getMenuImage();
    }
}
