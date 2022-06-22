package com.cafe.swhackathonserver.user.presentation;

import com.cafe.swhackathonserver.user.application.UserService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private static UserService userService;
}
