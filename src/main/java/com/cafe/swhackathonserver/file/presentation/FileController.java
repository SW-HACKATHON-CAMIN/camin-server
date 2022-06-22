package com.cafe.swhackathonserver.file.presentation;

import com.cafe.swhackathonserver.file.application.FileService;
import com.cafe.swhackathonserver.file.application.dto.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class FileController {
    private final FileService fileService;

    @PostMapping("/image")
    public ResponseEntity<ImageResponse> uploadImage(@RequestParam("file") MultipartFile file) {

        String uploadedImageUrl = fileService.uploadImage(file);
        return ResponseEntity.ok(new ImageResponse(uploadedImageUrl));
    }

    @PostMapping("/image/list")
    public ResponseEntity<List<ImageResponse>> uploadImage(@RequestParam("file") List<MultipartFile> fileList) {
        List<ImageResponse> uploadedImageUrlList = new ArrayList<>();
        for (MultipartFile file : fileList) {
            uploadedImageUrlList.add(new ImageResponse(fileService.uploadImage(file)));
        }

        return ResponseEntity.ok(uploadedImageUrlList);
    }

}
