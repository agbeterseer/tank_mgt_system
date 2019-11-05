/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.util;

/**
 *
 * @author Terseer
 */
public class CurrentVolumLleftValidator {

    public boolean validateCurrentVolIsLessThanPreviousVol(double current_vol_left, double previous_vol_lfet) {

        boolean check_current_vol_left_is_less = (current_vol_left < previous_vol_lfet);

        return check_current_vol_left_is_less;
    }

}
