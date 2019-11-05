/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.response;

import com.fsi_crud_api.model.Dispenser;
import java.time.LocalDateTime;

/**
 *
 * @author Terseer
 */
public class TankResponse {

    private String name;
    private String tanktype;
    private String storedfuel;
    private int liter;
    private Dispenser dispenserid;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public TankResponse(String name, String tanktype, String storedfuel, int liter, Dispenser dispenserid, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.name = name;
        this.tanktype = tanktype;
        this.storedfuel = storedfuel;
        this.liter = liter;
        this.dispenserid = dispenserid;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
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
        return "TankResponse{" + "name=" + name + ", tanktype=" + tanktype + ", storedfuel=" + storedfuel + ", liter=" + liter + ", dispenserid=" + dispenserid + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + '}';
    }
    
    
}
