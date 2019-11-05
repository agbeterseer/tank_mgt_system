/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.collection;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Terseer
 */
public class TankCollection {

    @NotNull
    @Size(min = 2)
    private List<Long> tanksIds;

    public List<Long> getTanksIds() {
        return tanksIds;
    }

    public void setTanksIds(List<Long> tanks) {
        this.tanksIds = tanks;
    }
}
