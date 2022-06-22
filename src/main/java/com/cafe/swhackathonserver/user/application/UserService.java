package com.cafe.swhackathonserver.user.application;

import com.cafe.swhackathonserver.exception.user.UserDuplicatedException;
import com.cafe.swhackathonserver.exception.user.UserNotFoundException;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        if (userRepository.existsByKakaoId(user.getKakaoId())) {
            throw new UserDuplicatedException();
        }

        return userRepository.save(user);
    }


    public User findByKakaoId(String kakaoId) {
        Optional<User> userOptional = userRepository.findByKakaoId(kakaoId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        return userOptional.get();
    }
}
