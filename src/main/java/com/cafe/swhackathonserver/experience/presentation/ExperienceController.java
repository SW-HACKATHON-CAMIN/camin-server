package com.cafe.swhackathonserver.experience.presentation;

import com.cafe.swhackathonserver.experience.application.ExperienceService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExperienceController {
    private static ExperienceService experienceService;
}
