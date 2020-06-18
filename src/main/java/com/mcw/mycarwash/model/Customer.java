package com.mcw.mycarwash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    private String cusId;
    private String cusFname;
    private String cusLname;
    private String cus_addressLine1;
    private String cus_addressLine2;
    private String cus_addressLine3;
    private int cusMobileNumber;
    private String cusEmail;

    public Customer() {
    }

    public Customer(String cusId, String cusFname, String cusLname, int cusMobileNumber, String cusEmail) {
        this.cusId = cusId;
        this.cusFname = cusFname;
        this.cusLname = cusLname;
        this.cusMobileNumber = cusMobileNumber;
        this.cusEmail = cusEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusFname() {
        return cusFname;
    }

    public void setCusFname(String cusFname) {
        this.cusFname = cusFname;
    }

    public String getCusLname() {
        return cusLname;
    }

    public void setCusLname(String cusLname) {
        this.cusLname = cusLname;
    }

    public String getCus_addressLine1() {
        return cus_addressLine1;
    }

    public void setCus_addressLine1(String cus_addressLine1) {
        this.cus_addressLine1 = cus_addressLine1;
    }

    public String getCus_addressLine2() {
        return cus_addressLine2;
    }

    public void setCus_addressLine2(String cus_addressLine2) {
        this.cus_addressLine2 = cus_addressLine2;
    }

    public String getCus_addressLine3() {
        return cus_addressLine3;
    }

    public void setCus_addressLine3(String cus_addressLine3) {
        this.cus_addressLine3 = cus_addressLine3;
    }

    public int getCusMobileNumber() {
        return cusMobileNumber;
    }

    public void setCusMobileNumber(int cusMobileNumber) {
        this.cusMobileNumber = cusMobileNumber;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }
}
