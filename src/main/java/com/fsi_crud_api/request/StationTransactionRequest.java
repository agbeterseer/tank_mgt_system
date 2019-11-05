/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.request;

import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.model.User;
import java.sql.Timestamp;

/**
 *
 * @author Terseer
 */
public class StationTransactionRequest {



    private Long id;
    private User userId;
    private Tank tankId;
    private double volLeftInTank;
    private double volSoldByDispenser;
    private String transactionType;
    private double beforeDelivery;
    private double newProduct;
    private Timestamp createDateTime;
    private Timestamp updateDateTime;
    
    
    public StationTransactionRequest() {
    }
    public StationTransactionRequest(Long id, User userId, Tank tankId, double volLeftInTank, double volSoldByDispenser, String transactionType, double beforeDelivery, double newProduct, Timestamp createDateTime, Timestamp updateDateTime) {
        this.id = id;
        this.userId = userId;
        this.tankId = tankId;
        this.volLeftInTank = volLeftInTank;
        this.volSoldByDispenser = volSoldByDispenser;
        this.transactionType = transactionType;
        this.beforeDelivery = beforeDelivery;
        this.newProduct = newProduct;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(double newProduct) {
        this.newProduct = newProduct;
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
        return "StationTransactionRequest{" + "id=" + id + ", userId=" + userId + ", tankId=" + tankId + ", volLeftInTank=" + volLeftInTank + ", volSoldByDispenser=" + volSoldByDispenser + ", transactionType=" + transactionType + ", beforeDelivery=" + beforeDelivery + ", new_product=" + newProduct + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + '}';
    }
    
    
    
}
