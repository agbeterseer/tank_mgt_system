/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.model.Dispenser;
import org.springframework.stereotype.Service;
import com.fsi_crud_api.daorepsitory.DispenserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Terseer
 */
@Service("dispenserService")
public class DispenserServiceImpl implements IDispenserService {

    @Autowired
    private DispenserRepository dispenserRepository;

    @Override
    public List<Dispenser> getAllDispensers() {
        return dispenserRepository.findAll();
    }

    @Override
    public Dispenser getDispenserById(long dispenserId) {
        return dispenserRepository.findOne(dispenserId);
    }

    @Override
    public Dispenser addDispenser(Dispenser dispenser) {
        return dispenserRepository.save(dispenser);
    }

    @Override
    public Dispenser updateDispenser(Dispenser dispenser) {
        return dispenserRepository.save(dispenser);
    }

    @Override
    public void deleteDispenser(Dispenser dispenserId) {
        dispenserRepository.delete(dispenserId);
    }

}
