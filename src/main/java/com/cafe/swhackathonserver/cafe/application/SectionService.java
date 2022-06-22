package com.cafe.swhackathonserver.cafe.application;

import com.cafe.swhackathonserver.cafe.domain.repository.SectionRepository;
import com.cafe.swhackathonserver.cafe.domain.section.Section;
import com.cafe.swhackathonserver.exception.section.SectionDuplicationException;
import com.cafe.swhackathonserver.exception.section.SectionNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    @Transactional
    public Long create(String name){
        if(sectionRepository.existsByName(name))
            throw new SectionDuplicationException();

        Section savedSection = sectionRepository.save(new Section(name));
        return savedSection.getId();
    }

    @Transactional
    public Long delete(Long id){
        Section section = sectionRepository.findById(id).orElseThrow(SectionNotFoundException::new);
        sectionRepository.delete(section);
        return id;
    }
}
