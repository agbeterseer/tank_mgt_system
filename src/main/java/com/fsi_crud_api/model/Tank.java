/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Terseer
 */
@Entity
@Table(name = "tanks")
public class Tank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "tank_type")
    private String tanktype;
    @Column(name = "stored_fuel")
    private String storedfuel;
    @Column(name = "liter")
    private int liter;
    @Column(name = "dispenser_id")
    @OneToOne
    private Dispenser dispenserid;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDateTime;

    public Tank() {
    }

    public Tank(long id, String name, String tanktype, String storedfuel, int liter, Dispenser dispenserid) {
        this.id = id;
        this.name = name;
        this.tanktype = tanktype;
        this.storedfuel = storedfuel;
        this.liter = liter;
        this.dispenserid = dispenserid;
    }

    public Tank(String name, String tanktype, String storedfuel, int liter, Dispenser dispenserid) {
        this.name = name;
        this.tanktype = tanktype;
        this.storedfuel = storedfuel;
        this.liter = liter;
        this.dispenserid = dispenserid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTanktype() {
        return tanktype;
    }

    public void setTanktype(String tanktype) {
        this.tanktype = tanktype;
    }

    public String getStoredfuel() {
        return storedfuel;
    }

    public void setStoredfuel(String storedfuel) {
        this.storedfuel = storedfuel;
    }

    public int getLiter() {
        return liter;
    }

    public void setLiter(int liter) {
        this.liter = liter;
    }

    public Dispenser getDispenserid() {
        return dispenserid;
    }

    public void setDispenserid(Dispenser dispenserid) {
        this.dispenserid = dispenserid;
    }
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
    @Override
    public String toString() {
        return "com.fsi_crud_api.entity.Tank[ id=" + id + " ]";
    }



}
