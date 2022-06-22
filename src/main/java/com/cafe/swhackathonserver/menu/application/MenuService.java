package com.cafe.swhackathonserver.menu.application;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.repository.CafeRepository;
import com.cafe.swhackathonserver.exception.cafe.CafeNotFoundException;
import com.cafe.swhackathonserver.exception.menu.MenuNotFoundException;
import com.cafe.swhackathonserver.menu.application.dto.MenuCreateDto;
import com.cafe.swhackathonserver.menu.domain.Menu;
import com.cafe.swhackathonserver.menu.domain.repository.MenuRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final CafeRepository cafeRepository;

    @Transactional
    public Long create(Long cafeId, MenuCreateDto menuCreateDto){
        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(CafeNotFoundException::new);

        Menu savedMenu = menuRepository.save(new Menu(cafe, menuCreateDto));

        return savedMenu.getId();
    }

    @Transactional
    public Long delete(Long menuId){
        Menu menu = menuRepository.findById(menuId).orElseThrow(MenuNotFoundException::new);
        menuRepository.delete(menu);
        return menuId;
    }
}
