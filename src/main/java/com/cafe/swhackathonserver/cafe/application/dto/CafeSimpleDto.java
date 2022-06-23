package com.cafe.swhackathonserver.cafe.application.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryDto;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.category.domain.CafeCategory;
import com.cafe.swhackathonserver.exception.cafe.CafeNoImageException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeSimpleDto {
    private Long id;
    private int status;
    private String cafeName;
    private String address;
    private String mainImage;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<CategoryDto> categories = new ArrayList<>();

    public CafeSimpleDto(Cafe cafe, int status) {
        this.id = cafe.getId();
        this.status = status;
        this.cafeName = cafe.getCafeName();
        this.address = cafe.getAddress();
        this.mainImage = cafe.getMainImage();
        this.latitude = cafe.getLatitude();
        this.longitude = cafe.getLongitude();
        this.categories = cafe.getCafeCategories()
                              .stream()
                              .map(cafeCategory -> CategoryDto.from(cafeCategory.getCategory()))
                              .collect(Collectors.toList());

    }

}
