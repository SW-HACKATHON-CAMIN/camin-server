package com.cafe.swhackathonserver.cafe.domain;

import com.cafe.swhackathonserver.cafe.domain.cafeimage.CafeImage;
import com.cafe.swhackathonserver.cafe.domain.section.Section;
import com.cafe.swhackathonserver.category.domain.CafeCategory;
import com.cafe.swhackathonserver.category.domain.Category;
import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.exception.cafe.CafeSectionInfoException;
import com.cafe.swhackathonserver.experience.domain.Experience;
import com.cafe.swhackathonserver.menu.domain.Menu;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.domain.like.Like;
import com.cafe.swhackathonserver.user.domain.visit.Visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Cafe extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User manager;

    private String infoImage;

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CafeImage> images = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Experience> experiences = new ArrayList<>();

    private String address;

    private String phone;

    private String cafeName;

    private String introduction;

    private String event;

    @Column(precision = 13, scale=10)
    private BigDecimal latitude;

    @Column(precision = 13, scale=10)
    private BigDecimal longitude;

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CafeSection> cafeSections = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Visit> visits = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CafeCategory> cafeCategories = new ArrayList<>();

    private void addCategory(Category category) {
        CafeCategory cafeCategory = new CafeCategory(this, category);
        this.cafeCategories.add(cafeCategory);
        category.addCafeCategory(cafeCategory);
    }

    public void addCategories(List<Category> categories) {
        categories.forEach(this::addCategory);
    }

    private void addSection(Section section, int count) {
        CafeSection cafeSection = new CafeSection(this, section, count);
        this.cafeSections.add(cafeSection);
        section.addCafeSection(cafeSection);
    }

    public void addSections(List<Section> sections, List<Integer> sectionCounts) {

        if (sections.size() != sectionCounts.size()){
            throw new CafeSectionInfoException();
        }


        for (int i = 0; i < sections.size(); i++) {
            addSection(sections.get(i), sectionCounts.get(i));
        }
    }

    private void addImage(String url) {
        CafeImage cafeImage = new CafeImage(url, this);
        System.out.println("Check: " + url);
        this.images.add(cafeImage);
    }

    public void addImages(List<String> cafeImages) {
        cafeImages.forEach(this::addImage);
    }

    public void setManager(User user) {
        this.manager = user;
        user.setCafe(this);
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }
}

