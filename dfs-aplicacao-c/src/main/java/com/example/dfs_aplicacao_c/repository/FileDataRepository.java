package com.example.dfs_aplicacao_c.repository;

import com.example.dfs_aplicacao_c.entity.FILE_DATA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FILE_DATA,Integer> {
    Optional<FILE_DATA> findByName(String fileName);
}
