/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.exception;

/**
 *
 * @author Terseer
 */
public class CurrentVolException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public CurrentVolException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public CurrentVolException() {
        super();
    }
}
