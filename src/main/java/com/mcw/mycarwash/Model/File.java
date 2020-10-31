package com.mcw.mycarwash.Model;

public class File {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
