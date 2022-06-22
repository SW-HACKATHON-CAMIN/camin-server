package com.cafe.swhackathonserver.cafe.application;

import com.cafe.swhackathonserver.cafe.domain.repository.CafeRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CafeService {
    private static CafeRepository cafeRepository;
}
