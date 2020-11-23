package com.mcw.mycarwash.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "doccode")
public class DocumentCode {

    @Id
    @Column
    private String docId;
    @Column
    private String clientId;
    @Column
    private int autoCode;
    @Column
    private String autoStartChr;


    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getAutoCode() {
        return autoCode;
    }

    public void setAutoCode(int autoCode) {
        this.autoCode = autoCode;
    }

    public String getAutoStartChr() {
        return autoStartChr;
    }

    public void setAutoStartChr(String autoStartChr) {
        this.autoStartChr = autoStartChr;
    }
}
