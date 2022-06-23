package com.cafe.swhackathonserver.menu.domain;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.exception.menu.MenuNameBlankException;
import com.cafe.swhackathonserver.exception.menu.MenuPriceException;
import com.cafe.swhackathonserver.menu.application.dto.MenuCreateDto;
import com.cafe.swhackathonserver.menu.application.dto.MenuResponse;
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

    private int price;

    private boolean ownerPick;

    private long pickedCnt = 0;

    private String menuImage;


    public Menu(Cafe cafe, MenuCreateDto menuCreateDto) {
        cafe.addMenu(this);

        this.cafe = cafe;
        if (menuCreateDto.getName().isBlank())
            throw new MenuNameBlankException();
        this.name = menuCreateDto.getName();
        if (menuCreateDto.getPrice() < 0)
            throw new MenuPriceException();
        this.price = menuCreateDto.getPrice();
        // ToDo 한 Cafe의 ownerPick이 한개만 존재하도록 만들어야함
        // 프론트단에서도 가능하므로 나중에 고려
        this.ownerPick = menuCreateDto.isOwnerPick();
        this.menuImage = menuCreateDto.getMenuImage();
    }

    public MenuResponse toMenuResponse() {
        return new MenuResponse(id, name, price, ownerPick, pickedCnt, menuImage);
    }
}
