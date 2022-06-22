package com.cafe.swhackathonserver.user.application;

import com.cafe.swhackathonserver.user.domain.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private static UserRepository userRepository;
}
