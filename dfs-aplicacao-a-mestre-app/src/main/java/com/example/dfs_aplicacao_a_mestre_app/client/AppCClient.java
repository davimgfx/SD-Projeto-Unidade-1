package com.example.dfs_aplicacao_a_mestre_app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FeignClient(name = "dfs-app-c", url = "http://localhost:8283/file")
public interface AppCClient {
    @PostMapping("/upload")
    ResponseEntity<String> uploadFileToFileSystem(@RequestParam("file") MultipartFile file) throws IOException;

    @GetMapping("/download/{fileName}")
    ResponseEntity<byte[]> downloadFileFromFileSystem(@PathVariable("fileName") String fileName) throws IOException;
}
