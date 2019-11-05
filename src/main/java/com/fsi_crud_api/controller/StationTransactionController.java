/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.controller;

import com.fsi_crud_api.exception.ResourceNotFoundException;
import com.fsi_crud_api.request.StationTransactionRequest;
import com.fsi_crud_api.service.IStationTransactionService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Terseer
 */
@RestController
public class StationTransactionController {

    private static final Logger logger = LoggerFactory.getLogger(DispenserController.class);

    @Autowired
    private IStationTransactionService transactionService;

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public ResponseEntity<StationTransactionRequest> addStationTransaction(@Valid @RequestBody StationTransactionRequest payload) throws ResourceNotFoundException, Exception {
        logger.info("Payload to save " + payload);
        StationTransactionRequest stationTransaction = transactionService.addDailyTransaction(payload);
        return new ResponseEntity<>(stationTransaction, HttpStatus.OK);
    }

}
