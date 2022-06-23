package com.cafe.swhackathonserver.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLikeRequest {
    private Long userId;
    private Long cafeId;
}
