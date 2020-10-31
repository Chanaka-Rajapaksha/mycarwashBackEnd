package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String userId;
    @Column
    private String clientId;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Column
    private String userEmail;
    @Column
    private int userMobileNumber;
    @Column
    private String userRemark;
    @Column
    private int isactive;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
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

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
}
