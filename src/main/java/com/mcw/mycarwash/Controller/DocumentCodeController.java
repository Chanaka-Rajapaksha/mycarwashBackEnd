package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.DocumentCode;
import com.mcw.mycarwash.Service.DocumentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docodeapi")
public class DocumentCodeController {

    @Autowired
    private DocumentCodeService documentCodeService;

    @GetMapping("/nextdocnumber")
    public String nextDocNumber(@RequestBody DocumentCode documentCode) throws Exception {
        return documentCodeService.nextDocNumber(documentCode.getClientId(), documentCode.getDocId());
    }
}
