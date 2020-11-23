package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
    Optional<ImageFile> findById(String name);
    Optional<ImageFile> findByImageId(String imgId);
    Optional<ImageFile> findByFileNameContaining(String name);

   }
