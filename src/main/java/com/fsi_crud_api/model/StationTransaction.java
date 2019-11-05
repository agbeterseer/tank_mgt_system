/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Terseer
 */
@Entity
@Table(name = "station_transactions")
public class StationTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //user_id tank_id  vol_left_in_tank vol_sold_by_dispenser transaction_type before_delivery
    @Column(name = "user_id")
    @OneToOne
    private User userId;
    @Column(name = "tank_id")
    @OneToOne
    private Tank tankId;
    @Column(name = "vol_left_in_tank")
    private double volLeftInTank;
    @Column(name = "vol_sold_by_dispenser")
    private double volSoldByDispenser;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "before_delivery")
    private double beforeDelivery;
    @Column(name = "new_product")
    private double newDroduct;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createDateTime;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updateDateTime;

    LocalDateTime now = LocalDateTime.now();
    Timestamp timestamp1 = Timestamp.valueOf(now);

    public StationTransaction() {
    }

    public StationTransaction(Long id, User userId, Tank tankId, double volLeftInTank, double volSoldByDispenser, String transactionType, double beforeDelivery, double new_product, Timestamp createDateTime, Timestamp updateDateTime) {
        this.id = id;
        this.userId = userId;
        this.tankId = tankId;
        this.volLeftInTank = volLeftInTank;
        this.volSoldByDispenser = volSoldByDispenser;
        this.transactionType = transactionType;
        this.beforeDelivery = beforeDelivery;
        this.newDroduct = new_product;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public StationTransaction(User userId, Tank tankId, double volLeftInTank, double volSoldByDispenser, String transactionType, double beforeDelivery) {
        this.userId = userId;
        this.tankId = tankId;
        this.volLeftInTank = volLeftInTank;
        this.volSoldByDispenser = volSoldByDispenser;
        this.transactionType = transactionType;
        this.beforeDelivery = beforeDelivery;
    }

    public StationTransaction(Long id, User userId, Tank tankId, double volLeftInTank, double volSoldByDispenser, String transactionType, Timestamp createDateTime, Timestamp updateDateTime) {
        this.id = id;
        this.userId = userId;
        this.tankId = tankId;
        this.volLeftInTank = volLeftInTank;
        this.volSoldByDispenser = volSoldByDispenser;
        this.transactionType = transactionType;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public StationTransaction(Long id, User userId, Tank tankId, double volLeftInTank, double volSoldByDispenser, String transactionType, double beforeDelivery) {
        this.id = id;
        this.userId = userId;
        this.tankId = tankId;
        this.volLeftInTank = volLeftInTank;
        this.volSoldByDispenser = volSoldByDispenser;
        this.transactionType = transactionType;
        this.beforeDelivery = beforeDelivery;
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

    public Double getVolSoldByDispenser() {
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
        return newDroduct;
    }

    public void setNewProduct(double newProduct) {
        this.newDroduct = newProduct;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp timestamp1) {
        this.createDateTime = timestamp1;
    }

    public Timestamp getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StationTransaction)) {
            return false;
        }
        StationTransaction other = (StationTransaction) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "StationTransaction{" + "id=" + id + ", userId=" + userId + ", tankId=" + tankId + ", volLeftInTank=" + volLeftInTank + ", volSoldByDispenser=" + volSoldByDispenser + ", transactionType=" + transactionType + ", beforeDelivery=" + beforeDelivery + ", newDroduct=" + newDroduct + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + '}';
    }

}
