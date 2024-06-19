package com.example.dfs_aplicacao_c.service;

import com.example.dfs_aplicacao_c.entity.FILE_DATA;
import com.example.dfs_aplicacao_c.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "C:/Users/ADM/Desktop/Files/AppC/";

    public String uploadFileToFileSystem(MultipartFile file) throws IOException {
        // Verifica se a pasta existe, caso contrário cria a pasta
        File directory = new File(FOLDER_PATH);
        if (!directory.exists()) {
            directory.mkdirs(); // Cria a pasta e subpastas se não existirem
        }

        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FILE_DATA fileData = fileDataRepository.save(FILE_DATA.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadFileFromFileSystem(String fileName) throws IOException {
        Optional<FILE_DATA> fileData = fileDataRepository.findByName(fileName);
        if (fileData.isPresent()) {
            String filePath = fileData.get().getFilePath();
            return Files.readAllBytes(new File(filePath).toPath());
        }
        return null;
    }
}

