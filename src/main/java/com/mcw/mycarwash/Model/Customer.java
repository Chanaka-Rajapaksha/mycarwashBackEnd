package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String cusId;
    @Column
    private String cusFname;
    @Column
    private String cusLname;
    @Column
    private String cusEmail;
    @Column
    private int cusMobileNumber;

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

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public int getCusMobileNumber() {
        return cusMobileNumber;
    }

    public void setCusMobileNumber(int cusMobileNumber) {
        this.cusMobileNumber = cusMobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", cusFname='" + cusFname + '\'' +
                ", cusLname='" + cusLname + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusMobileNumber=" + cusMobileNumber +
                '}';
    }
}
