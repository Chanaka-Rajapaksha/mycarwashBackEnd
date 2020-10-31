package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name ="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int vehicleId;
    @Column
    private int vtypeId;
    @Column
    private int vmodelId;
    @Column
    private String vehicleName;
    @Column
    private String vehicleDescription;
    @Column
    private int isactive;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getVtypeId() {
        return vtypeId;
    }

    public void setVtypeId(int vtypeId) {
        this.vtypeId = vtypeId;
    }

    public int getVmodelId() {
        return vmodelId;
    }

    public void setVmodelId(int vmodelId) {
        this.vmodelId = vmodelId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
}
