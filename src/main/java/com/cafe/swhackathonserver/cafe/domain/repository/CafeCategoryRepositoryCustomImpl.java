package com.cafe.swhackathonserver.cafe.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

import com.cafe.swhackathonserver.category.domain.CafeCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.cafe.swhackathonserver.cafe.domain.QCafe.cafe;
import static com.cafe.swhackathonserver.category.domain.QCafeCategory.cafeCategory;

public class CafeCategoryRepositoryCustomImpl extends QuerydslRepositorySupport implements CafeCategoryRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public CafeCategoryRepositoryCustomImpl(EntityManager em) {
        super(CafeCategory.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<CafeCategory> findCafeByLocationAndFilter(BigDecimal latitude, BigDecimal longitude, List<Long> categoryIds) {
        return queryFactory.select(cafeCategory)
                           .distinct()
                           .from(cafeCategory)
                           .leftJoin(cafeCategory.cafe)
                           .leftJoin(cafeCategory.category)
                           .leftJoin(cafeCategory.cafe.cafeSections)
                           .where(cafeCategory.cafe.latitude.between(latitude.subtract(BigDecimal.valueOf(0.009094341))
                                                      , latitude.add(BigDecimal.valueOf(0.009094341)))
                                                            .and(cafeCategory.cafe.longitude.between(longitude.subtract(BigDecimal.valueOf(0.0112688753)),
                                                                    longitude.add(BigDecimal.valueOf(0.0112688753)))
                                                            ))
                           .where(containsCategory(categoryIds))
                           .fetch();
    }
    private BooleanExpression containsCategory(List<Long> categoryIds){
        if(categoryIds.size() == 0) return Expressions.asBoolean(true).isTrue();
        return cafeCategory.category.id.in(categoryIds);
    }
}
