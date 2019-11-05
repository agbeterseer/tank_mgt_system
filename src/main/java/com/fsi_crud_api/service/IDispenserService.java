/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.model.Dispenser;
import java.util.List;

/**
 *
 * @author Terseer
 */
public interface IDispenserService {

    List<Dispenser> getAllDispensers();

    Dispenser getDispenserById(long dispenserId);

    Dispenser addDispenser(Dispenser dispenser);

    Dispenser updateDispenser(Dispenser dispenser);

    void deleteDispenser(Dispenser dispenserId);
}
