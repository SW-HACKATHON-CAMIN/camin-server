package com.cafe.swhackathonserver.experience.presentation;

import com.cafe.swhackathonserver.experience.application.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ExperienceController {
    private static ExperienceService experienceService;
}
