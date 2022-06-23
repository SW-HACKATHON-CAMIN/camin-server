package com.cafe.swhackathonserver.user.presentation;

import com.cafe.swhackathonserver.doc.ApiDoc;
import com.cafe.swhackathonserver.user.application.UserService;
import com.cafe.swhackathonserver.user.application.dto.AuthResponse;
import com.cafe.swhackathonserver.user.application.dto.UserAdminStatusRequest;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.presentation.dto.request.UserLikeRequest;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = ApiDoc.FIND_USER_BY_ID)
    @GetMapping("/{id}")
    public ResponseEntity<AuthResponse> findById(@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok(user.toAuthResponse());
    }

    @ApiOperation(value = ApiDoc.UPDATE_USER_STATUS)
    @PostMapping("/admin/status")
    public ResponseEntity<AuthResponse> updateAdminStatus(@RequestBody UserAdminStatusRequest userAdminStatusRequest) {
        User user = userService.updateAdminStatusById(userAdminStatusRequest.getId(), userAdminStatusRequest.getBusinessRegistrationNumber());
        return ResponseEntity.ok(user.toAuthResponse());
    }

    @ApiOperation(value = ApiDoc.LIKE)
    @PostMapping("/like")
    public ResponseEntity<Boolean> likeCafe(@RequestBody UserLikeRequest request) {
        Boolean response = userService.likeCafe(request.getUserId(), request.getCafeId());
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = ApiDoc.UNLIKE)
    @DeleteMapping("/unlike")
    public ResponseEntity<Boolean> unLikeCafe(@RequestBody UserLikeRequest request) {
        Boolean response = userService.unLikeCafe(request.getUserId(), request.getCafeId());
        return ResponseEntity.ok(response);
    }
}
