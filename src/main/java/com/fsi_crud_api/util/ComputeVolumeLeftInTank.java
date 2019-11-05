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
public class ComputeVolumeLeftInTank {

    public double computeVolumeLeftInTank(double previousVol, double volSold) {
        
        return previousVol - volSold;
    }

}
