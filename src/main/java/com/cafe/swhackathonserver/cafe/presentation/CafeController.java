package com.cafe.swhackathonserver.cafe.presentation;

import com.cafe.swhackathonserver.cafe.application.CafeService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CafeController {
    private static CafeService cafeService;
}
