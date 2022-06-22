package com.cafe.swhackathonserver.cafe.application;

import com.cafe.swhackathonserver.cafe.domain.repository.SectionRepository;
import com.cafe.swhackathonserver.cafe.domain.section.Section;
import com.cafe.swhackathonserver.exception.section.SectionDuplicationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    @Transactional
    public Long createSection(String name){
        if(sectionRepository.existsByName(name))
            throw new SectionDuplicationException();

        Section savedSection = sectionRepository.save(new Section(name));
        return savedSection.getId();
    }
}
