package com.cafe.swhackathonserver.menu.application;

import com.cafe.swhackathonserver.menu.domain.repository.MenuRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
    private static MenuRepository menuRepository;
}
