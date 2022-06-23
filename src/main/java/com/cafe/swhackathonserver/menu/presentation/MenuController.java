package com.cafe.swhackathonserver.menu.presentation;

import com.cafe.swhackathonserver.doc.ApiDoc;
import com.cafe.swhackathonserver.menu.application.MenuService;
import com.cafe.swhackathonserver.menu.application.dto.MenuCreateDto;
import com.cafe.swhackathonserver.menu.presentation.dto.request.MenuCreateRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    @ApiOperation(value = ApiDoc.CREATE_MENU)
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody MenuCreateRequest request){
        Long id = menuService.create(request.getCafeId(), MenuCreateDto.from(request));
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = ApiDoc.DELETE_MENU)
    @DeleteMapping("/{menuId}")
    public ResponseEntity<Long> delete(@PathVariable Long menuId){
        Long id = menuService.delete(menuId);
        return ResponseEntity.ok(id);
    }

}
