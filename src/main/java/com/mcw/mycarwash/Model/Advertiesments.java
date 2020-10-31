package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name = "advertisement")
public class Advertiesments {

    @Id
    @Column
    private String advId;
    @Column
    private int clientId;
    @Column
    private int vehicleId;
    @Column
    private String advTitle;
    @Column
    private String advDescription;
    @Column
    private Double advAmount;
    @Column
    private Double advSecAmount;
    @Column
    private Double advDiscountAmt;
    @Column
    private String advImage;
    @Column
    private int avdRating;
    @Column
    private int isactive;

  public String getAdvId() {
    return advId;
  }

  public void setAdvId(String advId) {
    this.advId = advId;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getAdvTitle() {
    return advTitle;
  }

  public void setAdvTitle(String advTitle) {
    this.advTitle = advTitle;
  }

  public String getAdvDescription() {
    return advDescription;
  }

  public void setAdvDescription(String advDescription) {
    this.advDescription = advDescription;
  }

  public Double getAdvAmount() {
    return advAmount;
  }

  public void setAdvAmount(Double advAmount) {
    this.advAmount = advAmount;
  }

  public Double getAdvSecAmount() {
    return advSecAmount;
  }

  public void setAdvSecAmount(Double advSecAmount) {
    this.advSecAmount = advSecAmount;
  }

  public Double getAdvDiscountAmt() {
    return advDiscountAmt;
  }

  public void setAdvDiscountAmt(Double advDiscountAmt) {
    this.advDiscountAmt = advDiscountAmt;
  }

  public String getAdvImage() {
    return advImage;
  }

  public void setAdvImage(String advImage) {
    this.advImage = advImage;
  }

  public int getAvdRating() {
    return avdRating;
  }

  public void setAvdRating(int avdRating) {
    this.avdRating = avdRating;
  }

  public int getIsactive() {
    return isactive;
  }

  public void setIsactive(int isactive) {
    this.isactive = isactive;
  }
}
