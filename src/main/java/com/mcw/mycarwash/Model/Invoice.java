package com.mcw.mycarwash.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="invoice")
public class Invoice {

    @Id
    @Column
    private String invoiceId;
    @Column
    private String clientId;
    @Column
    private String bookingId;
    @Column
    private String cusId;
    @Column
    private Double invoiceAmt;
    @Column
    private Double discountAmt;
    @Column
    private Double discountedAmt;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public Double getInvoiceAmt() {
        return invoiceAmt;
    }

    public void setInvoiceAmt(Double invoiceAmt) {
        this.invoiceAmt = invoiceAmt;
    }

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Double getDiscountedAmt() {
        return discountedAmt;
    }

    public void setDiscountedAmt(Double discountedAmt) {
        this.discountedAmt = discountedAmt;
    }
}
