package com.mcw.mycarwash.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @Column
    private String bookingId;
    @Column
    private String clientId;
    @Column
    private String cusId;
    @Column
    private String serviceId;
    @Column
    private String vehicleId;
    @Column
    private int paytypeId;
    @Column
    private String bookingDate;
    @Column
    private String bookingTime;
    @Column
    private int isconfirm;
    @Column
    private int iscancel;
    @Column
    private String cancelRemark;
    @Column
    private int ispaid;
    @Column
    private String remark;
    @Column
    private int isactive;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getPaytypeId() {
        return paytypeId;
    }

    public void setPaytypeId(int paytypeId) {
        this.paytypeId = paytypeId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(int isconfirm) {
        this.isconfirm = isconfirm;
    }

    public int getIscancel() {
        return iscancel;
    }

    public void setIscancel(int iscancel) {
        this.iscancel = iscancel;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }

    public int getIspaid() {
        return ispaid;
    }

    public void setIspaid(int ispaid) {
        this.ispaid = ispaid;
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
