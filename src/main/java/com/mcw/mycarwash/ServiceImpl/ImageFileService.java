package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.ImageFileRepository;
import com.mcw.mycarwash.Exceptions.FileNotFoundException;
import com.mcw.mycarwash.Exceptions.FileStorageException;
import com.mcw.mycarwash.Model.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageFileService {

    @Autowired
    private ImageFileRepository dbFileRepository;

    public ImageFile storeFile(MultipartFile file, String imageId) {
        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = file.getOriginalFilename().split("\\.")[1];
        String fileName = imageId + "." + extension;

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid characters " + fileName);
            }
            ImageFile dbFile = new ImageFile(fileName, file.getContentType(), imageId, file.getBytes());
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public ImageFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }

    public ImageFile getFileByImageId(String imgId) {
        return dbFileRepository.findByImageId(imgId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + imgId));
    }

    public ImageFile getFileByName(String name) {
        return dbFileRepository.findByFileNameContaining(name)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + name));
    }
}
