package com.cafe.swhackathonserver.menu.presentation;

import com.cafe.swhackathonserver.menu.application.MenuService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private static MenuService menuService;
}
