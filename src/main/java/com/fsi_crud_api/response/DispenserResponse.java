/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.response;

/**
 *
 * @author Terseer
 */
public class DispenserResponse {

    private String name;
    private String hscode;
    private String modelno;
    private String magnitudeofdischarge;
    private String operationmode;
    private String oiltransportationmode;

    public DispenserResponse(String name, String hscode, String modelno, String magnitudeofdischarge, String operationmode, String oiltransportationmode) {
        this.name = name;
        this.hscode = hscode;
        this.modelno = modelno;
        this.magnitudeofdischarge = magnitudeofdischarge;
        this.operationmode = operationmode;
        this.oiltransportationmode = oiltransportationmode;
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
    
    
}
