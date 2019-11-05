/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.util;

import com.fsi_crud_api.model.Dispenser;
import com.fsi_crud_api.model.StationTransaction;
import com.fsi_crud_api.model.Tank;

/**
 *
 * @author Terseer
 */
public class PayloadValidator {
    
    	public static boolean validateCreateTankPayload(Tank tank){
	return tank.getId() <= 0;
	}
        
        public static boolean validateCreateDispenserPayload(Dispenser dispenser){
            return dispenser.getId() <= 0;
	}
       
        public static boolean validateCreateStationTransactionPayload(StationTransaction dispenser){
            
		return dispenser.getId() <= 0;
	}
}
