package com.mcw.mycarwash.Model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int vtypeId;
    @Column
    private String vtypeName;
    @Column
    private String vtypeDescription;
    @Column
    private int isactive;

    public int getVtypeId() {
        return vtypeId;
    }

    public void setVtypeId(int vtypeId) {
        this.vtypeId = vtypeId;
    }

    public String getVtypeName() {
        return vtypeName;
    }

    public void setVtypeName(String vtypeName) {
        this.vtypeName = vtypeName;
    }

    public String getVtypeDescription() {
        return vtypeDescription;
    }

    public void setVtypeDescription(String vtypeDescription) {
        this.vtypeDescription = vtypeDescription;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
}
