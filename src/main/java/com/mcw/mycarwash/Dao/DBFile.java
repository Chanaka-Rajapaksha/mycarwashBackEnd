package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.ImageFile;

public interface DBFile {
    ImageFile getbyimgid(String clientId, String imgId);
}
