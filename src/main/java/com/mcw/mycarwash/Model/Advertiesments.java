package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name = "advertisement")
public class Advertiesments {

  @Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private String advId;
  @Column
  private int clientId;
  @Column
  private int vehicleModelId;
  @Column
  private String advTitle;
  @Column
    private String advDescription;
  @Column
    private Double advAmount;
  @Column
    private Double advDiscountAmt;
  @Column
    private  String advImagePath;
  @Column
    private int rating;
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

    public int getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
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

    public Double getAdvDiscountAmt() {
        return advDiscountAmt;
    }

    public void setAdvDiscountAmt(Double advDiscountAmt) {
        this.advDiscountAmt = advDiscountAmt;
    }

    public String getAdvImagePath() {
        return advImagePath;
    }

    public void setAdvImagePath(String advImagePath) {
        this.advImagePath = advImagePath;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "Advertiesments{" +
                "advId='" + advId + '\'' +
                ", clientId=" + clientId +
                ", vehicleModelId=" + vehicleModelId +
                ", advTitle='" + advTitle + '\'' +
                ", advDescription='" + advDescription + '\'' +
                ", advAmount=" + advAmount +
                ", advDiscountAmt=" + advDiscountAmt +
                ", advImagePath='" + advImagePath + '\'' +
                ", rating=" + rating +
                ", isactive=" + isactive +
                '}';
    }
}
