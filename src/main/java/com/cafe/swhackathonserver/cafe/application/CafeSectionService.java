package com.cafe.swhackathonserver.cafe.application;

import com.cafe.swhackathonserver.cafe.domain.repository.CafeSectionRepository;
import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;
import com.cafe.swhackathonserver.exception.cafe.CafeSectionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeSectionService {
    private final CafeSectionRepository cafeSectionRepository;

    public CafeSection findById(Long id) {
        return cafeSectionRepository.findById(id).orElseThrow(CafeSectionNotFoundException::new);
    }

    public CafeSection updateCountById(Long id) {
        CafeSection cafeSection = findById(id);
        cafeSection.setCount(cafeSection.getCount() - 1);
        
        return cafeSectionRepository.save(cafeSection);
    }
}
