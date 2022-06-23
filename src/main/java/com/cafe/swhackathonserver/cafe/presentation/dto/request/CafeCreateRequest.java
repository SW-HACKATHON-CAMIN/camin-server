package com.cafe.swhackathonserver.cafe.presentation.dto.request;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CafeCreateRequest {
    private Long managerId;
    private String infoImage;
    private List<String> cafeImages;
    private String address;
    private String phone;
    private String introduction;
    private String cafeName;
    private String event;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Long> sectionIds;
    private List<Integer> sectionCounts;
    private List<Long> categoryIds;
}
