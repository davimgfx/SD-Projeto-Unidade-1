package com.example.dfs_aplicacao_c.controller;

import com.example.dfs_aplicacao_c.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/file")
public class StorageServiceApplication {

    @Autowired
    private StorageService service;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFileToFileSystem(@RequestParam("file") MultipartFile file) throws IOException {
        String uploadMessage = service.uploadFileToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadMessage);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFileFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] fileData = service.downloadFileFromFileSystem(fileName);
        if (fileData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                    .body(fileData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("File not found");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }
}
