package com.mcw.mycarwash.ServiceImpl;

import com.mcw.mycarwash.Dao.DocumentCodeDao;
import com.mcw.mycarwash.Model.DocumentCode;
import com.mcw.mycarwash.Service.DocumentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentCodeServiceImpl implements DocumentCodeService {

    @Autowired
    private DocumentCodeDao documentCodeDao;

    @Override
    public String addDocCode(DocumentCode documentCode) throws Exception {
        return documentCodeDao.addDocCode(documentCode);
    }

    @Override
    public String editDocCode(DocumentCode documentCode) throws Exception {
        return documentCodeDao.editDocCode(documentCode);
    }

    @Override
    public String updateAutoCode(DocumentCode documentCode) throws Exception {
        return documentCodeDao.updateAutoCode(documentCode);
    }

    @Override
    public String nextDocNumber(String clientId, String docCode) throws Exception {
        return documentCodeDao.nextDocNumber(clientId,docCode);
    }
}
