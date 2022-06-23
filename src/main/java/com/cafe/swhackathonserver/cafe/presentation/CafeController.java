package com.cafe.swhackathonserver.cafe.presentation;

import com.cafe.swhackathonserver.cafe.application.CafeService;
import com.cafe.swhackathonserver.cafe.application.dto.CafeDetailDto;
import com.cafe.swhackathonserver.cafe.application.dto.CafeSimpleDto;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CafeCreateRequest;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CafeUpdateRequest;
import com.cafe.swhackathonserver.doc.ApiDoc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cafe")
public class CafeController {
    private final CafeService cafeService;

    @ApiOperation(value = ApiDoc.CREATE_CAFE)
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CafeCreateRequest request) {

        Long createdId = cafeService.create(request);
        return ResponseEntity.ok(createdId);
    }

    @ApiOperation(value = ApiDoc.DELETE_CAFE)
    @DeleteMapping("/{cafeId}")
    public ResponseEntity<Long> delete(@PathVariable Long cafeId) {
        Long id = cafeService.delete(cafeId);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = ApiDoc.FIND_CAFE)
    @GetMapping("/{cafeId}")
    public ResponseEntity<CafeDetailDto> find(@PathVariable Long cafeId, @RequestParam("userId") Long userId) {
        CafeDetailDto response = cafeService.findById(cafeId, userId);
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

    @ApiOperation(value = ApiDoc.CAFFE_CONTENT_UPDATE)
    @PostMapping("/{cafeId}")
    public ResponseEntity<Boolean> updateCafeContent(@PathVariable Long cafeId, @RequestBody CafeUpdateRequest request){
        cafeService.updateCafe(cafeId, request.getCafeName());
        return ResponseEntity.ok(true);
    }
}
