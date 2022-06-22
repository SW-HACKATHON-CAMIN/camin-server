package com.cafe.swhackathonserver.cafe.presentation;


import com.cafe.swhackathonserver.cafe.application.SectionService;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.SectionCreateRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody SectionCreateRequest request){
        Long sectionId = sectionService.create(request.getName());
        return ResponseEntity.ok(sectionId);
    }

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<Long> delete(@PathVariable Long sectionId){
        Long deletedId = sectionService.delete(sectionId);
        return ResponseEntity.ok(deletedId);
    }
}
