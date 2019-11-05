/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.controller;

import com.fsi_crud_api.exception.DispenserException;
import com.fsi_crud_api.model.Dispenser;
import com.fsi_crud_api.response.Response;
import com.fsi_crud_api.service.IDispenserService;
import com.fsi_crud_api.util.PayloadValidator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Terseer
 */
@RestController
public class DispenserController {

    private static final Logger logger = LoggerFactory.getLogger(DispenserController.class);

    @Autowired
    private IDispenserService dispenserService;

    @RequestMapping(value = "/dispensers", method = RequestMethod.GET)
    public ResponseEntity<List<Dispenser>> getAllDispenser() {
        logger.info("Returning all the Dispensers´s");
        return new ResponseEntity<>(dispenserService.getAllDispensers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/dispensers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Dispenser> getDispenserById(@PathVariable("id") long id) throws DispenserException {
        logger.info("Dispensers id to return " + id);
        Dispenser dispenser = dispenserService.getDispenserById(id);
        if (dispenser == null || dispenser.getId() <= 0) {
            throw new DispenserException("Dispenser doesn´t exist");
        }
        return new ResponseEntity<>(dispenserService.getDispenserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/dispensers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> removeDispenserById(@PathVariable("id") long id) throws DispenserException {
        logger.info("Dispenser id to remove " + id);
        Dispenser dispenser = dispenserService.getDispenserById(id);
        if (dispenser == null || dispenser.getId() <= 0) {
            throw new DispenserException("Dispenser to delete doesn´t exist");
        }
        dispenserService.deleteDispenser(dispenser);
        return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "Dispenser has been deleted"), HttpStatus.OK);
    }

    @RequestMapping(value = "/dispensers", method = RequestMethod.POST)
    public ResponseEntity<Dispenser> addDispenser(@RequestBody Dispenser payload) throws DispenserException {
        logger.info("Payload to save " + payload);
        if (!PayloadValidator.validateCreateDispenserPayload(payload)) {
            throw new DispenserException("Payload malformed, id must not be defined");
        }
        return new ResponseEntity<>(dispenserService.addDispenser(payload), HttpStatus.OK);
    }

    @RequestMapping(value = "/dispensers", method = RequestMethod.PATCH)
    public ResponseEntity<Dispenser> updateDispenser(@RequestBody Dispenser payload) throws DispenserException {
        logger.info("Payload to update " + payload);
        Dispenser dispenser = dispenserService.getDispenserById(payload.getId());
        if (dispenser == null || dispenser.getId() <= 0) {
            throw new DispenserException("Dispenser to update doesn´t exist");
        }
        return new ResponseEntity<>(dispenserService.updateDispenser(payload), HttpStatus.OK);
    }

}
