package com.cafe.swhackathonserver.cafe.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequest {
    private String name;
    private int type;
}
