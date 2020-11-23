package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column
    private String clientId;
    @Column
    private String clientName;
    @Column
    private String clientAddressLine1;
    @Column
    private String clientAddressLine2;
    @Column
    private String clientAddressLine3;
    @Column
    private String clientEmail;
    @Column
    private int clientContactNumber;
    @Column
    private String clientWeb;
    @Column
    private Double clientLatitude;
    @Column
    private Double clientLongitude;
    @Column
    private String remark;
    @Column
    private int isactive;
    @Column
    private String imageId;
    @Column
    private String imageURL;


    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddressLine1() {
        return clientAddressLine1;
    }

    public void setClientAddressLine1(String clientAddressLine1) {
        this.clientAddressLine1 = clientAddressLine1;
    }

    public String getClientAddressLine2() {
        return clientAddressLine2;
    }

    public void setClientAddressLine2(String clientAddressLine2) {
        this.clientAddressLine2 = clientAddressLine2;
    }

    public String getClientAddressLine3() {
        return clientAddressLine3;
    }

    public void setClientAddressLine3(String clientAddressLine3) {
        this.clientAddressLine3 = clientAddressLine3;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientContactNumber() {
        return clientContactNumber;
    }

    public void setClientContactNumber(int clientContactNumber) {
        this.clientContactNumber = clientContactNumber;
    }

    public String getClientWeb() {
        return clientWeb;
    }

    public void setClientWeb(String clientWeb) {
        this.clientWeb = clientWeb;
    }

    public Double getClientLatitude() {
        return clientLatitude;
    }

    public void setClientLatitude(Double clientLatitude) {
        this.clientLatitude = clientLatitude;
    }

    public Double getClientLongitude() {
        return clientLongitude;
    }

    public void setClientLongitude(Double clientLongitude) {
        this.clientLongitude = clientLongitude;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
}
