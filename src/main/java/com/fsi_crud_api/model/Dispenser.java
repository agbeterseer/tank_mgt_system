/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Terseer
 */
@Entity
@Table(name = "dispensers")
public class Dispenser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    @NotBlank
    private String name;
    
    @Column(name = "hscode")
    private String hscode;
    
    @Column(name = "model_no")
    @NotBlank
    private String modelno;
    
    @Column(name = "magnitude_of_discharge")
    @NotBlank
    private String magnitudeofdischarge;
    
    @Column(name = "operation_mode")
    @NotBlank
    private String operationmode;
    
    @Column(name = "oil_transportation_mode")
    @NotBlank
    private String oiltransportationmode;

    public Dispenser() {
    }

    public Dispenser(long id, String name, String hscode, String modelno, String magnitudeofdischarge, String operationmode, String oiltransportationmode) {
        this.id = id;
        this.name = name;
        this.hscode = hscode;
        this.modelno = modelno;
        this.magnitudeofdischarge = magnitudeofdischarge;
        this.operationmode = operationmode;
        this.oiltransportationmode = oiltransportationmode;
    }

    public Dispenser(String name, String hscode, String modelno, String magnitudeofdischarge, String operationmode, String oiltransportationmode) {
        this.name = name;
        this.hscode = hscode;
        this.modelno = modelno;
        this.magnitudeofdischarge = magnitudeofdischarge;
        this.operationmode = operationmode;
        this.oiltransportationmode = oiltransportationmode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getMagnitudeofdischarge() {
        return magnitudeofdischarge;
    }

    public void setMagnitudeofdischarge(String magnitudeofdischarge) {
        this.magnitudeofdischarge = magnitudeofdischarge;
    }

    public String getOperationmode() {
        return operationmode;
    }

    public void setOperationmode(String operationmode) {
        this.operationmode = operationmode;
    }

    public String getOiltransportationmode() {
        return oiltransportationmode;
    }

    public void setOiltransportationmode(String oiltransportationmode) {
        this.oiltransportationmode = oiltransportationmode;
    }

    @Override
    public String toString() {
        return "com.fsi_crud_api.entity.Dispenser[ id=" + id + " ]";
    }

}
