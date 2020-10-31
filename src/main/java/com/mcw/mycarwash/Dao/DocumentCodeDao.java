package com.mcw.mycarwash.Dao;

import com.mcw.mycarwash.Model.DocumentCode;

public interface DocumentCodeDao {
    public String addDocCode(DocumentCode documentCode) throws Exception;

    public String editDocCode(DocumentCode documentCode) throws Exception;

    public String updateAutoCode(DocumentCode documentCode) throws Exception;

    public String nextDocNumber(String clientId, String docCode) throws Exception;

}
