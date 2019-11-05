/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Terseer
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DispenserNotFoundException extends RuntimeException {

    public DispenserNotFoundException(String exception) {
        super(exception);
    }
}
