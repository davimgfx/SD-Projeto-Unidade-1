package com.example.dfs_aplicacao_b.repository;

import com.example.dfs_aplicacao_b.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);
}