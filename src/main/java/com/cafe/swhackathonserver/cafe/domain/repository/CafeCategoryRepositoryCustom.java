package com.cafe.swhackathonserver.cafe.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.cafe.swhackathonserver.category.domain.CafeCategory;

public interface CafeCategoryRepositoryCustom {
    List<CafeCategory> findCafeByLocationAndFilter(BigDecimal latitude, BigDecimal longitude, List<Long> categoryIds);
}
