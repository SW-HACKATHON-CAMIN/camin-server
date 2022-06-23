package com.cafe.swhackathonserver.user.application;

import com.cafe.swhackathonserver.cafe.application.dto.CafeFavoriteDto;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.repository.CafeRepository;
import com.cafe.swhackathonserver.exception.cafe.CafeNotFoundException;
import com.cafe.swhackathonserver.exception.user.LikeNotFoundException;
import com.cafe.swhackathonserver.exception.user.UserDuplicatedException;
import com.cafe.swhackathonserver.exception.user.UserNotFoundException;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.domain.like.Like;
import com.cafe.swhackathonserver.user.domain.repository.LikeRepository;
import com.cafe.swhackathonserver.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CafeRepository cafeRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public User save(User user) {
        if (userRepository.existsByKakaoId(user.getKakaoId())) {
            throw new UserDuplicatedException();
        }

        return userRepository.save(user);
    }

    @Transactional
    public User findByKakaoId(String kakaoId) {
        Optional<User> userOptional = userRepository.findByKakaoId(kakaoId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        return userOptional.get();
    }

    @Transactional
    public Optional<User> findOptionalByKakaoId(String kakaoId) {
        return userRepository.findByKakaoId(kakaoId);
    }

    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        return userOptional.get();
    }

    @Transactional
    public User updateAdminStatusById(Long id, String businessRegistrationNumber) {
        User user = findById(id);
        user.setAdmin(true);
        user.setBusinessRegistrationNumber(businessRegistrationNumber);
        return userRepository.save(user);
    }

    @Transactional
    public Boolean likeCafe(Long userId, Long cafeId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(CafeNotFoundException::new);

        user.like(cafe);

        return true;
    }

    @Transactional
    public Boolean unLikeCafe(Long userId, long cafeId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(CafeNotFoundException::new);

        Like like = likeRepository.findFirstByUserAndCafe(user, cafe);
        if (Objects.isNull(like))
            throw new LikeNotFoundException();

        like.unlike();
        likeRepository.delete(like);


        return true;
    }

    @Transactional(readOnly = true)
    public List<CafeFavoriteDto> findLikeCafes(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        List<Like> likes = likeRepository.findLikeByUser(user);
        return likes.stream().map(like -> new CafeFavoriteDto(like.getCafe())).collect(Collectors.toList());
    }
}
