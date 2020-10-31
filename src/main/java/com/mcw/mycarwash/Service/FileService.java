package com.mcw.mycarwash.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

     void init();

     void save(MultipartFile file,String filename);

     Resource load(String name);


}
