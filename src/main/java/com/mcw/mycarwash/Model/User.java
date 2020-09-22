package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    @Column
    private int userId;
    @Column
    private int clientId;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Column
    private String userEmail;
    @Column
    private int userMobileNumber;
    @Column
    private int isactive;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(int userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
}
