package com.example.dfs_aplicacao_a_mestre_app.service;

import com.example.dfs_aplicacao_a_mestre_app.client.AppBClient;
import com.example.dfs_aplicacao_a_mestre_app.client.AppCClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

@Service
public class FileOrchestrationService {

    @Autowired
    private AppBClient appBClient;

    @Autowired
    private AppCClient appCClient;

    private final Random random = new Random();
    
    private static final Logger logger = LoggerFactory.getLogger(FileOrchestrationService.class);

    public String uploadFile(MultipartFile file) throws IOException {
        int choice = random.nextInt(2);
        ResponseEntity<String> response;
        logger.info("Random choice: " + choice);
        try {
            if (choice == 0) {
                logger.info("Uploading to AppB");
                response = appBClient.uploadFileToFileSystem(file);
                logger.info("Response from AppB: " + response.getBody());
                return "AppB: " + response.getBody();
            } else {
                logger.info("Uploading to AppC");
                response = appCClient.uploadFileToFileSystem(file);
                logger.info("Response from AppC: " + response.getBody());
                return "AppC: " + response.getBody();
            }
        } catch (Exception e) {
            logger.error("Error during file upload", e);
            throw new IOException("Error during file upload: " + e.getMessage(), e);
        }
    }

    public byte[] downloadFile(String fileName) throws IOException {
        ResponseEntity<byte[]> response;
        try {
            response = appBClient.downloadFileFromFileSystem(fileName);
            if (response.getStatusCode().is2xxSuccessful()) {
                logger.info("File found in AppB");
                return response.getBody();
            }
        } catch (Exception e) {
            logger.error("Error downloading file from AppB", e);
        }
        try {
            response = appCClient.downloadFileFromFileSystem(fileName);
            if (response.getStatusCode().is2xxSuccessful()) {
                logger.info("File found in AppC");
                return response.getBody();
            }
        } catch (Exception e) {
            logger.error("Error downloading file from AppC", e);
        }
        return null;
    }
}