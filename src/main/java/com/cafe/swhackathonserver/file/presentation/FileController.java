package com.cafe.swhackathonserver.file.presentation;

import com.cafe.swhackathonserver.doc.ApiDoc;
import com.cafe.swhackathonserver.file.application.FileService;
import com.cafe.swhackathonserver.file.application.dto.ImageResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class FileController {
    private final FileService fileService;

    @ApiOperation(value = ApiDoc.UPLOAD_IMAGE)
    @PostMapping("/image")
    public ResponseEntity<ImageResponse> uploadImage(@RequestParam("file") MultipartFile file) {

        String uploadedImageUrl = fileService.uploadImage(file);
        return ResponseEntity.ok(new ImageResponse(uploadedImageUrl));
    }

    @ApiOperation(value = ApiDoc.UPLOAD_IMAGE_LIST)
    @PostMapping("/image/list")
    public ResponseEntity<List<ImageResponse>> uploadImage(@RequestParam("file") List<MultipartFile> fileList) {
        List<ImageResponse> uploadedImageUrlList = new ArrayList<>();
        for (MultipartFile file : fileList) {
            uploadedImageUrlList.add(new ImageResponse(fileService.uploadImage(file)));
        }

        return ResponseEntity.ok(uploadedImageUrlList);
    }

}
