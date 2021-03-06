package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Exceptions.ResponseMessage;
import com.mcw.mycarwash.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;

    @Autowired
    private ServletContext servletContext;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(value = "filename") String filename) {
        String message = "";
        try {
            fileService.save(file, filename);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename, HttpServletRequest request) throws IOException {
        Resource file = fileService.load(filename);
        String mimeType = request.getServletContext().getMimeType(file.getFilename());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + file.getFilename())
                .body(file);
    }

    @GetMapping("/byname/{filename}")
    @CrossOrigin
    public ResponseEntity getbyname(@PathVariable String filename) throws IOException {
        final Path root = Paths.get("upload");
        //Resource file = fileService.load(filename);
        File file2 = new File(root.toUri().getPath().substring(1));
        File[] files = file2.listFiles();
        for (File f : files) {
            String fname = f.getName().split("\\.")[0];
            if (fname.equalsIgnoreCase(filename)) {
                String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/upload/").path(f.getName()).toString();
//                System.out.println(servletContext.getContextPath()+"/upolad/"+f.getName());

            }
        }
        return null;
    }
}

