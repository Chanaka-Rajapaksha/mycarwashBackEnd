package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.ImageFile;
import com.mcw.mycarwash.Model.ImageResponse;
import com.mcw.mycarwash.ServiceImpl.ImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ImageController {
    @Autowired
    private ImageFileService fileStorageService;

    @PostMapping("/uploadFile")
    public ImageResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("imageid") String imageid) {
        ImageFile fileName = fileStorageService.storeFile(file, imageid);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/getfileurl/")
                .path(fileName.getFileName())
                .toUriString();
        return new ImageResponse(fileName.getFileName(), fileDownloadUri, file.getContentType(), file.getSize(), imageid);
    }

    @GetMapping("/downloadFileByName/{imageId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String imageId) {

        ImageFile imageFile = fileStorageService.getFileByImageId(imageId);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/getfileurl/")
                .path(imageFile.getFileName())
                .toUriString();
        System.out.println(fileDownloadUri);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageFile.getFileName() + "\"")
                .body(new ByteArrayResource(imageFile.getImage()));

    }

    @GetMapping("/getfileurl/{filename}")
    public ResponseEntity<Resource> getFileURL(@PathVariable String filename) {

        ImageFile imageFile = fileStorageService.getFileByName(filename);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFileByName/")
                .path(imageFile.getFileName())
                .toUriString();
        System.out.println(fileDownloadUri);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageFile.getFileName() + "\"")
                .body(new ByteArrayResource(imageFile.getImage()));

    }
}
