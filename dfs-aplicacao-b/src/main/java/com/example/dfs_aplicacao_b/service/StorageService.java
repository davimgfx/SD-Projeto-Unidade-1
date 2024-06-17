package com.example.dfs_aplicacao_b.service;

import com.example.dfs_aplicacao_b.entity.FILE_DATA;
import com.example.dfs_aplicacao_b.entity.ImageData;
import com.example.dfs_aplicacao_b.repository.FileDataRepository;
import com.example.dfs_aplicacao_b.repository.StorageRepository;
import com.example.dfs_aplicacao_b.utils.ImageUtils;
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

    private final String FOLDER_PATH = "C:/Users/ADM/Desktop/Files/"; ;

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FILE_DATA fileData=fileDataRepository.save(FILE_DATA.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FILE_DATA> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }



}