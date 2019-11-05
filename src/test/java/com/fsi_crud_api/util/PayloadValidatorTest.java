/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.util;

import com.fsi_crud_api.model.Dispenser;
import com.fsi_crud_api.model.Tank;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Terseer
 */
public class PayloadValidatorTest {

    @Test
    public void validateDispenserPayLoad() {
        Dispenser dispenser = new Dispenser(1L, "MGP002", "MDd", "GAS", "Manual", "Standard", "Local");
        assertEquals(false, PayloadValidator.validateCreateDispenserPayload(dispenser));
    }
     @Test
    public void validateInvalidDispenserPayLoad() {
        Dispenser dispenser = new Dispenser(0, "MGP002", "MDd", "GAS", "Manual", "Standard", "Local");
        assertEquals(true, PayloadValidator.validateCreateDispenserPayload(dispenser));
    }

    @Test
    public void validateTankPayLoad() {
        Tank tank = new Tank(1, "TANK001", "J007", "GAS", 45, new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local"));
        assertEquals(false, PayloadValidator.validateCreateTankPayload(tank));
    }



    @Test
    public void validateInvalidTankPayLoad() {
        Tank tank = new Tank(0, "TANK001", "J007", "GAS", 45, new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local"));
        assertEquals(true, PayloadValidator.validateCreateTankPayload(tank));
    }

}
