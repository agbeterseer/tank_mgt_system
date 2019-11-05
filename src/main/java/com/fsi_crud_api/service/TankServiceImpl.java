/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.exception.TankNotFoundException;
import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.daorepsitory.TankRepository;
import com.fsi_crud_api.exception.TankException;
import com.fsi_crud_api.model.Dispenser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Terseer
 */
@Service("tankService")
public class TankServiceImpl implements ITankService {

    @Autowired
    private TankRepository tankRepository;

    @Override
    public List<Tank> getAllTanks() {
        List<Tank> tanks = tankRepository.findAll();
        if (tanks.isEmpty()) {
            throw new TankNotFoundException("Not Found");
        }
        return tanks;
    }

    @Override
    public Tank getTankById(Long tankId) {
        Tank tank = tankRepository.findOne(tankId);
        if (tank == null || tank.getId() <= 0) {
            throw new TankNotFoundException("Not Found" + tankId);
        }
        return tank;
    }

    @Override
    public Tank addTank(Tank tank) {
        return tankRepository.save(tank);
    }

    @Override
    public Tank updateTank(Tank tank, long id) {
        /* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
         * if that variable is not coming in the @RequestBody annotation object. 
         */
        Tank tankrec = tankRepository.findOne(id);
        Dispenser dispsenser1 = tank.getDispenserid();

        if (tank.getName() == null || tank.getName().isEmpty()) {
            tank.setName(tankrec.getName());
        }
        if (tank.getTanktype() == null || tank.getTanktype().isEmpty()) {
            tank.setTanktype(tankrec.getTanktype());
        }
        if (tank.getStoredfuel() == null || tank.getStoredfuel().isEmpty()) {
            tank.setStoredfuel(tankrec.getStoredfuel());
        }
        if (tank.getLiter() == 0) {
            tank.setLiter(tankrec.getLiter());
        }
        if (dispsenser1.getId() == 0) {
            tank.setDispenserid(dispsenser1);
        }

        if (tank == null || tank.getId() <= 0) {
            throw new TankException("Tank to update doesn´t exist");
        }

        return tankRepository.save(tank);
    }

    @Override
    public void deleteTank(Tank tankId) {
        tankRepository.delete(tankId);
    }

    @Override
    public Tank setNewVol(long id, int new_vol_left) {
        Tank tank = tankRepository.findOne(id);
        tank.setLiter(new_vol_left);
        tankRepository.save(tank);
        return tank;
    }

}
