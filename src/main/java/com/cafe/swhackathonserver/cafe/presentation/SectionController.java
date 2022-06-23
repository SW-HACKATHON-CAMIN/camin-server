package com.cafe.swhackathonserver.cafe.presentation;


import java.util.List;

import com.cafe.swhackathonserver.cafe.application.SectionService;
import com.cafe.swhackathonserver.cafe.application.dto.section.SectionInfoDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.SectionCreateRequest;
import com.cafe.swhackathonserver.doc.ApiDoc;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;

    @ApiOperation(value = ApiDoc.CREATE_SECTION)
    @PostMapping
    public ResponseEntity<Long> crate(@RequestBody SectionCreateRequest request) {
        Long sectionId = sectionService.create(request.getName());
        return ResponseEntity.ok(sectionId);
    }

    @ApiOperation(value = ApiDoc.DELETE_SECTION)
    @DeleteMapping("/{sectionId}")
    public ResponseEntity<Long> delete(@PathVariable Long sectionId) {
        Long deletedId = sectionService.delete(sectionId);
        return ResponseEntity.ok(deletedId);
    }

    @ApiOperation(value = ApiDoc.FIND_ADMINS_SECTION)
    @GetMapping("/admin/{managerId}")
    public ResponseEntity<List<SectionInfoDto>> findAdminSections(@PathVariable Long managerId){
        List<SectionInfoDto> response = sectionService.findAdminSections(managerId);
        return ResponseEntity.ok(response);
    }
}
