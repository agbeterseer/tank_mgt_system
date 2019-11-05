/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.model.Tank;
import java.util.List;

/**
 *
 * @author Terseer
 */
public interface ITankService {

    Tank getTankById(Long tankId);

    Tank addTank(Tank tank);

    Tank updateTank(Tank tank, long id);

    void deleteTank(Tank tankId);

    List<Tank> getAllTanks();

    Tank setNewVol(long id, int new_vol_left);
}
