package com.cafe.swhackathonserver.cafe.application.dto.section;

import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SectionInfoDto {
    private Long id;
    private String name;
    private int count;
    private int status;
    public SectionInfoDto(CafeSection cafeSection){
        this.id = cafeSection.getSection().getId();
        this.name = cafeSection.getSection().getName();
        this.count = cafeSection.getCount();
        this.status = cafeSection.getStatus();
    }
}
