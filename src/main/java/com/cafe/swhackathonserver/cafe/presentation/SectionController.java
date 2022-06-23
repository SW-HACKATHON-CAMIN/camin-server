package com.cafe.swhackathonserver.cafe.presentation;


import com.cafe.swhackathonserver.cafe.application.SectionService;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.SectionCreateRequest;
import com.cafe.swhackathonserver.doc.ApiDoc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;

    @ApiOperation(value = ApiDoc.CREATE_SECTION)
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody SectionCreateRequest request){
        Long sectionId = sectionService.create(request.getName());
        return ResponseEntity.ok(sectionId);
    }

    @ApiOperation(value = ApiDoc.DELETE_SECTION)
    @DeleteMapping("/{sectionId}")
    public ResponseEntity<Long> delete(@PathVariable Long sectionId){
        Long deletedId = sectionService.delete(sectionId);
        return ResponseEntity.ok(deletedId);
    }
}
