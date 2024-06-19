package com.example.dfs_aplicacao_a_mestre_app.controller;

import com.example.dfs_aplicacao_a_mestre_app.service.FileOrchestrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/orchestrator/file")
public class FileOrchestrationController {

    @Autowired
    private FileOrchestrationService fileOrchestrationService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String response = fileOrchestrationService.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws IOException {
        byte[] fileData = fileOrchestrationService.downloadFile(fileName);
        if (fileData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                    .body(fileData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}