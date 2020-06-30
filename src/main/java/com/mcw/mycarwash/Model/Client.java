package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name ="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String clientId;
    @Column
    private String clientName;
    @Column
    private String clientDescription;
    @Column
    private String clientPassword;
    @Column
    private String clientAddressLine1;
    @Column
    private String clientAddressLine2;
    @Column
    private String clientAddressLine3;
    @Column
    private int clientMobileNumber;
    @Column
    private String clientEmail;
    @Column
    private Double clientLatitude;
    @Column
    private Double clientLongitude;
    @Column
    private int clientStates;

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

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
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

    public int getClientMobileNumber() {
        return clientMobileNumber;
    }

    public void setClientMobileNumber(int clientMobileNumber) {
        this.clientMobileNumber = clientMobileNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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

    public int getClientStates() {
        return clientStates;
    }

    public void setClientStates(int clientStates) {
        this.clientStates = clientStates;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientDescription='" + clientDescription + '\'' +
                ", clientPassword='" + clientPassword + '\'' +
                ", clientAddressLine1='" + clientAddressLine1 + '\'' +
                ", clientAddressLine2='" + clientAddressLine2 + '\'' +
                ", clientAddressLine3='" + clientAddressLine3 + '\'' +
                ", clientMobileNumber=" + clientMobileNumber +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientLatitude=" + clientLatitude +
                ", clientLongitude=" + clientLongitude +
                ", clientStates=" + clientStates +
                '}';
    }
}
