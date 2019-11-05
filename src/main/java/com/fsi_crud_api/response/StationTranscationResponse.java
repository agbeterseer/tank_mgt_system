/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.response;

import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.model.User;
import java.sql.Timestamp;

/**
 *
 * @author Terseer
 */
public class StationTranscationResponse {
    
    private User userId; 
    private Tank tankId; 
    private double volLeftInTank; 
    private double volSoldByDispenser; 
    private String transactionType; 
    private double beforeDelivery; 
    private double newDroduct; 
    private Timestamp createDateTime; 
    private Timestamp updateDateTime;

    public StationTranscationResponse(User userId, Tank tankId, double volLeftInTank, double volSoldByDispenser, String transactionType, double beforeDelivery, double newDroduct, Timestamp createDateTime, Timestamp updateDateTime) {
        this.userId = userId;
        this.tankId = tankId;
        this.volLeftInTank = volLeftInTank;
        this.volSoldByDispenser = volSoldByDispenser;
        this.transactionType = transactionType;
        this.beforeDelivery = beforeDelivery;
        this.newDroduct = newDroduct;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Tank getTankId() {
        return tankId;
    }

    public void setTankId(Tank tankId) {
        this.tankId = tankId;
    }

    public double getVolLeftInTank() {
        return volLeftInTank;
    }

    public void setVolLeftInTank(double volLeftInTank) {
        this.volLeftInTank = volLeftInTank;
    }

    public double getVolSoldByDispenser() {
        return volSoldByDispenser;
    }

    public void setVolSoldByDispenser(double volSoldByDispenser) {
        this.volSoldByDispenser = volSoldByDispenser;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getBeforeDelivery() {
        return beforeDelivery;
    }

    public void setBeforeDelivery(double beforeDelivery) {
        this.beforeDelivery = beforeDelivery;
    }

    public double getNewDroduct() {
        return newDroduct;
    }

    public void setNewDroduct(double newDroduct) {
        this.newDroduct = newDroduct;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Timestamp getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "StationTranscationResponse{" + "userId=" + userId + ", tankId=" + tankId + ", volLeftInTank=" + volLeftInTank + ", volSoldByDispenser=" + volSoldByDispenser + ", transactionType=" + transactionType + ", beforeDelivery=" + beforeDelivery + ", newDroduct=" + newDroduct + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + '}';
    }
    
    
    
}
