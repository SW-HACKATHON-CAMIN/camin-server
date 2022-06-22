package com.cafe.swhackathonserver.experience.application;

import com.cafe.swhackathonserver.experience.domain.repository.ExperienceRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private static ExperienceRepository experienceRepository;
}
