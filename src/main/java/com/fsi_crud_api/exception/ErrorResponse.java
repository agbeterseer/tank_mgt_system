/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.exception;

import java.util.Date;

/**
 *
 * @author Terseer
 */
public class ErrorResponse {

    private Date timestamp;
    private String details;
    private int errorCode;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Date timestamp, String details, int errorCode, String message) {
        this.timestamp = timestamp;
        this.details = details;
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
