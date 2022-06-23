package com.cafe.swhackathonserver.cafe.application.dto;

import com.cafe.swhackathonserver.cafe.domain.Cafe;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeFavoriteDto {
    private Long cafeId;
    private String cafeName;
    private String address;
    private String mainIamge;

    public CafeFavoriteDto(Cafe cafe) {
        this.cafeId = cafe.getId();
        this.cafeName = cafe.getCafeName();
        this.address = cafe.getAddress();
        this.mainIamge = cafe.getMainImage();
    }
}
