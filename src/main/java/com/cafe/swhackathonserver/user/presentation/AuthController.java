package com.cafe.swhackathonserver.user.presentation;

import com.cafe.swhackathonserver.doc.ApiDoc;
import com.cafe.swhackathonserver.user.application.UserService;
import com.cafe.swhackathonserver.user.application.dto.AuthResponse;
import com.cafe.swhackathonserver.user.application.dto.LoginRequest;
import com.cafe.swhackathonserver.user.application.dto.SignUpRequest;
import com.cafe.swhackathonserver.user.domain.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

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
}
