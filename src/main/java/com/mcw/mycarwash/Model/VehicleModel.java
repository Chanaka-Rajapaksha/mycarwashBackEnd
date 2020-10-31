package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_model")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int vmodelId;
    @Column
    private int vtypeId;
    @Column
    private String vmodelName;
    @Column
    private String vmodelDescription;
    @Column
    private int iasctive;

    public int getVmodelId() {
        return vmodelId;
    }

    public void setVmodelId(int vmodelId) {
        this.vmodelId = vmodelId;
    }

    public int getVtypeId() {
        return vtypeId;
    }

    public void setVtypeId(int vtypeId) {
        this.vtypeId = vtypeId;
    }

    public String getVmodelName() {
        return vmodelName;
    }

    public void setVmodelName(String vmodelName) {
        this.vmodelName = vmodelName;
    }

    public String getVmodelDescription() {
        return vmodelDescription;
    }

    public void setVmodelDescription(String vmodelDescription) {
        this.vmodelDescription = vmodelDescription;
    }

    public int getIasctive() {
        return iasctive;
    }

    public void setIasctive(int iasctive) {
        this.iasctive = iasctive;
    }
}
