package com.mcw.mycarwash.Exceptions;

import java.util.Date;

public class ApplicationError {
    private int code;
    private Date timestamp;
    private String message;
    private String details;


    public ApplicationError( Date timestamp, String message, String details) {
        this.code = code;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
