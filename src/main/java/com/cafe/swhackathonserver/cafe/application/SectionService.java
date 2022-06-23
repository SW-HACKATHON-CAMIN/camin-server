package com.cafe.swhackathonserver.cafe.application;

import java.util.List;
import java.util.stream.Collectors;

import com.cafe.swhackathonserver.cafe.application.dto.section.SectionInfoDto;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.repository.CafeRepository;
import com.cafe.swhackathonserver.cafe.domain.repository.SectionRepository;
import com.cafe.swhackathonserver.cafe.domain.section.Section;
import com.cafe.swhackathonserver.exception.section.SectionDuplicationException;
import com.cafe.swhackathonserver.exception.section.SectionNotFoundException;
import com.cafe.swhackathonserver.exception.user.UserNotFoundException;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.domain.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;
    private final CafeRepository cafeRepository;
    private final UserRepository userRepository;

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

    @Transactional(readOnly = true)
    public List<SectionInfoDto> findAdminSections(Long managerId){
        User user = userRepository.findById(managerId).orElseThrow(UserNotFoundException::new);
        Cafe cafe = cafeRepository.findFirstByManager(user);
        return cafe.getCafeSections().stream().map(SectionInfoDto::new).collect(Collectors.toList());
    }
}
