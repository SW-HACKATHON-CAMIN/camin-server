package com.cafe.swhackathonserver.cafe.domain;

import com.cafe.swhackathonserver.cafe.domain.cafeimage.CafeImage;
import com.cafe.swhackathonserver.cafe.domain.category.Category;
import com.cafe.swhackathonserver.menu.domain.Menu;
import com.cafe.swhackathonserver.user.domain.like.Like;
import com.cafe.swhackathonserver.user.domain.visit.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "cafe")
//    private User manager;

    private String infoImage;

    @OneToMany(mappedBy = "cafe")
    private List<CafeImage> images = new ArrayList<>();

    // ToDO 결정나면 새로 만들기
//    private List<Experience> experiences

    private String address;

    private String phone;

    private String cafeName;

    private String introduction;

    private String event;

    private float latitude;

    private float longitude;

    // ToDO 결정나면 새로 만들기
//    private List<Section> sections

    @OneToMany(mappedBy = "cafe")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Category> categories = new ArrayList<>();
}
