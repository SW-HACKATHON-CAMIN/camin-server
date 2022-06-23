package com.cafe.swhackathonserver.user.domain.like;

import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.common.BaseEntity;
import com.cafe.swhackathonserver.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "likes")
public class Like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;

    public Like(User user, Cafe cafe) {
        this.user = user;
        this.cafe = cafe;
    }

    public void unlike(){
        this.user.unLike(this);
        this.cafe.unlike(this);
    }
}
