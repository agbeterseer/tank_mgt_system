/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.controller;

import com.fsi_crud_api.exception.EntityNotFoundException;
import com.fsi_crud_api.exception.ResourceNotFoundException;
import com.fsi_crud_api.exception.TankException;
import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.response.Response;
import com.fsi_crud_api.service.ITankService;
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
public class TankController {

    private static final Logger logger = LoggerFactory.getLogger(TankController.class);

    @Autowired
    private ITankService tankService;

    @RequestMapping(value = "/tanks", method = RequestMethod.GET)
    public ResponseEntity<List<Tank>> getAllTanks() throws TankException {
        logger.info("Returning all the Tanks´s");
        return new ResponseEntity<>(tankService.getAllTanks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/tanks/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tank> getTankById(@PathVariable("id") long id) throws TankException {
        logger.info("Tank id to return " + id);
        Tank tank = tankService.getTankById(id);
      
        if (tank == null) {
            return new ResponseEntity<>(tankService.getTankById(id), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/tanks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> removeTankById(@PathVariable("id") long id) throws TankException {
        logger.info("Tank id to remove " + id);
        Tank tank = tankService.getTankById(id);
        tankService.deleteTank(tank);
        return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "Tank has been deleted"), HttpStatus.OK);
    }

    @RequestMapping(value = "/tanks", method = RequestMethod.POST)
    public ResponseEntity<Tank> addTank(@RequestBody Tank payload) throws TankException, ResourceNotFoundException {
        logger.info("Payload to save " + payload);
      
        if (!PayloadValidator.validateCreateTankPayload(payload)) {
            throw new TankException("Payload malformed, id must not be defined");
        }
        return new ResponseEntity<>(tankService.addTank(payload), HttpStatus.OK);
    }

    @RequestMapping(value = "/tanks", method = RequestMethod.PATCH)
    public ResponseEntity<Tank> updateTank(@RequestBody Tank payload, @PathVariable("id") long id) throws TankException {
        logger.info("Payload to update " + payload);
       
        Tank tank = tankService.updateTank(payload, id);
        return new ResponseEntity<>(tank, HttpStatus.OK);
    }

}
