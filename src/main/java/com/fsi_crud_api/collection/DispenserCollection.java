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
public class DispenserCollection {

    @NotNull
    @Size(min = 2)
    private List<Long> dispensersIds;

    public List<Long> getDispensersIds() {
        return dispensersIds;
    }

    public void setBirdsIds(List<Long> dispensers) {
        this.dispensersIds = dispensers;
    }
}
