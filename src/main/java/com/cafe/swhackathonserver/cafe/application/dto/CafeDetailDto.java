package com.cafe.swhackathonserver.cafe.application.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cafe.swhackathonserver.cafe.application.dto.category.CategoryDto;
import com.cafe.swhackathonserver.cafe.application.dto.menu.MenuInfoDto;
import com.cafe.swhackathonserver.cafe.application.dto.section.SectionInfoDto;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.cafeimage.CafeImage;
import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeDetailDto {
    private Long cafeId;
    private Long managerId;
    private String managerName;
    private String infoImage;
    private List<String> images = new ArrayList<>();
    private String address;
    private String phone;
    private String cafeName;
    private String introduction;
    private String event;
    private List<CategoryDto> categories;
    private List<SectionInfoDto> sections;
    private List<MenuInfoDto> menus;

    public CafeDetailDto (Cafe cafe) {
        cafeId = cafe.getId();
        managerId = cafe.getManager().getId();
        managerName = cafe.getManager().getName();
        infoImage = cafe.getInfoImage();
        images = cafe.getImages().stream().map(CafeImage::getUrl).collect(Collectors.toList());
        address = cafe.getAddress();
        phone = cafe.getPhone();
        cafeName = cafe.getCafeName();
        introduction = cafe.getIntroduction();
        event = cafe.getEvent();
        categories = cafe.getCafeCategories().stream().map(CategoryDto::new).collect(Collectors.toList());
        sections = cafe.getCafeSections().stream().map(SectionInfoDto::new).collect(Collectors.toList());
        menus = cafe.getMenus().stream().map(MenuInfoDto::new).collect(Collectors.toList());
    }
}
