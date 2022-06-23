package com.cafe.swhackathonserver.cafe.presentation;

import java.math.BigDecimal;
import java.util.List;

import com.cafe.swhackathonserver.cafe.application.CafeService;
import com.cafe.swhackathonserver.cafe.application.dto.CafeDetailDto;
import com.cafe.swhackathonserver.cafe.application.dto.CafeSimpleDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CafeCreateRequest;
import com.cafe.swhackathonserver.category.domain.CafeCategory;
import com.cafe.swhackathonserver.doc.ApiDoc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cafe")
public class CafeController {
    private final CafeService cafeService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CafeCreateRequest request) {

        Long createdId = cafeService.create(request);
        return ResponseEntity.ok(createdId);
    }

    @DeleteMapping("/{cafeId}")
    public ResponseEntity<Long> delete(@PathVariable Long cafeId) {
        Long id = cafeService.delete(cafeId);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = ApiDoc.FIND_CAFE)
    @GetMapping("/{cafeId}")
    public ResponseEntity<CafeDetailDto> find(@PathVariable Long cafeId) {
        CafeDetailDto response = cafeService.findById(cafeId);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = ApiDoc.FIND_NEAR_FITERED_CAFE)
    @GetMapping
    public ResponseEntity<List<CafeSimpleDto>> findByFilter(
            @RequestParam("latitude") BigDecimal latitude,
            @RequestParam("longitude") BigDecimal longitude,
            @RequestParam(value = "categoryIds", required = false, defaultValue = "") List<Long> categoryIds) {
        List<CafeSimpleDto> response = cafeService.findByFilter(latitude, longitude, categoryIds);
        return ResponseEntity.ok(response);
    }
}
