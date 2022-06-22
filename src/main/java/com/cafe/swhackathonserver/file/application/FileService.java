package com.cafe.swhackathonserver.file.application;

import com.cafe.swhackathonserver.exception.file.FileUploadException;
import com.jlefebure.spring.boot.minio.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RequiredArgsConstructor
@Service
public class FileService {
    private final MinioService minioService;

    public String uploadImage(MultipartFile file) {
        String filePath = null;
        String MINIO_URL = "http://118.67.133.82:9000";
        String MINIO_BUCKET = "bucket";
        try {
            Path path = Path.of(file.getOriginalFilename());

            minioService.upload(path, file.getInputStream(), file.getContentType());
            filePath = MINIO_URL + "/" + MINIO_BUCKET + "/" + path;
        } catch (Exception exception) {
            throw new FileUploadException();
        }
        return filePath;
    }
}
