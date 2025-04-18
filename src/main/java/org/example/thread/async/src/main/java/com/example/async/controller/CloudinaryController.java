package com.example.async.controller;

import com.example.async.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "CLOUDINARY_CONTROLLER")
@RequestMapping("/cloudinary")
public class CloudinaryController {

    private final CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestPart MultipartFile file,
                                        @RequestParam String folderName) throws IOException {
        byte[] fileBytes = file.getBytes();
        String fileName = file.getOriginalFilename();
        return ResponseEntity.ok(cloudinaryService.uploadFileAsync(fileBytes, fileName, folderName));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteFile(@RequestParam String publicId) throws IOException {
        return ResponseEntity.ok(cloudinaryService.deleteFile(publicId));
    }
}
