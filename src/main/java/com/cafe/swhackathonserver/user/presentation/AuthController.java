package com.cafe.swhackathonserver.user.presentation;

import com.cafe.swhackathonserver.doc.ApiDoc;
import com.cafe.swhackathonserver.user.application.KakaoService;
import com.cafe.swhackathonserver.user.application.UserService;
import com.cafe.swhackathonserver.user.application.dto.*;
import com.cafe.swhackathonserver.user.domain.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final KakaoService kakaoService;

    @ApiOperation(value = ApiDoc.SIGN_UP)
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        User user = userService.save(signUpRequest.toUser());
        user.setAdmin(false);

        return ResponseEntity.ok(user.toAuthResponse());
    }

    @ApiOperation(value = ApiDoc.LOGIN)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByKakaoId(loginRequest.getKakaoId());

        return ResponseEntity.ok(user.toAuthResponse());
    }

    @PostMapping("/kakao/token")
    public ResponseEntity<AuthResponse> loginWithKakao(@RequestBody KakaoRequest kakaoRequest) {
        // 1. 코드 값으로 토큰 발급
        String kakaoToken = kakaoService.getTokenByCode(kakaoRequest.getCode());

        // 2. 토큰값으로 회원 정보 가져옴
        KakaoUserResponse kakaoUserResponse = kakaoService.getKakaoUserInfoByToken(kakaoToken);

        // 3. 플랫폼아이디로 가입된 유저인지 판단
        String kakaoId = kakaoUserResponse.getId();
        Optional<User> optionalUser = userService.findOptionalByKakaoId(kakaoId);

        // 3-1. 가입 안되있을 경우 회원가입 처리, 가입 되어있을 경우 로그인 처리
        User user = optionalUser.isEmpty() ? userService.save(kakaoUserResponse.toUser()) : optionalUser.get();

        return ResponseEntity.ok(user.toAuthResponse());
    }
}
